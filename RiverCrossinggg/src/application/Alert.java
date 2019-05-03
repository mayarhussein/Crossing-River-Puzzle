package application;
import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.Text;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Alert {
 public static void displayAlert (String msg,String title)
 {
	 Stage window=new Stage();
	 window.setTitle(title);
	 window.initModality(Modality.APPLICATION_MODAL);
	 window.setMinWidth(250);
	 
	 
	 
	 VBox layout= new VBox(10);
	 Scene scene = new Scene(layout);
	 
	 Button btn1= new Button("Okay");
	btn1.setOnAction(e->window.close());
	
	Label lb1= new Label(msg);
	
	 
	 
			 
			 
			 
			 layout.getChildren().addAll(btn1,lb1);
			 layout.setAlignment(Pos.CENTER);
			 
			 
			 window.setScene(scene);
			 window.showAndWait();
			 
 }
}
