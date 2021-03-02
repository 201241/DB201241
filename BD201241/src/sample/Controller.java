package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import simplehibernate.DAOCita;

public class Controller {
//
    @FXML
    private Button iniciar;

    @FXML
    void iniciarMySql(ActionEvent e){
        DAOCita con = new DAOCita();


        System.out.println("Listado___________");
        con.Listado();




        System.out.println("Agregado___________");
        con.addCita("03/13","09:00","Vacuna",1);
        con.addCita("01/23","10:00","Cirugia",5);
        con.addCita("05/07","17:00","Baño",6);
        System.out.println("Listado actual___________");
        con.Listado();





        System.out.println("Delete test___________");
        con.deleteCita(2);
        System.out.println("Listado delete___________");
        con.Listado();
    }


}
