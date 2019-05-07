package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.*;
import javafx.event.ActionEvent;

public class Controller2 implements Initializable {
	@FXML private ImageView boat;
	@FXML private Button help;
	@FXML private Label helpLb1;
	@FXML private Label helpLb2;
	@FXML private Label helpLb3;
	@FXML private Label helpLb4;
	@FXML private Label helpLb5;
	@FXML private AnchorPane helpWdw;
	@FXML private ImageView farmer1;
	@FXML private ImageView farmer2;
	@FXML private ImageView farmer3;
	@FXML private ImageView farmer4;
	@FXML private ImageView sheep1;
	@FXML private Button esc;
	@FXML private Button reset;
	@FXML private Button undo;
	@FXML private Label score;
	@FXML  private Button redo;
	@FXML private Button save;

	MVC2 controller2 = new MVC2();
	Story2 story2 = Story2.getStory2();
	Herbivorous animal = Herbivorous.getHerbivorous();
	static Stack<String> undoStack1 = new Stack<>();
	static Stack<String> redoStack1 = new Stack<>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		story2.setFarmers();
		story2.setAnimal(animal);
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

	public void Go() {

		if (story2.isValid(controller2.getCrossersOnLeftBank(), controller2.getCrossersOnRightBank(),
				controller2.getBoatRiders())) {
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
					transition3.setToX(-200);
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
					transition3.setToX(-300);
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
				score.setText(Integer.toString(controller2.getNumberOfSails()));
				undoStack1.push("boat");

			}
			
			score.setText(Integer.toString(controller2.getNumberOfSails()));
		}
		
		else 
			Alert1.displayAlert("Invalid Move","Warning"); 
		
		

