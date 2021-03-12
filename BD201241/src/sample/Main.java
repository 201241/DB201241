package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import simplehibernate.*;

//Rama
//Elian_branch

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        DueñoDAO dao = new DueñoDAO();
        CitaDAO dao1 = new CitaDAO();
        MascotaDAO dao2 = new MascotaDAO();
        Parent root = FXMLLoader.load(getClass().getResource("Vistas.fxml"));
        primaryStage.setTitle("holaa :D");
        primaryStage.setScene(new Scene(root, 718, 448));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
