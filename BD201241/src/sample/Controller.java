package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import simplehibernate.DAOCita;

public class Controller {

    @FXML
    private Button iniciar;

    @FXML
    void iniciarMySql(ActionEvent e){
        DAOCita con = new DAOCita();
        con.Listado();
    }


}
