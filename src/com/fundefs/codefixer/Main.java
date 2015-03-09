package com.fundefs.codefixer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static final double version = 0.0;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("/res/Layout.fxml"));
		stage.setTitle("CodeFixer by Fundefs \u00A9");
		stage.setResizable(false);
		stage.setScene(new Scene(root));
		stage.getIcons().add(new Image(getClass().getResourceAsStream("/res/icon.png")));
		stage.show();
	}

}
