package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import algorithm.Base;
import algorithm.Direction;
import algorithm.Drone;
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

	private Base controlBase;
	private ArrayList<ImageView> droneImgViews;
	private AnimationTimer time;
	private int droneId;

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

		this.controlBase = new Base(this);
		this.droneId = 0;

		this.droneTableView.itemsProperty().addListener(e -> {
			this.startBtn.setDisable(this.droneTableView.getItems() == null ? true : false);
		});

//		this.time = new AnimationTimer() {
//
//			@Override
//			public void handle(long arg0) {
//				controlBase.moveDrones();
//				for (Drone drone : controlBase.getDrones()) {
//					System.out.println(drone.toString());
//				}
//			}
//
//		};
	}

	private void comboBoxAddListener(ComboBox<String> comboBox) {
		comboBox.getSelectionModel().selectedItemProperty().addListener(e -> {
			this.addDroneBtn.setDisable((comboBox.getSelectionModel().getSelectedItem() == null) ? true : false);
		});
	}

	private void updateTableView() {
		this.idColumn.setCellValueFactory(new PropertyValueFactory<Drone, Integer>("id"));
		this.directionColumn.setCellValueFactory(new PropertyValueFactory<Drone, Direction>("direction"));
		this.velocityColumn.setCellValueFactory(new PropertyValueFactory<Drone, Integer>("velocity"));
		this.durationColumn.setCellValueFactory(new PropertyValueFactory<Drone, Integer>("duration"));

		ObservableList<Drone> drones = FXCollections.observableArrayList(this.controlBase.getDrones());
		this.droneTableView.setItems(drones);
	}

	@FXML
	public void addDrone(ActionEvent event) {
		double direction = reformatComboBoxItem(this.directionComboBox);
		int velocity = (int) reformatComboBoxItem(this.velocityComboBox);
		int duration = (int) reformatComboBoxItem(this.durationComboBox);

		this.controlBase.addDrone(this.droneId, direction, velocity, duration);
		this.droneId++;
		this.clearComboBox();

		this.updateTableView();

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

	@FXML
	public void start(ActionEvent event) {
		this.startBtn.setDisable(true);
//
//		String[] areaSize = this.sizeAreaTextField.getText().split("/");
//		int areaHeight = Integer.parseInt(areaSize[0]);
//		int areaWidth = Integer.parseInt(areaSize[1]);
//
//		int numDrones = Integer.parseInt(this.numDronesTextField.getText());
//
//		this.controlBase = new Base(this, areaHeight, areaWidth, numDrones);
//
//		this.intializeMonitorPane(areaHeight, areaWidth);
//		this.createDrones(numDrones);
//		this.time.start();

	}

	private void createDrones(int numDrones) {
		Image droneImg = new Image("file:/Users/boranorben/Downloads/droneimg.png", 50, 50, false, false);
		this.droneImgViews = new ArrayList<ImageView>(numDrones);

		for (Drone drone : this.controlBase.getDrones()) {
			ImageView droneImgView = new ImageView(droneImg);
			this.droneImgViews.add(droneImgView);

			droneImgView.setX(drone.getX());
			droneImgView.setY(drone.getY());

			this.monitorPane.getChildren().add(droneImgView);
		}
	}

	public void updateDronesPos() {
//		for (Drone drone : this.controlBase.getDrones()) {
//			ImageView imgView = this.droneImgViews.get(drone.getId());
//
//			imgView.setX(drone.getX());
//			imgView.setY(drone.getY());
//			switch (drone.getDirection()) {
//			case N:
//				imgView.setRotate(0);
//				break;
//			case NNE:
//				imgView.setRotate(-22.5);
//				break;
//			case NE:
//				imgView.setRotate(-45);
//				break;
//			case ENE:
//				imgView.setRotate(-67.5);
//				break;
//			case E:
//				imgView.setRotate(-90);
//				break;
//			case ESE:
//				imgView.setRotate(-112.50);
//				break;
//			case SE:
//				imgView.setRotate(-135);
//				break;
//			case SSE:
//				imgView.setRotate(-157.50);
//				break;
//			case S:
//				imgView.setRotate(-180);
//				break;
//			case SSW:
//				imgView.setRotate(-202.50);
//				break;
//			case SW:
//				imgView.setRotate(-225);
//				break;
//			case WSW:
//				imgView.setRotate(-247.50);
//				break;
//			case W:
//				imgView.setRotate(-270);
//				break;
//			case WNW:
//				imgView.setRotate(-292.50);
//				break;
//			case NW:
//				imgView.setRotate(-315);
//				break;
//			case NNW:
//				imgView.setRotate(-337.50);
//				break;
//			default:
//				imgView.setRotate(0);
//				break;
//			}
//		}
	}

}