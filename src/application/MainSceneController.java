package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import algorithm.Base;
import algorithm.Drone;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class MainSceneController implements Initializable {

	@FXML
	private TextField numDronesTextField;

	@FXML
	private TextField sizeAreaTextField;

	@FXML
	private Button startBtn;

	@FXML
	private AnchorPane monitorPane;

	private Base controlBase;
	private ArrayList<ImageView> droneImgViews;
	private AnimationTimer time;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.numDronesTextField.textProperty().addListener(event -> {
			try {
				int numDrones = Integer.parseInt(this.numDronesTextField.getText());
				if (numDrones > 1 && numDrones <= 100 && this.numDronesTextField.getText() != null) {
					this.startBtn.setDisable(false);
				} else {
					this.startBtn.setDisable(true);
				}
			} catch (Exception error) {
				this.startBtn.setDisable(true);
			}
		});

		this.sizeAreaTextField.textProperty().addListener(event -> {
			try {
				String[] areaSize = this.sizeAreaTextField.getText().split("/");
				int areaHeight = Integer.parseInt(areaSize[0]);
				int areaWidth = Integer.parseInt(areaSize[1]);
				if (areaHeight == areaWidth && areaHeight > 0 && areaWidth > 0) {
					this.startBtn.setDisable(false);
				} else {
					this.startBtn.setDisable(true);
				}
			} catch (Exception e) {
				this.startBtn.setDisable(true);
			}
		});

		this.time = new AnimationTimer() {

			@Override
			public void handle(long arg0) {
				controlBase.moveDrones();
//				for (Drone drone : controlBase.getDrones()) {
//					System.out.println(drone.toString());
//				}
			}

		};
	}

	@FXML
	void start(ActionEvent event) {
		this.startBtn.setDisable(true);
		this.sizeAreaTextField.setDisable(true);
		this.numDronesTextField.setDisable(true);

		String[] areaSize = this.sizeAreaTextField.getText().split("/");
		int areaHeight = Integer.parseInt(areaSize[0]);
		int areaWidth = Integer.parseInt(areaSize[1]);

		int numDrones = Integer.parseInt(this.numDronesTextField.getText());

		this.controlBase = new Base(this, areaHeight, areaWidth, numDrones);

		this.intializeMonitorPane(areaHeight, areaWidth);
		this.createDrones(numDrones);
		this.time.start();

	}

	private void intializeMonitorPane(double height, double width) {
		// set (0, 0) at bottom left
		this.monitorPane.setScaleX(1);
		this.monitorPane.setScaleY(-1);

		this.monitorPane.setPrefSize(height, width);
	}

	private void createDrones(int numDrones) {
		Image droneImg = new Image("file:/Users/boranorben/Downloads/droneimg.png", 25, 25, false, false);
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
		for (Drone drone : this.controlBase.getDrones()) {
			ImageView imgView = this.droneImgViews.get(drone.getId());

			imgView.setX(drone.getX());
			imgView.setY(drone.getY());
			switch (drone.getDirection()) {
			case N:
				imgView.setRotate(0);
				break;
			case NNE:
				imgView.setRotate(-22.5);
				break;
			case NE:
				imgView.setRotate(-45);
				break;
			case ENE:
				imgView.setRotate(-67.5);
				break;
			case E:
				imgView.setRotate(-90);
				break;
			case ESE:
				imgView.setRotate(-112.50);
				break;
			case SE:
				imgView.setRotate(-135);
				break;
			case SSE:
				imgView.setRotate(-157.50);
				break;
			case S:
				imgView.setRotate(-180);
				break;
			case SSW:
				imgView.setRotate(-202.50);
				break;
			case SW:
				imgView.setRotate(-225);
				break;
			case WSW:
				imgView.setRotate(-247.50);
				break;
			case W:
				imgView.setRotate(-270);
				break;
			case WNW:
				imgView.setRotate(-292.50);
				break;
			case NW:
				imgView.setRotate(-315);
				break;
			case NNW:
				imgView.setRotate(-337.50);
				break;
			default:
				imgView.setRotate(0);
				break;
			}
		}
	}

}