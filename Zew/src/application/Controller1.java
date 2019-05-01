package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import javafx.animation.*;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;

public class Controller1 implements Initializable {
	@FXML
	private ImageView boat;
	@FXML
	private Button help;
	@FXML
	private ImageView farmer;
	@FXML
	private Label helpLb1;
	@FXML
	private Label helpLb2;
	@FXML
	private Label helpLb3;
	@FXML
	private Label helpLb4;
	@FXML
	private Label helpLb5;
	@FXML
	private AnchorPane helpWdw;
	@FXML
	private Button okay;
	@FXML
	private Button SheepB;
	@FXML
	private ImageView sheep;
	@FXML
	private ImageView lion;
	@FXML
	private Button LionB;
	@FXML
	private Label score;
	@FXML
	private AnchorPane GameOverWdw;
	@FXML
	private Button save;

	Story1 story = new Story1();
	Controller controller = new Controller();
	private Herbivorous herbivorous = new Herbivorous();
	private Carnivorous carnivorous = new Carnivorous();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		GameOverWdw.setVisible(false);
		helpWdw.setVisible(false);
		controller.getCrossersOnRightBank().add(herbivorous);
		controller.getCrossersOnRightBank().add(carnivorous);

	}

	// GO BUTTON

	public void Go(ActionEvent event) {

		/**
		 * RotateTransition transition1=new
		 * RotateTransition(Duration.seconds(3),farmer); transition1.setFromAngle(0);
		 * transition1.setToAngle(360);
		 */
		if ((controller.getCrossersOnLeftBank().contains(herbivorous))
				&& (controller.getCrossersOnLeftBank().contains(carnivorous)))
		/*
		 * if (story.isValid(controller.getCrossersOnRightBank(),
		 * controller.getCrossersOnLeftBank(), controller.getBoatRiders()))
		 */ {

			// if (controller.canMove(controller.getCrossersOnRightBank(), true))
			GameOverWdw.setVisible(true);
		} else {

			if (controller.isBoatOnTheLeftBank()) {
				controller.doMove(null, false);
				TranslateTransition transition = new TranslateTransition();
				// transition.setDelay(Duration.seconds(3));
				transition.setDuration(Duration.seconds(6));
				transition.setNode(boat);
				transition.setToX(50);
				TranslateTransition transition1 = new TranslateTransition();
				// transition1.setDelay(Duration.seconds(3));
				transition1.setDuration(Duration.seconds(6));
				transition1.setNode(farmer);
				transition1.setToX(50);

				if (controller.getBoatRiders().contains(herbivorous)) {
					TranslateTransition transition3 = new TranslateTransition();
					// transition2.setDelay(Duration.seconds(3));
					transition3.setDuration(Duration.seconds(6));
					transition3.setNode(sheep);
					transition3.setToX(50);
					transition3.play();

				}

				if (controller.getBoatRiders().contains(carnivorous)) {
					TranslateTransition transition3 = new TranslateTransition();
					// transition2.setDelay(Duration.seconds(3));
					transition3.setDuration(Duration.seconds(6));
					transition3.setNode(lion);
					transition3.setToX(50);
					transition3.play();

				}

				transition1.play();
				transition.play();

			} else {
				controller.doMove(null, false);
				TranslateTransition transition = new TranslateTransition();
				// transition.setDelay(Duration.seconds(3));
				transition.setDuration(Duration.seconds(6));
				transition.setNode(boat);
				transition.setToX(-200);
				TranslateTransition transition2 = new TranslateTransition();
				// transition2.setDelay(Duration.seconds(3));
				transition2.setDuration(Duration.seconds(6));
				transition2.setNode(farmer);
				transition2.setToX(-200);
				transition.play();
				transition2.play();

				if (controller.getBoatRiders().contains(herbivorous)) {
					TranslateTransition transition3 = new TranslateTransition();
					// transition2.setDelay(Duration.seconds(3));
					transition3.setDuration(Duration.seconds(6));
					transition3.setNode(sheep);
					transition3.setToX(-200);
					transition3.play();

				}

				if (controller.getBoatRiders().contains(carnivorous)) {
					TranslateTransition transition3 = new TranslateTransition();
					// transition2.setDelay(Duration.seconds(3));
					transition3.setDuration(Duration.seconds(6));
					transition3.setNode(lion);
					transition3.setToX(-200);
					transition3.play();

				}

			}

			score.setText(Integer.toString(controller.getNumberOfSails()));
			// transition1.play();

		}
	}

	public boolean Disable(Button b) {
		b.setDisable(true);
		return true;

	}

	// GO SHEEP
	public void GoSheep(ActionEvent event) {

		if ((controller.isBoatOnTheLeftBank()) && (controller.getCrossersOnRightBank().contains(herbivorous))) {

			Disable(SheepB);
			SheepB.setDisable(false);

		}

		else if ((!controller.isBoatOnTheLeftBank()) && (controller.getCrossersOnLeftBank().contains(herbivorous))) {

			Disable(SheepB);
			SheepB.setDisable(false);

		}

		else if (controller.getBoatRiders().contains(carnivorous)) {
			Disable(SheepB);
			SheepB.setDisable(false);
		}

		else {

			// controller.moveSheep();
			if (controller.IsSheepOnBoat()) {
				controller.RemoveBoatRiders(herbivorous);
				controller.AddCharacterToBank(herbivorous);

//if (controller.getBoatRiders().contains(herbivorous)) {

				TranslateTransition transition3 = new TranslateTransition();
				// transition3.setDelay(Duration.seconds(3));
				transition3.setDuration(Duration.seconds(1));
				transition3.setNode(sheep);
				transition3.setToY(-10);
				transition3.play();

			}

			else if ((controller.isBoatOnTheLeftBank()) && (controller.getCrossersOnLeftBank().contains(herbivorous))) {

				controller.AddBoatRiders(herbivorous);
				RotateTransition transition1 = new RotateTransition(Duration.seconds(3), sheep);
				transition1.setFromAngle(0);
				transition1.setToAngle(360);
				TranslateTransition transition = new TranslateTransition();
				transition.setDelay(Duration.seconds(3));
				transition.setDuration(Duration.seconds(1));
				transition.setNode(sheep);
				transition.setToY(50);

				transition1.play();
				transition.play();
				controller.getCrossersOnLeftBank().remove(herbivorous);
			}

			else if ((!controller.isBoatOnTheLeftBank())
					&& (controller.getCrossersOnRightBank().contains(herbivorous))) {

				controller.AddBoatRiders(herbivorous);

				RotateTransition transition1 = new RotateTransition(Duration.seconds(3), sheep);
				transition1.setFromAngle(0);
				transition1.setToAngle(360);
				TranslateTransition transition = new TranslateTransition();
				transition.setDelay(Duration.seconds(3));
				transition.setDuration(Duration.seconds(1));
				transition.setNode(sheep);
				transition.setToY(50);

				transition1.play();
				transition.play();

				controller.getCrossersOnRightBank().remove(herbivorous);
			}

			controller.moveSheep();

		}

	}

	// GO LION

	public void GoLion(ActionEvent event) {

		if ((controller.isBoatOnTheLeftBank()) && (controller.getCrossersOnRightBank().contains(carnivorous))) {

			Disable(LionB);
			LionB.setDisable(false);

		}

		else if ((!controller.isBoatOnTheLeftBank()) && (controller.getCrossersOnLeftBank().contains(carnivorous))) {

			Disable(LionB);
			LionB.setDisable(false);

		}

		else if (controller.getBoatRiders().contains(herbivorous)) {
			Disable(LionB);
			LionB.setDisable(false);
		}

		else {

			if (controller.IsLionOnBoat()) {
				controller.RemoveBoatRiders(carnivorous);
				controller.AddCharacterToBank(carnivorous);

				// if (controller.getBoatRiders().contains(herbivorous)) {

				TranslateTransition transition3 = new TranslateTransition();
				// transition3.setDelay(Duration.seconds(3));
				transition3.setDuration(Duration.seconds(1));
				transition3.setNode(lion);
				transition3.setToY(-10);
				transition3.play();

			}

			else if ((controller.isBoatOnTheLeftBank()) && (controller.getCrossersOnLeftBank().contains(carnivorous))) {

				controller.AddBoatRiders(carnivorous);
				RotateTransition transition1 = new RotateTransition(Duration.seconds(3), lion);
				transition1.setFromAngle(0);
				transition1.setToAngle(360);
				TranslateTransition transition = new TranslateTransition();
				transition.setDelay(Duration.seconds(3));
				transition.setDuration(Duration.seconds(1));
				transition.setNode(lion);
				transition.setToY(50);

				transition1.play();
				transition.play();
				controller.getCrossersOnLeftBank().remove(carnivorous);
			}

			else if ((!controller.isBoatOnTheLeftBank())
					&& (controller.getCrossersOnRightBank().contains(carnivorous))) {

				controller.AddBoatRiders(carnivorous);

				RotateTransition transition1 = new RotateTransition(Duration.seconds(3), lion);
				transition1.setFromAngle(0);
				transition1.setToAngle(360);
				TranslateTransition transition = new TranslateTransition();
				transition.setDelay(Duration.seconds(3));
				transition.setDuration(Duration.seconds(1));
				transition.setNode(lion);
				transition.setToY(50);

				transition1.play();
				transition.play();

				controller.getCrossersOnRightBank().remove(carnivorous);
			}

			controller.moveLion();

		}

	}

	public void getHelp() {
		helpWdw.setVisible(true);
		String[] instructions = story.getInstructions();

		helpLb1.setText(instructions[0]);
		helpLb2.setText(instructions[1]);
		helpLb3.setText(instructions[2]);
		helpLb4.setText(instructions[3]);
		helpLb5.setText(instructions[4]);

	}

	public void closeHelp() {
		helpWdw.setVisible(false);

	}

	public void SaveGame(ActionEvent event) {
		controller.saveGame();

	}

}
