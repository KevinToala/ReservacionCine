package com.demo.admincinefx;

public enum FXMLView {

	MAIN_VIEW("main", "/fxml/main.fxml"),
	PELICULAS_VIEW("peliculas", "/fxml/peliculas.fxml"),
	FUNCIONES_VIEW("funciones", "/fxml/funciones.fxml");
	
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
