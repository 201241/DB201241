package simplehibernate;

import javafx.beans.property.*;
import java.io.Serializable;

public class Dueño implements Serializable{
    private final IntegerProperty Id_Dueño =new SimpleIntegerProperty();
    private final StringProperty Nombre_Dueño = new SimpleStringProperty();
    private final StringProperty Direccion = new SimpleStringProperty();
    private final IntegerProperty Num_Telefono = new SimpleIntegerProperty();
    private Dueño dueño;

    public Dueño(){}

    public Dueño(Integer Id_Dueño, String Nombre_Dueño, String Direccion, Integer Num_Telefono){
        this.Id_Dueño.set(Id_Dueño);
        this.Nombre_Dueño.set(Nombre_Dueño);
        this.Direccion.set(Direccion);
        this.Num_Telefono.set(Num_Telefono);
    }

    public int getId_Dueño() {
        return Id_Dueño.get();
    }

    public IntegerProperty id_Dueño() {
        return Id_Dueño;
    }

    public void setId_Dueño(Integer Id_Dueño) {
        this.Id_Dueño.set(Id_Dueño);
    }

    public String getNombre_Dueño() {
        return Nombre_Dueño.get();
    }

    public StringProperty nombre_Dueño() {
        return Nombre_Dueño;
    }

    public void setNombre_Dueño(String nombre_Dueño) {
        this.Nombre_Dueño.set(nombre_Dueño);
    }

    public String getDireccion() {
        return Direccion.get();
    }

    public StringProperty direccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        this.Direccion.set(direccion);
    }

    public int getNum_Telefono() {
        return Num_Telefono.get();
    }

    public IntegerProperty num_Telefono() {
        return Num_Telefono;
    }

    public void setNum_Telefono(Integer num_telefono) {
        this.Num_Telefono.set(num_telefono);
    }

    public Dueño getDueño() {
        return dueño;
    }

    public void setDueño(Dueño dueño) {
        this.dueño = dueño;
    }
}
