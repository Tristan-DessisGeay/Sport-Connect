package fr.M2L;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class Main extends Application{
	
	//--module-path "C:\Users\Tristan.LAPTOP-UODU4SRG\Desktop\javafx-sdk-17.0.2\lib" --add-modules javafx.controls,javafx.fxml
	
	private double xPos,yPos;
	private FXMLLoader loader=new FXMLLoader(getClass().getResource("Ressources\\content.fxml")); 
	
	@Override
	public void start(Stage mainWindow) throws Exception {
		
		Parent root=loader.load();
		
		root.setOnMouseDragged((MouseEvent me) -> {
			mainWindow.setX(me.getScreenX()-xPos);
			mainWindow.setY(me.getScreenY()-yPos);
		});
		
		root.setOnMousePressed((MouseEvent e) -> {
			xPos=e.getSceneX();
			yPos=e.getSceneY();
		});
		
		Scene scene=new Scene(root,1000,700,Color.TRANSPARENT);
		
		mainWindow.setScene(scene);
		mainWindow.initStyle(StageStyle.TRANSPARENT);
		mainWindow.setResizable(false);
		mainWindow.setTitle("Sport-Connect");
		mainWindow.show();
	}
	
	public static void main(String [] args) {
		launch(args);
	}

}