package com.demo.admincinefx.controlador;

import com.demo.admincinefx.DTO.FuncionDTO;
import com.demo.admincinefx.DTO.PeliculaDTO;
import com.demo.admincinefx.DTO.SalaDTO;
import com.demo.admincinefx.ScreenManager;
import com.demo.admincinefx.servicios.FuncionService;
import com.demo.admincinefx.servicios.PeliculaServicio;
import com.demo.admincinefx.servicios.SalaService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FuncionesControlador {
	private @Autowired ScreenManager screenManager;
	private @Autowired FuncionService funcionService;
	private @Autowired SalaService salaService;
	private @Autowired PeliculaServicio peliculaServicio;
	
	private @FXML TableView<FuncionDTO> listaFunciones;
	private @FXML TableColumn<FuncionDTO, String> colPelicula;
	private @FXML TableColumn<FuncionDTO, String> colSala;
	private @FXML TableColumn<FuncionDTO, String> colFecha;
	private @FXML TableColumn<FuncionDTO, String> colHorario;
	
	private @FXML ComboBox<SalaDTO> comboBoxSala;
	private @FXML ComboBox<PeliculaDTO> comboBoxPelicula;
	
	private @FXML DatePicker datePickerFecha;
	private @FXML TextField textFieldHora;
	
	@FXML
	public void initialize(){
		colPelicula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPelicula().getTitulo()));
		colSala.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSala().getNombre()));
		colFecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFecha()));
		colHorario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getHorario()));
		
		screenManager.handleTask(
				salaService.obtenerSalas(),
				salas -> comboBoxSala.getItems().setAll(salas)
		);
		
		screenManager.handleTask(
				peliculaServicio.obtenerPeliculas(),
				peliculas -> comboBoxPelicula.getItems().setAll(peliculas)
		);
		
		cargarFunciones();
	}
	
	private void cargarFunciones(){
		screenManager.handleTask(
				funcionService.obtenerFunciones(),
				funciones -> {
					ObservableList<FuncionDTO> observableListFunciones = FXCollections.observableArrayList();
					observableListFunciones.addAll(funciones);
					listaFunciones.setItems(observableListFunciones);
				}
		);
	}
	
	@FXML
	public void crearFuncion(){
		FuncionDTO funcion = new FuncionDTO();
		funcion.setPelicula(comboBoxPelicula.getValue());
		funcion.setSala(comboBoxSala.getValue());
		
		if(datePickerFecha.getValue() != null)
			funcion.setFecha(datePickerFecha.getValue().toString());
		
		funcion.setHorario(textFieldHora.getText());
		
		if(!funcion.esValido()){
			screenManager.launchAlert("Advertencia", "Formulario Invalido",
					"Todos los campos son obligatorios y el horario debe tener el formato HH:MM");
		}
		else {
			screenManager.handleTask(
					funcionService.guardar(funcion),
					nuevaFuncion -> {
						screenManager.launchAlert("Mensaje", "Funcion",
								"Funcion creada exitosamente");
						cargarFunciones();
					}
			);
		}
	}
}
