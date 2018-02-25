package com.demo.admincinefx;

import javafx.stage.Stage;

public interface ModelDialogController<T> extends Controller<T> {
	void setStage(Stage stage);
	Stage getStage();
	DialogStatus getStatus();
	
	default ModeModelDialog getMode(){
		return null;
	}
}
