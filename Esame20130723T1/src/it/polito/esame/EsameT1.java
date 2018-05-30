package it.polito.esame ;

import java.io.IOException;

import it.polito.esame.model.Model;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class EsameT1 extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		
		FXMLLoader loader = new FXMLLoader( this.getClass().getResource("gui/iscrittiT1.fxml")) ;
		BorderPane root = (BorderPane) loader.load() ;
		
		IscrittiController controller = loader.getController();
		Model m = new Model();
		controller.setModel(m);
		
		Scene scene = new Scene(root) ;
		primaryStage.setScene(scene) ;
		primaryStage.show() ;
		
	}


	public static void main(String[] args) {
		launch(args);
	}
}
