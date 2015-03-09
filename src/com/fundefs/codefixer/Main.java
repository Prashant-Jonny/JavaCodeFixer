package com.fundefs.codefixer;

import com.fundefs.codefixer.update.UpdateManager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static final String version = "0.1.0.0";
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource(UpdateManager.versionIsNewest() ? "/res/Layout.fxml" : "/res/LayoutUpdate.fxml"));
		stage.setTitle("CodeFixer by Fundefs \u00A9");
		stage.setResizable(false);
		stage.setScene(new Scene(root));
		stage.getIcons().add(new Image(getClass().getResourceAsStream("/res/icon.png")));
		stage.show();
	}

}
