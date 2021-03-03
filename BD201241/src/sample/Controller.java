package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import simplehibernate.CitaDAO;
import simplehibernate.Dueño;
import simplehibernate.DueñoDAO;
import simplehibernate.MascotaDAO;

public class Controller {
//
    @FXML
    private Button iniciar;

    @FXML
    void puebas(ActionEvent e){
        CitaDAO con = new CitaDAO();
        DueñoDAO dev = new DueñoDAO();
        MascotaDAO exe =new MascotaDAO();

        System.out.println("Listado____________");
        con.Listado();
        System.out.println("Listado2___________");
        dev.Listado2();
        System.out.println("Listado3___________");
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
    }


}
