package com.demo.admincinefx;

public enum FXMLView {

	MAIN_VIEW("main","/fxml/main.fxml");
	
	private final String titleKey;
	private final String filePath;
	
	FXMLView(String titleKey, String filePath){
		this.titleKey = titleKey;
		this.filePath = filePath;
	}
	
	public String getTitleKey(){
		return titleKey;
	}
	
	public String getFxmlPath(){
		return filePath;
	}
}
