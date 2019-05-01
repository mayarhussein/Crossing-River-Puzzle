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





public class Controller2 implements Initializable{
	@FXML private ImageView boat;
	@FXML private Button help;
	@FXML private ImageView farmer1;
	@FXML private ImageView farmer2;
	@FXML private ImageView farmer3;
	@FXML private ImageView farmer4;
	@FXML private ImageView sheep1;
	@FXML private Button farmer1B;
	@FXML private Button farmer2B;
	@FXML private Button farmer3B;
	@FXML private Button farmer4B;
	@FXML private Button sheep2B;
	@FXML private AnchorPane AnchorPane1;
	
	

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		
		
	}
	
	
	
	/**public void Go (ActionEvent event)
	{

		if(controller.isBoatOnTheLeftBank()){
				controller.doMove(null, false);
		TranslateTransition transition= new TranslateTransition();
		//transition.setDelay(Duration.seconds(3));
		transition.setDuration(Duration.seconds(6));
		transition.setNode(boat);
		transition.setToX(50);
		TranslateTransition transition1= new TranslateTransition();
		//transition1.setDelay(Duration.seconds(3));
		transition1.setDuration(Duration.seconds(6));
		transition1.setNode(farmer);
		transition1.setToX(50);
		
		if(controller.getBoatRiders().contains(herbivorous)) {
			TranslateTransition transition3= new TranslateTransition();
		//transition2.setDelay(Duration.seconds(3));
		transition3.setDuration(Duration.seconds(6));
		transition3.setNode(sheep);
		transition3.setToX(50);
		transition3.play();
		
		}
		
		
	}
	*/
	
	
	
	public void GoFarmer1(ActionEvent event) {
		RotateTransition transition1=new RotateTransition(Duration.seconds(3),AnchorPane1);

		transition1.setFromAngle(0);
		transition1.setToAngle(360);
		TranslateTransition transition= new TranslateTransition();
		transition.setDelay(Duration.seconds(3));
		transition.setDuration(Duration.seconds(1));
		transition.setNode(AnchorPane1);
		transition.setToY(60);
		
	
		transition1.play();
		transition.play();
		
		
		
	}
	
}