package com.fundefs.codefixer;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;

public class Controller {
	
	@FXML
	TextField txtFile;
	File dir;
	@FXML
	TextArea txtOutput;
	@FXML
	Button btnUpdate;
	
	@FXML
	public void onPressFileSelect(ActionEvent event) throws IOException {
		DirectoryChooser dirCho = new DirectoryChooser();
		dirCho.setTitle("Select directory:");
		if(dir != null && dir.exists())
			dirCho.setInitialDirectory(dir.getParentFile());
		File f = dirCho.showDialog(null);
		if(f == null) {
			txtOutput.setText("Directory selection stoped");
			return;
		}
		if(!f.exists()) {
			txtOutput.setText("Directory not found");
			return;
		}
		dir = f;
		txtFile.setText(f.getAbsolutePath());
		txtOutput.setText("New directory selected.");
	}
	
	@FXML
	public void onPressStart(ActionEvent event) throws InterruptedException {
		long startMillis = System.currentTimeMillis();
		if(dir == null) {
			txtOutput.setText("No directory selected");
			return;
		}
		if(!dir.exists()) {
			txtOutput.setText("Directory not found");
			return;
		}
		txtOutput.setText("Scanning directory");
		List<File> files = FileFixer.getAllFilesOfDir(dir);
		if(files == null) {
			txtOutput.setText("The selected directory is not a directory");
			return;
		}
		if(files.size() == 0) {
			txtOutput.setText("There are no \".java\" files in the selected directory");
			return;
		}
		int startFiles = files.size();			
		FileFixer.fixFiles(files);
		long endMillis = System.currentTimeMillis();
		txtOutput.setText("Finished fixing files\n"
				+ "In total " + startFiles + " files was fixed in " + (double) (endMillis - startMillis) / 1000 + " seconds.\n"
				+ "It took on average ~" + (double) (endMillis - startMillis) / 1000 / startFiles + " per file.");
	}
	
	@FXML
	public void onPressUpdate(ActionEvent event) {
		
	}

}
