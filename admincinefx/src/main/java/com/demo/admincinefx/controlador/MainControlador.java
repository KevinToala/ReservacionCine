package com.demo.admincinefx.controlador;

import com.demo.admincinefx.FXMLView;
import com.demo.admincinefx.ScreenManager;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainControlador {
	private @Autowired ScreenManager screenManager;
	private @FXML BorderPane panelContenido;
	
	@FXML
	public void cargarVistaPeliculas(){
		screenManager.changeContent(panelContenido, FXMLView.PELICULAS_VIEW);
	}
	
	@FXML
	public void cargarVistaFunciones(){
		screenManager.changeContent(panelContenido, FXMLView.FUNCIONES_VIEW);
	}
	
	@FXML
	public void mostrarCreditos(){
		screenManager.launchAlert("Creditos", "Aplicación para la administracion del cine",
				"Desarrolladores:" +
						"\n-María José Mosquera Gutiérrez" +
						"\n-Joselyne Daniela Nieves Rodriguez" +
						"\n-Ginger Lisseth Bajaña Olvera");
	}
}
