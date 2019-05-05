package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
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
	@FXML
	private ImageView cabbage;
	@FXML Button esc;
	@FXML Button sort;

	Story1 story = new Story1();
	MVC1 controller = new MVC1();
	private Herbivorous herbivorous = new Herbivorous();
	private Carnivorous carnivorous = new Carnivorous();
	private Plants plant = new Plants();
	
	private  List<ICrosser> Right = new ArrayList<>();
	public List<ICrosser> Left = new ArrayList<>();
	public List<ICrosser> Boat = new ArrayList<>();


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
//		GameOverWdw.setVisible(false);
//		helpWdw.setVisible(false);
		controller.getCrossersOnRightBank().add(herbivorous);
		controller.getCrossersOnRightBank().add(carnivorous);
		controller.getCrossersOnRightBank().add(plant);

		sheep.setOnMouseClicked(e -> {
			GoSheep();

		});

		lion.setOnMouseClicked(e -> {
			GoLion();

		});

		cabbage.setOnMouseClicked(e -> {

			GoPlant();
		});
	}
	
	
	
	public void Loadinitialize() {

		System.out.println("hena");
		controller.getBoatRiders();
		controller.getCrossersOnRightBank();
		controller.getCrossersOnLeftBank();
		System.out.println("hena2");
	      Sort();
	}
	
	
			

	
	public void Sort() {
		System.out.println("Recieved: "+controller.getCrossersOnLeftBank());
		
		for(int i=0 ; i<controller.getCrossersOnLeftBank().size() ;i++) {
			
		if(controller.getCrossersOnLeftBank().get(i) instanceof Herbivorous) {
			
			TranslateTransition transition3 = new TranslateTransition();
			transition3.setDuration(Duration.seconds(0.1));
			transition3.setNode(sheep);
			transition3.setToX(-210);
			
			transition3.play();
			
		}
		
		
		
		if(controller.getCrossersOnLeftBank().get(i) instanceof Carnivorous) {
				
			System.out.println("ASDF");
			TranslateTransition transition3 = new TranslateTransition();			
			transition3.setDuration(Duration.seconds(0.1));
			transition3.setNode(lion);
			transition3.setToX(-210);
			
			
			
			transition3.play();
			
		}
		
		
		
		
		if(controller.getCrossersOnLeftBank().get(i) instanceof Plants) {
						
			TranslateTransition transition3 = new TranslateTransition();
			transition3.setDuration(Duration.seconds(0.1));
			transition3.setNode(cabbage);
			transition3.setToX(-210);
			
			
			
			transition3.play();
			
		}
		
		
		if(controller.getNumberOfSails() %2== 1) {
			
			TranslateTransition transition3 = new TranslateTransition();
			transition3.setDuration(Duration.seconds(0.1));
			transition3.setNode(boat);
			transition3.setToX(-200);
			
			TranslateTransition transition4 = new TranslateTransition();
			transition4.setDuration(Duration.seconds(0.1));
			transition4.setNode(farmer);
			transition4.setToX(-200);
			
			transition4.play();
			transition3.play();
			
		
			
		
		}
		

//		if (controller.getBoatRiders().get(i) instanceof Herbivorous) {
//			
//			TranslateTransition transition3 = new TranslateTransition();
//			transition3.setDuration(Duration.seconds(0.1));
//			transition3.setNode(sheep);
//			transition3.setToX(-200);
//			transition3.play();
//			
//		}
		
		

//		if (controller.getBoatRiders().contains(carnivorous)) {
//			TranslateTransition transition8 = new TranslateTransition();
//			// transition2.setDelay(Duration.seconds(3));
//			transition8.setDuration(Duration.seconds(3));
//			transition8.setNode(lion);
//			transition8.setToX(-200);
//			transition8.play();
//
//		}
//
//		if (controller.getBoatRiders().contains(plant)) {
//			TranslateTransition transition7 = new TranslateTransition();
//			// transition2.setDelay(Duration.seconds(3));
//			transition7.setDuration(Duration.seconds(3));
//			transition7.setNode(cabbage);
//			transition7.setToX(-200);
//			transition7.play();
//
//		}
//		if (controller.getBoatRiders().get(i) instanceof Herbivorous) {
//			TranslateTransition transition9 = new TranslateTransition();
//			// transition2.setDelay(Duration.seconds(3));
//			transition9.setDuration(Duration.seconds(3));
//			transition9.setNode(sheep);
//			transition9.setToX(-200);
//			transition9.play();
//
//		}
		
		}
		
		
		}
		
