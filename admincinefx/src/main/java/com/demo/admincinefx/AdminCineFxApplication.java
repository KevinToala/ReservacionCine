package com.demo.admincinefx;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AdminCineFxApplication extends Application {
	private ConfigurableApplicationContext springContext;
	private ScreenManager screenManager;
	
	public static void main(String[] args){
		Application.launch(args);
	}
	
	@Override
	public void init() throws Exception {
		springContext = SpringApplication.run(AdminCineFxApplication.class);
		BeanFactory factory = springContext.getAutowireCapableBeanFactory();
		screenManager = factory.getBean(ScreenManager.class);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		screenManager.launchMainScreen(stage);
	}
	
	@Override
	public void stop() throws Exception {
		springContext.close();
	}
}
