package application;

import java.awt.Event;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SampleController implements Initializable {
	@FXML
	private Button exitBtn;
	@FXML
	private ComboBox<String> lvlChoice;
	@FXML
	private Button btn1;
	@FXML
	private ComboBox<String> lvlChoice1;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		lvlChoice.getItems().addAll("Story 1", "Story 2");
		lvlChoice1.getItems().addAll("Story 1", "Story 2");
	}

	Controller controller = new Controller();

	public void actionBtn1(ActionEvent event) throws IOException {
		if (lvlChoice.getValue().equals("Story 1")) {
			Stage stage2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Story1.fxml"));
			Scene scene = new Scene(root, 700, 600);
			stage2.setScene(scene);
			stage2.show();
		}

		else if (lvlChoice.getValue().equals("Story 2")) {

			Stage stage2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Story2.fxml"));
			Scene scene = new Scene(root, 700, 600);
			stage2.setScene(scene);
			stage2.show();

		}

	}

	public void exitGame()  {
		 Stage stage = (Stage) exitBtn.getScene().getWindow();
		 stage.close();
	 }

	public void actionBtn2(ActionEvent event) throws IOException {
		if (lvlChoice1.getValue().equals("Story 1")) {
			controller.loadGame();
		}

	}

}