//		 else {
//			   System.out.println("11");
//		   }
		
		 
//   if(controller.getCrossersOnLeftBank().contains(carnivorous)) {
//			
//			TranslateTransition transition3 = new TranslateTransition();
//			// transition2.setDelay(Duration.seconds(3));
//			transition3.setDuration(Duration.seconds(1));
//			transition3.setNode(lion);
//			transition3.setToX(-200);
//			transition3.play();
//			
//		}
//   else {
//	   System.out.println("22");
//   }
//   
//   
//   
//   if(controller.getCrossersOnLeftBank().contains(plant)) {
//		
//		TranslateTransition transition3 = new TranslateTransition();
//		// transition2.setDelay(Duration.seconds(3));
//		transition3.setDuration(Duration.seconds(1));
//		transition3.setNode(cabbage);
//		transition3.setToX(-200);
//		transition3.play();
//		
//	}
//   
//   else {
//	   System.out.println("33");
//   }
//   

//    if(controller.getNumberOfSails()%2==1) {
//	      
//    	TranslateTransition transition = new TranslateTransition();
//		transition.setDuration(Duration.seconds(1));
//		transition.setNode(boat);
//		transition.setToX(-200);
//    	transition.play();
//         }
	
    
    
		
	
	
	
	
	// GO BUTTON

	public void Go(ActionEvent event) {

		/**
		 * RotateTransition transition1=new
		 * RotateTransition(Duration.seconds(3),farmer); transition1.setFromAngle(0);
		 * transition1.setToAngle(360);
		 */
		// if ((controller.getCrossersOnLeftBank().contains(herbivorous))
		// && (controller.getCrossersOnLeftBank().contains(carnivorous)))
		/*
		 * if (story.isValid(controller.getCrossersOnRightBank(),
		 * controller.getCrossersOnLeftBank(), controller.getBoatRiders()))
		 */// {

		// if (controller.canMove(controller.getCrossersOnRightBank(), true))
		// GameOverWdw.setVisible(true);
		// } else {

		if (controller.isBoatOnTheLeftBank()) {
			controller.doMove(null, false);
			TranslateTransition transition = new TranslateTransition();
			// transition.setDelay(Duration.seconds(3));
			transition.setDuration(Duration.seconds(3));
			transition.setNode(boat);
			transition.setToX(50);
			TranslateTransition transition1 = new TranslateTransition();
			// transition1.setDelay(Duration.seconds(3));
			transition1.setDuration(Duration.seconds(3));
			transition1.setNode(farmer);
			transition1.setToX(50);

			if (controller.getBoatRiders().contains(herbivorous)) {
				TranslateTransition transition3 = new TranslateTransition();
				// transition2.setDelay(Duration.seconds(3));
				transition3.setDuration(Duration.seconds(3));
				transition3.setNode(sheep);
				transition3.setToX(50);
				transition3.play();

			}

			if (controller.getBoatRiders().contains(carnivorous)) {
				TranslateTransition transition3 = new TranslateTransition();
				// transition2.setDelay(Duration.seconds(3));
				transition3.setDuration(Duration.seconds(3));
				transition3.setNode(lion);
				transition3.setToX(50);
				transition3.play();

			}

			transition1.play();
			transition.play();

			if (controller.getBoatRiders().contains(plant)) {
				TranslateTransition transition3 = new TranslateTransition();
				// transition2.setDelay(Duration.seconds(3));
				transition3.setDuration(Duration.seconds(3));
				transition3.setNode(cabbage);
				transition3.setToX(50);
				transition3.play();

			}

			transition1.play();
			transition.play();

		} else {
			controller.doMove(null, false);
			TranslateTransition transition = new TranslateTransition();
			// transition.setDelay(Duration.seconds(3));
			transition.setDuration(Duration.seconds(3));
			transition.setNode(boat);
			transition.setToX(-200);
			TranslateTransition transition2 = new TranslateTransition();
			// transition2.setDelay(Duration.seconds(3));
			transition2.setDuration(Duration.seconds(3));
			transition2.setNode(farmer);
			transition2.setToX(-200);
			transition.play();
			transition2.play();

			if (controller.getBoatRiders().contains(herbivorous)) {
				TranslateTransition transition3 = new TranslateTransition();
				// transition2.setDelay(Duration.seconds(3));
				transition3.setDuration(Duration.seconds(3));
				transition3.setNode(sheep);
				transition3.setToX(-200);
				transition3.play();

			}

			if (controller.getBoatRiders().contains(carnivorous)) {
				TranslateTransition transition3 = new TranslateTransition();
				// transition2.setDelay(Duration.seconds(3));
				transition3.setDuration(Duration.seconds(3));
				transition3.setNode(lion);
				transition3.setToX(-200);
				transition3.play();

			}

			if (controller.getBoatRiders().contains(plant)) {
				TranslateTransition transition3 = new TranslateTransition();
				// transition2.setDelay(Duration.seconds(3));
				transition3.setDuration(Duration.seconds(3));
				transition3.setNode(cabbage);
				transition3.setToX(-200);
				transition3.play();

			}

		}

		score.setText(Integer.toString(controller.getNumberOfSails()));
		// transition1.play();

	}

	public boolean Disable(Button b) {
		b.setDisable(true);
		return true;

	}

	// GO SHEEP
	public void GoSheep() {

		if ((controller.isBoatOnTheLeftBank()) && (controller.getCrossersOnRightBank().contains(herbivorous))) {

		}

		else if ((!controller.isBoatOnTheLeftBank()) && (controller.getCrossersOnLeftBank().contains(herbivorous))) {

		}

		else if (controller.getBoatRiders().contains(carnivorous) || controller.getBoatRiders().contains(plant)) {

		}

		else {

			if (controller.IsSheepOnBoat()) {
				controller.RemoveBoatRiders(herbivorous);
				controller.AddCharacterToBank(herbivorous);

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

	public void GoLion() {

		if ((controller.isBoatOnTheLeftBank()) && (controller.getCrossersOnRightBank().contains(carnivorous))) {

		}

		else if ((!controller.isBoatOnTheLeftBank()) && (controller.getCrossersOnLeftBank().contains(carnivorous))) {

		}

		else if (controller.getBoatRiders().contains(herbivorous) || controller.getBoatRiders().contains(plant)) {

		}

		else {

			if (controller.IsLionOnBoat()) {
				controller.RemoveBoatRiders(carnivorous);
				controller.AddCharacterToBank(carnivorous);

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

	public void SaveGame(ActionEvent event) throws IOException {
		controller.saveGame();

	}

//GO Plant

	public void GoPlant() {

		if ((controller.isBoatOnTheLeftBank()) && (controller.getCrossersOnRightBank().contains(plant))) {

		}

		else if ((!controller.isBoatOnTheLeftBank()) && (controller.getCrossersOnLeftBank().contains(plant))) {

		}

		else if (controller.getBoatRiders().contains(carnivorous) || controller.getBoatRiders().contains(herbivorous)) {

		}

		else {

			if (controller.IsPlantOnBoat()) {
				controller.RemoveBoatRiders(plant);
				controller.AddCharacterToBank(plant);

				TranslateTransition transition3 = new TranslateTransition();
				// transition3.setDelay(Duration.seconds(3));
				transition3.setDuration(Duration.seconds(1));
				transition3.setNode(cabbage);
				transition3.setToY(-10);
				transition3.play();

			}

			else if ((controller.isBoatOnTheLeftBank()) && (controller.getCrossersOnLeftBank().contains(plant))) {

				controller.AddBoatRiders(plant);
				RotateTransition transition1 = new RotateTransition(Duration.seconds(3), cabbage);
				transition1.setFromAngle(0);
				transition1.setToAngle(360);
				TranslateTransition transition = new TranslateTransition();
				transition.setDelay(Duration.seconds(3));
				transition.setDuration(Duration.seconds(1));
				transition.setNode(cabbage);
				transition.setToY(50);

				transition1.play();
				transition.play();
				controller.getCrossersOnLeftBank().remove(plant);
			}

			else if ((!controller.isBoatOnTheLeftBank()) && (controller.getCrossersOnRightBank().contains(plant))) {

				controller.AddBoatRiders(plant);

				RotateTransition transition1 = new RotateTransition(Duration.seconds(3), cabbage);
				transition1.setFromAngle(0);
				transition1.setToAngle(360);
				TranslateTransition transition = new TranslateTransition();
				transition.setDelay(Duration.seconds(3));
				transition.setDuration(Duration.seconds(1));
				transition.setNode(cabbage);
				transition.setToY(50);

				transition1.play();
				transition.play();

				controller.getCrossersOnRightBank().remove(plant);
			}

			controller.movePlant();

		}

	}
	
	
	
	
	public void esc(ActionEvent event) throws IOException {
	
			Stage stage2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("GUI.fxml"));
			Scene scene = new Scene(root, 700, 600);
			stage2.setScene(scene);
			stage2.show();
		}
}
