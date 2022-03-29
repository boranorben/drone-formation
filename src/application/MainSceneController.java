package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import algorithm.Direction;
import algorithm.Drone;
import algorithm.Simulator;
import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class MainSceneController implements Initializable {

	@FXML
	private ComboBox<String> directionComboBox;

	@FXML
	private ComboBox<String> velocityComboBox;

	@FXML
	private ComboBox<String> durationComboBox;

	@FXML
	private Button addDroneBtn;

	@FXML
	private TableView<Drone> droneTableView;

	@FXML
	private TableColumn<Drone, Integer> idColumn;

	@FXML
	private TableColumn<Drone, Direction> directionColumn;

	@FXML
	private TableColumn<Drone, Integer> velocityColumn;

	@FXML
	private TableColumn<Drone, Integer> durationColumn;

	@FXML
	private Button startBtn;

	@FXML
	private AnchorPane monitorPane;

	private Simulator simulator;
	private int idCnt;
	private double interAddTime;

	private ArrayList<ImageView> droneImgViews;
	private Image droneImg;
	private AnimationTimer time;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// set (0, 0) at bottom left
		this.monitorPane.setScaleX(1);
		this.monitorPane.setScaleY(-1);

		String directions[] = { "0 °", "22.5 °", "45 °", "57.5 °", "90 °" };
		this.directionComboBox.getItems().addAll(directions);
		this.comboBoxAddListener(this.directionComboBox);

		String velocities[] = { "5 m/s", "10 m/s", "15 m/s", "20 m/s" };
		this.velocityComboBox.getItems().addAll(velocities);
		this.comboBoxAddListener(this.velocityComboBox);

		String durations[] = { "20 s", "40 s", "60 s" };
		this.durationComboBox.getItems().addAll(durations);
		this.comboBoxAddListener(this.durationComboBox);

		this.simulator = new Simulator(this);
		this.idCnt = 0;
		this.interAddTime = 0;

//		this.droneTableView.itemsProperty().addListener(e -> {
//			this.startBtn.setDisable(this.droneTableView.getItems() == null ? true : false);
//		});

		this.droneImgViews = new ArrayList<ImageView>();
		this.droneImg = new Image("file:/Users/boranorben/Downloads/droneimg.png", 40, 40, false, false);

		this.time = new AnimationTimer() {
//			private long lastUpdate = 0;

			@Override
			public void handle(long now) {
				System.out.println(now);
				// update every 1 second
//				if (now - this.lastUpdate >= 1_000_000_000) {
//					this.lastUpdate = now;
//					interAddTime = now;
//				}
//				for (Drone drone : simulator.getDrones()) {
//					System.out.println(drone.toString());
//				}
			}

		};
	}

	private void comboBoxAddListener(ComboBox<String> comboBox) {
		comboBox.getSelectionModel().selectedItemProperty().addListener(e -> {
			this.addDroneBtn.setDisable((comboBox.getSelectionModel().getSelectedItem() == null) ? true : false);
		});
	}

	@FXML
	public void addDrone(ActionEvent event) {
		try {
			double direction = reformatComboBoxItem(this.directionComboBox);
			int velocity = (int) reformatComboBoxItem(this.velocityComboBox);
			int duration = (int) reformatComboBoxItem(this.durationComboBox);

			this.simulator.addDrone(this.idCnt, direction, velocity, duration, this.interAddTime);
			this.idCnt++;

			this.clearComboBox();
			this.createDroneImgView();

			this.updateTableView();
		} catch (Exception e) {
			this.addDroneBtn.setDisable(true);
		}
	}

	private double reformatComboBoxItem(ComboBox<String> comboBox) {
		String selectedItem = comboBox.getSelectionModel().getSelectedItem();
		String[] split = selectedItem.split(" ");
		return Double.parseDouble(split[0]);
	}

	@FXML
	private void clearComboBox() {
		this.directionComboBox.getSelectionModel().clearSelection();
		this.directionComboBox.setPromptText("Degree Selection");

		this.velocityComboBox.getSelectionModel().clearSelection();
		this.velocityComboBox.setPromptText("Speed Selection");

		this.durationComboBox.getSelectionModel().clearSelection();
		this.durationComboBox.setPromptText("Time Selection");
	}

	private void updateTableView() {
		this.idColumn.setCellValueFactory(new PropertyValueFactory<Drone, Integer>("id"));
		this.directionColumn.setCellValueFactory(new PropertyValueFactory<Drone, Direction>("direction"));
		this.velocityColumn.setCellValueFactory(new PropertyValueFactory<Drone, Integer>("velocity"));
		this.durationColumn.setCellValueFactory(new PropertyValueFactory<Drone, Integer>("duration"));

		ObservableList<Drone> drones = FXCollections.observableArrayList(this.simulator.getDrones());
		this.droneTableView.setItems(drones);
	}

	private void createDroneImgView() {
		Drone drone = this.simulator.getDrones().get(this.simulator.getDrones().size() - 1);

		ImageView droneImgView = new ImageView(this.droneImg);
		this.droneImgViews.add(droneImgView);

		droneImgView.setX(drone.getX());
		droneImgView.setY(drone.getY());

		this.monitorPane.getChildren().add(droneImgView);
	}

	@FXML
	public void start(ActionEvent event) {
		this.startBtn.setDisable(true);
		this.time.start();
		// not responsive
		this.simulator.startEvents();
	}

	public void updateDronesPos() {
		for (Drone drone : this.simulator.getDrones()) {

			ImageView imgView = this.droneImgViews.get(drone.getId());
			imgView.setX(drone.getX());
			imgView.setY(drone.getY());
			imgView.setRotate(-drone.getDirection().degree);
		}
	}

}