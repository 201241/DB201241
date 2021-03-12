package sample;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import simplehibernate.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Pane paneRegistrarMascota;
    @FXML
    private Pane paneActualizarMascota;
    @FXML
    private Pane paneRegistrarCita;
    @FXML
    private Pane paneActualizarCita;
    @FXML
    private Pane paneRegistrarDueño;
    @FXML
    private Pane paneActualizarDueño;

    @FXML
    private TableView<Cita> TableCitas;
    @FXML
    private TableColumn<Cita, Number> idCita;
    @FXML
    private TableColumn<Cita, String> idFechaCita;
    @FXML
    private TableColumn<Cita, String> idHoraCita;
    @FXML
    private TableColumn<Cita, String> idServiceCita;
    @FXML
    private TableColumn<Cita, Number> idIDMascota;
    private ObservableList<Cita> observCitas;
    private CitaDAO citaDAO;

    @FXML
    private TableView<Mascota> TableMascota;
    @FXML
    private TableColumn<Mascota, Number> idMascota;
    @FXML
    private TableColumn<Mascota, String> idTipoMascota;
    @FXML
    private TableColumn<Mascota, String> idCaracterisMasc;
    @FXML
    private TableColumn<Mascota, String> idNombreMasc;
    @FXML
    private TableColumn<Mascota, String> idIngresoMasc;
    @FXML
    private TableColumn<Mascota, String> idMotivMasc;
    @FXML
    private TableColumn<Mascota, Number> idDuenioMasc;
    private ObservableList<Mascota> odserbleMascota ;
    private MascotaDAO mascotaDAO;

    @FXML
    private TableView<Dueño> TableDuenio;
    @FXML
    private TableColumn<Dueño, Number> idD;
    @FXML
    private TableColumn<Dueño, String> nombreD;
    @FXML
    private TableColumn<Dueño, String> direccionD;
    @FXML
    private TableColumn<Dueño, Number> telefonoD;
    private ObservableList<Dueño> odserbleDueños ;
    private DueñoDAO dueñoDAO;

    @FXML
    private Button mascotasB;
    @FXML
    private Button citasB;
    @FXML
    private Button dueñosB;
    @FXML
    private Button inventarioB;
    @FXML
    private Button listo;


////////////////////////////////////////////////Dueño////////////////////////////////////
    @FXML
    void VistaDueño(ActionEvent e){
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        odserbleDueños = FXCollections.observableArrayList();
        dueñoDAO = new DueñoDAO();
        odserbleDueños.addAll(dueñoDAO.Listado2());
        TableDuenio.setItems(odserbleDueños);

        idD.setCellValueFactory(tf -> tf.getValue().id_Dueño());
        nombreD.setCellValueFactory(tf -> tf.getValue().nombre_Dueño());
        direccionD.setCellValueFactory(tf -> tf.getValue().direccion());
        telefonoD.setCellValueFactory(tf -> tf.getValue().num_Telefono());
        //////////////////////////////////////////////////
        observCitas = FXCollections.observableArrayList();
        citaDAO = new CitaDAO();
        observCitas.addAll(citaDAO.Listado());
        TableCitas.setItems(observCitas);

        idCita.setCellValueFactory(tf -> tf.getValue().idCitaProperty());
        idFechaCita.setCellValueFactory(tf -> tf.getValue().fechaProperty());
        idHoraCita.setCellValueFactory(tf -> tf.getValue().horaProperty());
        idServiceCita.setCellValueFactory(tf -> tf.getValue().servicioProperty());
        idIDMascota.setCellValueFactory(tf -> tf.getValue().id_MascotaProperty());

        //////////////////////////////////////////////////////
        odserbleMascota = FXCollections.observableArrayList();
        mascotaDAO = new MascotaDAO();
        odserbleMascota.addAll(mascotaDAO.Listado3());
        TableMascota.setItems(odserbleMascota);

        idMascota.setCellValueFactory(tf -> tf.getValue().idMascotaProperty());
        idCaracterisMasc.setCellValueFactory(tf -> tf.getValue().caracteristicaProperty());
        idNombreMasc.setCellValueFactory(tf -> tf.getValue().nombreMascProperty());
        idIngresoMasc.setCellValueFactory(tf -> tf.getValue().ingresoProperty());
        idMotivMasc.setCellValueFactory(tf -> tf.getValue().motivo_CitaProperty());
        idDuenioMasc.setCellValueFactory(tf -> tf.getValue().idDueñoProperty());

        inicializador();
    }

    public void inicializador(){
        TableDuenio.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Dueño>() {
            @Override
            public void changed(ObservableValue<? extends Dueño> observableValue, Dueño dueño, Dueño t1) {
                if(t1!=null) {
                    idD.setText(String.valueOf(t1.getId_Dueño()));
                    nombreD.setText(t1.getNombre_Dueño());
                    direccionD.setText(t1.getDireccion());
                    telefonoD.setText(String.valueOf(t1.getNum_Telefono()));
                }
            }  });
    }
//////////////////////////////////Dueño////////////////////////////////////

    @FXML
    void puebas(ActionEvent e){
        DueñoDAO dev = new DueñoDAO();
        dev.Listado2();

    }

    @FXML
    void VistaMascota(ActionEvent e){
        paneRegistrarMascota.setVisible(true);
        paneActualizarMascota.setVisible(false);

    }
    @FXML
    void VistaActualizarMascota(ActionEvent e){
        paneRegistrarMascota.setVisible(false);
        paneActualizarMascota.setVisible(true);
    }

    @FXML
    void VistaCita(ActionEvent e){

    }

    @FXML
    void VistaInventario(ActionEvent e){

    }

}
