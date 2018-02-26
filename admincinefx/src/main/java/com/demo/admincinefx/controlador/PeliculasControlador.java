package com.demo.admincinefx.controlador;

import com.demo.admincinefx.DTO.PeliculaDTO;
import com.demo.admincinefx.ScreenManager;
import com.demo.admincinefx.servicios.PeliculaServicio;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PeliculasControlador {
	private @Autowired ScreenManager screenManager;
	private @Autowired PeliculaServicio peliculaServicio;
	
	private @FXML TableView<PeliculaDTO> listaPeliculas;
	private @FXML TableColumn<PeliculaDTO, String> colTitulo;
	private @FXML TableColumn<PeliculaDTO, String> colDuracion;
	private @FXML TableColumn<PeliculaDTO, String> colGenero;
	
	private @FXML TextField textFieldTitulo;
	private @FXML TextArea textAreaDescripcion;
	private @FXML TextField textFieldUrlImagen;
	private @FXML ComboBox<String> comboBoxGenero;
	private @FXML Spinner<Integer> spinnerDuracion;
	private @FXML Button buttonGuardar;
	
	@FXML
	public void initialize(){
		colTitulo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulo()));
		colDuracion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDuracion() + " Min"));
		colGenero.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGenero()));
		
		spinnerDuracion.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 999, 60));
		
		cargarPeliculas();
		
		String[] generos = {"ACCION", "TERROR", "COMEDIA", "AVENTURA", "DRAMA", "ROMANCE", "ANIMACION", "BIOGRAFIA"};
		
		comboBoxGenero.getItems().setAll(generos);
	}
	
	private void cargarPeliculas(){
		screenManager.handleTask(
				peliculaServicio.obtenerPeliculas(),
				peliculas -> {
					ObservableList<PeliculaDTO> observableListPeliculas = FXCollections.observableArrayList();
					observableListPeliculas.addAll(peliculas);
					
					listaPeliculas.setItems(observableListPeliculas);
				}
		);
	}
	
	@FXML
	public void crearPelicula(){
		PeliculaDTO pelicula = new PeliculaDTO();
		pelicula.setTitulo(textFieldTitulo.getText());
		pelicula.setDescripcion(textAreaDescripcion.getText());
		pelicula.setDuracion(Long.valueOf(spinnerDuracion.getValue()));
		pelicula.setGenero(comboBoxGenero.getValue());
		pelicula.setUrlImagen(textFieldUrlImagen.getText());
		
		if(!pelicula.esValido()){
			screenManager.launchAlert("Advertencia", "Formulario Invalido",
									"Todos los campos son obligatorios y la duracion mayor a 0");
		}
		else {
			screenManager.handleTask(
					peliculaServicio.guardar(pelicula),
					nuevaPelicula -> {
						screenManager.launchAlert("Mensaje", "Pelicula",
								"Pelicula creada exitosamente");
						cargarPeliculas();
					}
			);
		}
	}
}
