package com.demo.admincinefx;

import org.springframework.context.ApplicationContext;

import javafx.concurrent.Task;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public interface ScreenManager {
	
	void changeContent(BorderPane borderPane, FXMLView view);
	public <T> Controller<T> changeContent(BorderPane borderPane, FXMLView view, T model);
	void launchMainScreen(Stage stage);
	void changeMainScreen(FXMLView view);
	<T> ModelDialogController<T> launchDialog(FXMLView view, T type);
	void launchAlert(String title, String header, String content);
	Boolean launchConfirm(String title, String header, String content);
	Boolean launchConfirm(String header, String content);
	Boolean launchConfirm(String content);
	<T> void handleTask(Task<T> task, CallbackHelper<T> helper);
	Node getNodeByID(String idElement);
	ApplicationContext getAppContext();
}
