package com.demo.admincinefx;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientResponseException;

import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

@Component
@Scope("singleton")
public class ScreenManagerImpl implements ScreenManager {
	
	private final ConfigurableApplicationContext springContext;
	private Stage primaryStage;
	
	private Map<String, Scene> scenes = new HashMap<>();
	private Map<String, Pane> panes = new HashMap<>();
	
	private Scene loadScreen(FXMLView view) {

		if (!scenes.containsKey(view.getTitleKey())) {

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(view.getFxmlPath()));
			fxmlLoader.setControllerFactory(springContext::getBean);
			Parent root = null;
			try {
				root = fxmlLoader.load();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			Scene scene = new Scene(root);
			scenes.put(view.getTitleKey(), scene);
			return scene;
		} else {
			return scenes.get(view.getTitleKey());
		}
	}

	@Autowired
	public ScreenManagerImpl(ConfigurableApplicationContext springContext) {
		super();
		this.springContext = springContext;
	}

	@Override
	public void launchMainScreen(Stage stage) {
		Scene scene = loadScreen(FXMLView.MAIN_VIEW);
		if (primaryStage == null) {
			primaryStage = stage;
		}
		primaryStage.setScene(scene);
		primaryStage.setTitle("CINE FX");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	@Override
	public void launchAlert(String title, String header, String content) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.initOwner(primaryStage);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}

	@Override
	public void changeMainScreen(FXMLView view) {
		Scene scene = loadScreen(view);
		primaryStage.setScene(scene);
		primaryStage.setMaximized(true);
		primaryStage.setResizable(false);
	}
	
	@Override
	public Node getNodeByID(String idElement) {
		return primaryStage.getScene().lookup(idElement);
	}
	
	@Override
	public void changeContent(BorderPane borderPane, FXMLView view) {
		Pane pane = loadPane(view);
		borderPane.setCenter(pane);
	}

	private Pane loadPane(FXMLView view) {
		if (!panes.containsKey(view.getTitleKey())) {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(view.getFxmlPath()));
			fxmlLoader.setControllerFactory(springContext::getBean);
			Pane pane = null;
			try {
				pane = fxmlLoader.load();
				panes.put(view.getTitleKey(), pane);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return pane;
		} else {
			return panes.get(view.getTitleKey());
		}
	}
	
	@Override
	public <T> void handleTask(Task<T> task, CallbackHelper<T> helper){
		task.setOnSucceeded(event -> {
			helper.onSuccess(task.getValue());
			helper.allways();
		});
		
		task.setOnFailed(event -> {
			Throwable exception = task.getException();
			
			
			if(exception instanceof RestClientResponseException){
				helper.onFail((RestClientResponseException) exception);
			} else {
				helper.onFail();
			}
			
			helper.allways();
		});
		
		helper.onStart(task);
		new Thread(task).start();
	}
	
	@Override
	public Boolean launchConfirm(String title, String header, String content){
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.initOwner(primaryStage);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);
		Optional<ButtonType> dialogResult = alert.showAndWait();
		if (dialogResult.get().equals(ButtonType.YES)) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	@Override
	public Boolean launchConfirm(String header, String content) {
		return launchConfirm("Confirmación", header, content);
	}
	
	@Override
	public ApplicationContext getAppContext(){
		return this.springContext;
	}
	
	@Override
	public Boolean launchConfirm(String content){
		return launchConfirm("Confirmación", content);
	}
}
