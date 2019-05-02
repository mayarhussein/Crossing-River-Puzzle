package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import javafx.animation.*;
import javafx.event.ActionEvent;

public class Controller2 implements Initializable {
	@FXML
	private ImageView boat;
	@FXML
	private Button help;
	@FXML
	private ImageView farmer1;
	@FXML
	private ImageView farmer2;
	@FXML
	private ImageView farmer3;
	@FXML
	private ImageView farmer4;
	@FXML
	private ImageView sheep1;

	


	ControlStory2 controller2 = ControlStory2.getControlStory2();
	Story2 story2 = Story2.getStory2();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
story2.setFarmers();
		controller2.getCrossersOnRightBank().add(story2.getFarmer1());
		controller2.getCrossersOnRightBank().add(story2.getFarmer2());
		controller2.getCrossersOnRightBank().add(story2.getFarmer3());
		controller2.getCrossersOnRightBank().add(story2.getFarmer4());
		controller2.getCrossersOnRightBank().add(story2.getAnimal());
		farmer1.setOnMouseClicked(e -> {
			GoFarmer1();

		});
		farmer2.setOnMouseClicked(e -> {
			GoFarmer2();

		});
		farmer3.setOnMouseClicked(e -> {

			GoFarmer3();
		});
		farmer4.setOnMouseClicked(e -> {
			GoFarmer4();
		});
		sheep1.setOnMouseClicked(e -> {
         GoSheep();
		
		});
	}

	public void Go(ActionEvent event) {
		
		if(story2.isValid(controller2.getCrossersOnLeftBank(), controller2.getCrossersOnRightBank(), controller2.getBoatRiders()));
		else {
		if (controller2.isBoatOnTheLeftBank()) {

			controller2.doMove(null, false);
			TranslateTransition transition = new TranslateTransition();
			// transition.setDelay(Duration.seconds(3));
			transition.setDuration(Duration.seconds(6));
			transition.setNode(boat);
			transition.setToX(50);
			transition.play();

			if (controller2.getBoatRiders().contains(story2.getFarmer1())) {
				TranslateTransition transition3 = new TranslateTransition();
				// transition2.setDelay(Duration.seconds(3));
				transition3.setDuration(Duration.seconds(6));
				transition3.setNode(farmer1);
				transition3.setToX(50);
				transition3.play();
			}

			if (controller2.getBoatRiders().contains(story2.getFarmer2())) {
				TranslateTransition transition3 = new TranslateTransition();
				// transition2.setDelay(Duration.seconds(3));
				transition3.setDuration(Duration.seconds(6));
				transition3.setNode(farmer2);
				transition3.setToX(50);
				transition3.play();
			}

			if (controller2.getBoatRiders().contains(story2.getFarmer3())) {
				TranslateTransition transition3 = new TranslateTransition();
				// transition2.setDelay(Duration.seconds(3));
				transition3.setDuration(Duration.seconds(6));
				transition3.setNode(farmer3);
				transition3.setToX(50);
				transition3.play();
			}

			if (controller2.getBoatRiders().contains(story2.getFarmer4())) {
				TranslateTransition transition3 = new TranslateTransition();
				// transition2.setDelay(Duration.seconds(3));
				transition3.setDuration(Duration.seconds(6));
				transition3.setNode(farmer4);
				transition3.setToX(50);
				transition3.play();
			}

			if (controller2.getBoatRiders().contains(story2.getAnimal())) {
				TranslateTransition transition3 = new TranslateTransition();
				// transition2.setDelay(Duration.seconds(3));
				transition3.setDuration(Duration.seconds(6));
				transition3.setNode(sheep1);
				transition3.setToX(50);
				transition3.play();
			}

		}
		
		else {
			controller2.doMove(null, false);
			TranslateTransition transition2 = new TranslateTransition();
			// transition.setDelay(Duration.seconds(3));
			transition2.setDuration(Duration.seconds(6));
			transition2.setNode(boat);
			transition2.setToX(-200);
			transition2.play();

			if (controller2.getBoatRiders().contains(story2.getFarmer1())) {
				TranslateTransition transition3 = new TranslateTransition();
				// transition2.setDelay(Duration.seconds(3));
				transition3.setDuration(Duration.seconds(6));
				transition3.setNode(farmer1);
				transition3.setToX(-300);
				transition3.play();
			}

			if (controller2.getBoatRiders().contains(story2.getFarmer2())) {
				TranslateTransition transition3 = new TranslateTransition();
				// transition2.setDelay(Duration.seconds(3));
				transition3.setDuration(Duration.seconds(6));
				transition3.setNode(farmer2);
				transition3.setToX(-300);
				transition3.play();
			}

			if (controller2.getBoatRiders().contains(story2.getFarmer3())) {
				TranslateTransition transition3 = new TranslateTransition();
				// transition2.setDelay(Duration.seconds(3));
				transition3.setDuration(Duration.seconds(6));
				transition3.setNode(farmer3);
				transition3.setToX(-200);
				transition3.play();
			}

			if (controller2.getBoatRiders().contains(story2.getFarmer4())) {
				TranslateTransition transition3 = new TranslateTransition();
				// transition2.setDelay(Duration.seconds(3));
				transition3.setDuration(Duration.seconds(6));
				transition3.setNode(farmer4);
				transition3.setToX(-200);
				transition3.play();
			}

			if (controller2.getBoatRiders().contains(story2.getAnimal())) {
				TranslateTransition transition3 = new TranslateTransition();
				// transition2.setDelay(Duration.seconds(3));
				transition3.setDuration(Duration.seconds(6));
				transition3.setNode(sheep1);
				transition3.setToX(-200);
				transition3.play();
			}

		}

	}
	}

	public void GoFarmer1() {

		if ((controller2.isBoatOnTheLeftBank())
				&& (controller2.getCrossersOnRightBank().contains(story2.getFarmer1()))) {
		

		}

		else if ((!controller2.isBoatOnTheLeftBank())
				&& (controller2.getCrossersOnLeftBank().contains(story2.getFarmer1()))) {
			

		} else {
			if (controller2.IsOnBoat(story2.getFarmer1())) {
				controller2.removeBoat(story2.getFarmer1());
				// controller2.RemoveBoatRiders(story2.getFarmer1());
				TranslateTransition transition3 = new TranslateTransition();
				// transition3.setDelay(Duration.seconds(3));
				transition3.setDuration(Duration.seconds(1));
				transition3.setNode(farmer1);
				transition3.setToY(-20);
				transition3.play();
				controller2.moveCrosser(story2.getFarmer1());

			}

			else {

				if (!controller2.isBoatOnTheLeftBank()) {
					System.out.println("Right");
					controller2.AddBoatRiders(story2.getFarmer1());
					controller2.getCrossersOnRightBank().remove(story2.getFarmer1());
					RotateTransition transition1 = new RotateTransition(Duration.seconds(3), farmer1);
					transition1.setFromAngle(0);
					transition1.setToAngle(360);
					TranslateTransition transition = new TranslateTransition();
					transition.setDelay(Duration.seconds(3));
					transition.setDuration(Duration.seconds(1));
					transition.setNode(farmer1);
					transition.setToX(-70);
					transition.setToY(70);

					transition1.play();
					transition.play();

				} else if (controller2.isBoatOnTheLeftBank()) {
					controller2.AddBoatRiders(story2.getFarmer1());
					controller2.getCrossersOnLeftBank().remove(story2.getFarmer1());
					RotateTransition transition1 = new RotateTransition(Duration.seconds(3), farmer1);
					transition1.setFromAngle(0);
					transition1.setToAngle(360);
					TranslateTransition transition = new TranslateTransition();
					transition.setDelay(Duration.seconds(3));
					transition.setDuration(Duration.seconds(1));
					transition.setNode(farmer1);
					// transition.setToX(-70);
					transition.setToY(50);

					transition1.play();
					transition.play();

				}

				controller2.moveCrosser(story2.getFarmer1());

			}

		}

	}

	public void GoFarmer2() {
		/**
		 * controller2.AddBoatRiders(story2.getFarmer2()); RotateTransition transition1
		 * = new RotateTransition(Duration.seconds(3), AnchorPane2);
		 * transition1.setFromAngle(0); transition1.setToAngle(360); TranslateTransition
		 * transition = new TranslateTransition();
		 * transition.setDelay(Duration.seconds(3));
		 * transition.setDuration(Duration.seconds(1)); transition.setNode(AnchorPane2);
		 * transition.setToX(-70); transition.setToY(70);
		 * 
		 * transition1.play(); transition.play();
		 * 
		 * controller2.moveFarmer1();
		 */

		if ((controller2.isBoatOnTheLeftBank())
				&& (controller2.getCrossersOnRightBank().contains(story2.getFarmer2()))) {
		

		}

		else if ((!controller2.isBoatOnTheLeftBank())
				&& (controller2.getCrossersOnLeftBank().contains(story2.getFarmer2()))) {
		//	Disable(farmer2B);
			//farmer2B.setDisable(false);

		} else {
			if (controller2.IsOnBoat(story2.getFarmer2())) {
				controller2.removeBoat(story2.getFarmer2());
				// controller2.RemoveBoatRiders(story2.getFarmer1());
				TranslateTransition transition3 = new TranslateTransition();
				// transition3.setDelay(Duration.seconds(3));
				transition3.setDuration(Duration.seconds(1));
				transition3.setNode(farmer2);
				transition3.setToY(-40);
				transition3.play();
				controller2.moveCrosser(story2.getFarmer2());

			}

			else {

				if (!controller2.isBoatOnTheLeftBank()) {
					controller2.AddBoatRiders(story2.getFarmer2());
					controller2.getCrossersOnRightBank().remove(story2.getFarmer2());
					RotateTransition transition1 = new RotateTransition(Duration.seconds(3), farmer2);
					transition1.setFromAngle(0);
					transition1.setToAngle(360);
					TranslateTransition transition = new TranslateTransition();
					transition.setDelay(Duration.seconds(3));
					transition.setDuration(Duration.seconds(1));
					transition.setNode(farmer2);
					transition.setToX(-70);
					transition.setToY(70);

					transition1.play();
					transition.play();

				} else if (controller2.isBoatOnTheLeftBank()) {
					controller2.AddBoatRiders(story2.getFarmer2());
					controller2.getCrossersOnLeftBank().remove(story2.getFarmer2());
					RotateTransition transition1 = new RotateTransition(Duration.seconds(3), farmer2);
					transition1.setFromAngle(0);
					transition1.setToAngle(360);
					TranslateTransition transition = new TranslateTransition();
					transition.setDelay(Duration.seconds(3));
					transition.setDuration(Duration.seconds(1));
					transition.setNode(farmer2);
					// transition.setToX(-70);
					transition.setToY(50);

					transition1.play();
					transition.play();

				}

				controller2.moveCrosser(story2.getFarmer2());

			}

		}

	}

	public void GoFarmer3() {
		//controller2.AddBoatRiders(story2.getFarmer3());
		//RotateTransition transition1 = new RotateTransition(Duration.seconds(3), AnchorPane3);
		//transition1.setFromAngle(0);
		//transition1.setToAngle(360);
		//TranslateTransition transition = new TranslateTransition();
		//transition.setDelay(Duration.seconds(3));
		//transition.setDuration(Duration.seconds(1));
		//transition.setNode(AnchorPane3);
		//transition.setToY(20);

		//transition1.play();
		//transition.play();

		// controller2.moveFarmer(story2.getFarmer3());
		
		if ((controller2.isBoatOnTheLeftBank())
				&& (controller2.getCrossersOnRightBank().contains(story2.getFarmer3()))) {
			//Disable(farmer3B);
			//farmer1B.setDisable(false);

		}

		else if ((!controller2.isBoatOnTheLeftBank())
				&& (controller2.getCrossersOnLeftBank().contains(story2.getFarmer3()))) {
			//Disable(farmer1B);
			//farmer1B.setDisable(false);
			

		} else {
			if (controller2.IsOnBoat(story2.getFarmer3())) {
				controller2.removeBoat(story2.getFarmer3());
				// controller2.RemoveBoatRiders(story2.getFarmer1());
				TranslateTransition transition3 = new TranslateTransition();
				// transition3.setDelay(Duration.seconds(3));
				transition3.setDuration(Duration.seconds(1));
				transition3.setNode(farmer3);
				transition3.setToY(-20);
				transition3.play();
				controller2.moveCrosser(story2.getFarmer3());

			}

			else {

				if (!controller2.isBoatOnTheLeftBank()) {
					
					controller2.AddBoatRiders(story2.getFarmer3());
					controller2.getCrossersOnRightBank().remove(story2.getFarmer3());
					RotateTransition transition1 = new RotateTransition(Duration.seconds(3), farmer3);
					transition1.setFromAngle(0);
					transition1.setToAngle(360);
					TranslateTransition transition = new TranslateTransition();
					transition.setDelay(Duration.seconds(3));
					transition.setDuration(Duration.seconds(1));
					transition.setNode(farmer3);
					//transition.setToX(-70);
					transition.setToY(20);

					transition1.play();
					transition.play();

				} else if (controller2.isBoatOnTheLeftBank()) {
					controller2.AddBoatRiders(story2.getFarmer3());
					controller2.getCrossersOnLeftBank().remove(story2.getFarmer3());
					RotateTransition transition1 = new RotateTransition(Duration.seconds(3),farmer3);
					transition1.setFromAngle(0);
					transition1.setToAngle(360);
					TranslateTransition transition = new TranslateTransition();
					transition.setDelay(Duration.seconds(3));
					transition.setDuration(Duration.seconds(1));
					transition.setNode(farmer3);
					// transition.setToX(-70);
					transition.setToY(50);

					transition1.play();
					transition.play();

				}

				controller2.moveCrosser(story2.getFarmer3());

			}

		}
		

	}

	public void GoFarmer4() {

		/**controller2.AddBoatRiders(story2.getFarmer4());
		RotateTransition transition1 = new RotateTransition(Duration.seconds(3), AnchorPane4);
		transition1.setFromAngle(0);
		transition1.setToAngle(360);
		TranslateTransition transition = new TranslateTransition();
		transition.setDelay(Duration.seconds(3));
		transition.setDuration(Duration.seconds(1));
		transition.setNode(AnchorPane4);
		transition.setToY(50);

		transition1.play();
		transition.play();

		// controller2.moveFarmer(story2.getFarmer4());
*/
		if ((controller2.isBoatOnTheLeftBank())
				&& (controller2.getCrossersOnRightBank().contains(story2.getFarmer4()))) {
			//Disable(farmer3B);
			//farmer1B.setDisable(false);

		}

		else if ((!controller2.isBoatOnTheLeftBank())
				&& (controller2.getCrossersOnLeftBank().contains(story2.getFarmer4()))) {
			//Disable(farmer1B);
			//farmer1B.setDisable(false);

		} else {
			if (controller2.IsOnBoat(story2.getFarmer4())) {
				controller2.removeBoat(story2.getFarmer4());
				// controller2.RemoveBoatRiders(story2.getFarmer1());
				TranslateTransition transition3 = new TranslateTransition();
				// transition3.setDelay(Duration.seconds(3));
				transition3.setDuration(Duration.seconds(1));
				transition3.setNode(farmer4);
				transition3.setToY(-20);
				transition3.play();
				controller2.moveCrosser(story2.getFarmer4());

			}

			else {

				if (!controller2.isBoatOnTheLeftBank()) {
					System.out.println("Right");
					controller2.AddBoatRiders(story2.getFarmer4());
					controller2.getCrossersOnRightBank().remove(story2.getFarmer4());
					RotateTransition transition1 = new RotateTransition(Duration.seconds(3), farmer4);
					transition1.setFromAngle(0);
					transition1.setToAngle(360);
					TranslateTransition transition = new TranslateTransition();
					transition.setDelay(Duration.seconds(3));
					transition.setDuration(Duration.seconds(1));
					transition.setNode(farmer4);
					//transition.setToX(-70);
					transition.setToY(20);

					transition1.play();
					transition.play();

				} else if (controller2.isBoatOnTheLeftBank()) {
					controller2.AddBoatRiders(story2.getFarmer4());
					controller2.getCrossersOnLeftBank().remove(story2.getFarmer4());
					RotateTransition transition1 = new RotateTransition(Duration.seconds(3),farmer4);
					transition1.setFromAngle(0);
					transition1.setToAngle(360);
					TranslateTransition transition = new TranslateTransition();
					transition.setDelay(Duration.seconds(3));
					transition.setDuration(Duration.seconds(1));
					transition.setNode(farmer4);
					// transition.setToX(-70);
					transition.setToY(50);

					transition1.play();
					transition.play();

				}

				controller2.moveCrosser(story2.getFarmer4());

			}

		}
		
	}
		public void GoSheep() {

			/**controller2.AddBoatRiders(story2.getFarmer4());
			RotateTransition transition1 = new RotateTransition(Duration.seconds(3), AnchorPane4);
			transition1.setFromAngle(0);
			transition1.setToAngle(360);
			TranslateTransition transition = new TranslateTransition();
			transition.setDelay(Duration.seconds(3));
			transition.setDuration(Duration.seconds(1));
			transition.setNode(AnchorPane4);
			transition.setToY(50);

			transition1.play();
			transition.play();

			// controller2.moveFarmer(story2.getFarmer4());
	*/
			if ((controller2.isBoatOnTheLeftBank())
					&& (controller2.getCrossersOnRightBank().contains(story2.getAnimal()))) {
				//Disable(farmer3B);
				//farmer1B.setDisable(false);

			}

			else if ((!controller2.isBoatOnTheLeftBank())
					&& (controller2.getCrossersOnLeftBank().contains(story2.getAnimal()))) {
				//Disable(farmer1B);
				//farmer1B.setDisable(false);

			} else {
				if (controller2.IsOnBoat(story2.getAnimal())) {
					controller2.removeBoat(story2.getAnimal());
					// controller2.RemoveBoatRiders(story2.getFarmer1());
					TranslateTransition transition3 = new TranslateTransition();
					// transition3.setDelay(Duration.seconds(3));
					transition3.setDuration(Duration.seconds(1));
					transition3.setNode(sheep1);
					transition3.setToY(-20);
					transition3.play();
					controller2.moveCrosser(story2.getAnimal());

				}

				else {

					if (!controller2.isBoatOnTheLeftBank()) {
						
						controller2.AddBoatRiders(story2.getAnimal());
						controller2.getCrossersOnRightBank().remove(story2.getAnimal());
						RotateTransition transition1 = new RotateTransition(Duration.seconds(3), sheep1);
						transition1.setFromAngle(0);
						transition1.setToAngle(360);
						TranslateTransition transition = new TranslateTransition();
						transition.setDelay(Duration.seconds(3));
						transition.setDuration(Duration.seconds(1));
						transition.setNode(sheep1);
						//transition.setToX(-70);
						transition.setToY(20);

						transition1.play();
						transition.play();

					} else if (controller2.isBoatOnTheLeftBank()) {
						controller2.AddBoatRiders(story2.getAnimal());
						controller2.getCrossersOnLeftBank().remove(story2.getAnimal());
						RotateTransition transition1 = new RotateTransition(Duration.seconds(3),sheep1);
						transition1.setFromAngle(0);
						transition1.setToAngle(360);
						TranslateTransition transition = new TranslateTransition();
						transition.setDelay(Duration.seconds(3));
						transition.setDuration(Duration.seconds(1));
						transition.setNode(sheep1);
						// transition.setToX(-70);
						transition.setToY(50);

						transition1.play();
						transition.play();

					}

					controller2.moveCrosser(story2.getAnimal());

				}

			}
			
			
			
			
			
			
			
		}
		
	

		
		
		
	

	public boolean Disable(Button b) {
		b.setDisable(true);
		return true;

	}

}