		if (story2.gameCompleted(controller2.getCrossersOnLeftBank()))
			Alert1.displayAlert("Game Completed", "\tYAY!\t");
		
		
		
	}

	public void GoFarmer1() {

		if (controller2.isBoatOnTheLeftBank() && controller2.getCrossersOnRightBank().contains(story2.getFarmer1()))
			;

		else if (!controller2.isBoatOnTheLeftBank()
				&& controller2.getCrossersOnLeftBank().contains(story2.getFarmer1()))
			;

		else {
			if (controller2.isOnBoat(story2.getFarmer1())) {
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
					controller2.AddBoatRiders(story2.getFarmer1());
					controller2.getCrossersOnRightBank().remove(story2.getFarmer1());
					RotateTransition transition1 = new RotateTransition(Duration.seconds(3), farmer1);
					transition1.setFromAngle(0);
					transition1.setToAngle(360);
					TranslateTransition transition = new TranslateTransition();
					transition.setDelay(Duration.seconds(3));
					transition.setDuration(Duration.seconds(1));
					transition.setNode(farmer1);
					//transition.setToX(-70);
					transition.setToY(50);

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
	

		undoStack1.push("farmer1");
	}

	public void GoFarmer2() {
		

		if ((controller2.isBoatOnTheLeftBank()) && (controller2.getCrossersOnRightBank().contains(story2.getFarmer2())))
			;

		else if ((!controller2.isBoatOnTheLeftBank())
				&& (controller2.getCrossersOnLeftBank().contains(story2.getFarmer2())))
			;
		else {
			if (controller2.isOnBoat(story2.getFarmer2())) {
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
	
		undoStack1.push("farmer2");

	}

	public void GoFarmer3() {
		

		if ((controller2.isBoatOnTheLeftBank()) && (controller2.getCrossersOnRightBank().contains(story2.getFarmer3())))
			;
		else if ((!controller2.isBoatOnTheLeftBank())
				&& (controller2.getCrossersOnLeftBank().contains(story2.getFarmer3())))
			;
		else {
			if (controller2.isOnBoat(story2.getFarmer3())) {
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
					// transition.setToX(-70);
					transition.setToY(50);

					transition1.play();
					transition.play();

				} else if (controller2.isBoatOnTheLeftBank()) {
					controller2.AddBoatRiders(story2.getFarmer3());
					controller2.getCrossersOnLeftBank().remove(story2.getFarmer3());
					RotateTransition transition1 = new RotateTransition(Duration.seconds(3), farmer3);
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
	
		undoStack1.push("farmer3");

	}

	public void GoFarmer4() {

		if ((controller2.isBoatOnTheLeftBank())
				&& (controller2.getCrossersOnRightBank().contains(story2.getFarmer4())));

		else if ((!controller2.isBoatOnTheLeftBank())
				&& (controller2.getCrossersOnLeftBank().contains(story2.getFarmer4()))) ;
		 else {
			if (controller2.isOnBoat(story2.getFarmer4())) {
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
					 transition.setToX(-50);
					transition.setToY(50);

					transition1.play();
					transition.play();

				} else if (controller2.isBoatOnTheLeftBank()) {
					controller2.AddBoatRiders(story2.getFarmer4());
					controller2.getCrossersOnLeftBank().remove(story2.getFarmer4());
					RotateTransition transition1 = new RotateTransition(Duration.seconds(3), farmer4);
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
	
		undoStack1.push("farmer4");

	}

	public void GoSheep() {

		
		if ((controller2.isBoatOnTheLeftBank())
				&& (controller2.getCrossersOnRightBank().contains(story2.getAnimal()))) ;
		else if ((!controller2.isBoatOnTheLeftBank())
				&& (controller2.getCrossersOnLeftBank().contains(story2.getAnimal())));
		else {
			if (controller2.isOnBoat(story2.getAnimal())) {
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
					transition.setToX(-20);
					transition.setToY(20);

					transition1.play();
					transition.play();

				} else if (controller2.isBoatOnTheLeftBank()) {
					controller2.AddBoatRiders(story2.getAnimal());
					controller2.getCrossersOnLeftBank().remove(story2.getAnimal());
					RotateTransition transition1 = new RotateTransition(Duration.seconds(3), sheep1);
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
	

		undoStack1.push("sheep");

	}
	
	public void esc(ActionEvent event) throws IOException

	{

		Stage stage2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
		AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("GUI.fxml"));
		Scene scene = new Scene(root, 700, 600);
		stage2.setScene(scene);
		stage2.show();

	}
	
	public void getHelp() {
		helpWdw.setVisible(true);
		String[] instructions = story2.getInstructions();

		helpLb1.setText(instructions[0]);
		helpLb2.setText(instructions[1]);
		helpLb3.setText(instructions[2]);
		helpLb4.setText(instructions[3]);
		helpLb5.setText(instructions[4]);

	}

	public void closeHelp() {
		helpWdw.setVisible(false);

	}

	public void reset(ActionEvent event) throws IOException

	{

		Stage stage2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
		AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Story2.fxml"));
		Scene scene = new Scene(root, 700, 600);
		stage2.setScene(scene);
		stage2.show();

	}


	public void undo(ActionEvent event) {

		if (undoStack1.peek().equals("farmer1")) {

			GoFarmer1();
		
			controller2.decreaseMoves("farmer1");

		}

		if (undoStack1.peek().equals("farmer2")) {

			GoFarmer2();
		
			controller2.decreaseMoves("farmer2");

		}

		if (undoStack1.peek().equals("farmer3")) {

			GoFarmer3();
			
			controller2.decreaseMoves("farmer3");

		}

		if (undoStack1.peek().equals("farmer4")) {
			
			GoFarmer4();
			
			controller2.decreaseMoves("farmer4");

		}

		if (undoStack1.peek().equals("sheep")) {
			
			GoSheep();
			
			controller2.decreaseMoves("sheep");

		}

		if (undoStack1.peek().equals("boat")) {
			
			Go();
			
			controller2.decreaseMoves("boat");

		}
		
		String str =undoStack1.pop();
		redoStack1.push(str);
	}
	

	public void redo(ActionEvent event) {

		if (undoStack1.peek().equals("farmer1")) {

			GoFarmer1();
		
		

		}

		if (undoStack1.peek().equals("farmer2")) {

			GoFarmer2();
		
			

		}

		if (undoStack1.peek().equals("farmer3")) {

			GoFarmer3();
			
			

		}

		if (undoStack1.peek().equals("farmer4")) {
			
			GoFarmer4();
			

		}

		if (undoStack1.peek().equals("sheep")) {
			
			GoSheep();
			
			

		}

		if (undoStack1.peek().equals("boat")) {
			
			Go();
			
			

		}
		
		//String str =undoStack1.pop();
		//redoStack1.push(str);
	}
	
	
	
	
	public boolean Disable(Button b) {
		b.setDisable(true);
		return true;

	}

	
	
	
}