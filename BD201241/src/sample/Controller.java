package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import simplehibernate.CitaDAO;
import simplehibernate.DueñoDAO;
import simplehibernate.MascotaDAO;

public class Controller {
//
    @FXML
    private Button iniciar;
    @FXML
    private Pane paneRegistrarMascota;
    @FXML
    private Pane paneActualizarMascota;


    @FXML
    void puebas(ActionEvent e){
        CitaDAO con = new CitaDAO();
        DueñoDAO dev = new DueñoDAO();
        MascotaDAO exe =new MascotaDAO();

        System.out.println("Listado____________Tabla cita");
        con.Listado();
        System.out.println("Listado2___________Tabla dueño");
        dev.Listado2();
        System.out.println("Listado3___________Tabla mascota");
        exe.Listado3();
//
//
//        System.out.println("Agregado___________");
//        con.addCita("03/13","09:00","Vacuna",7);
//        con.addCita("01/23","10:00","Cirugia",5);
//        con.addCita("05/07","17:00","Baño",6);
//        System.out.println("Listado actual___________");
//        con.Listado();
//
//
//
//
//
//        System.out.println("Delete test___________");
//        con.deleteCita(2);
//        System.out.println("Listado delete___________");
//        con.Listado();


        //con.addCita("03/13","10:20","Baño",2);
        //con.deleteCita(4);
        //con.Listado();
        //con.updateCita(6,"09/04","16:30","Corte de pelo", 4);
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
    void VistaDueño(ActionEvent e){

    }
    @FXML
    void VistaInventario(ActionEvent e){

    }

}
