package simplehibernate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;
import java.io.Serializable;


public class Mascota implements Serializable {
    private final IntegerProperty IdMascota = new SimpleIntegerProperty();
    private final StringProperty Tipo_Mascota = new SimpleStringProperty();
    private final StringProperty Caracteristica = new SimpleStringProperty();
    private final StringProperty nombre_Mascota = new SimpleStringProperty();
    private final StringProperty Ingreso =new SimpleStringProperty();
    private final StringProperty motivo_Cita = new SimpleStringProperty();
    private final IntegerProperty IdDueño = new SimpleIntegerProperty();
    private Mascota mascota;


    public Mascota(){
    }

    public Mascota(Integer idMascota , String caracteristica, String nombre_Mascota, String ingreso, String motivo_Cita, Integer idDueño) {
        this.IdMascota.set(idMascota);
        this.Caracteristica.set(caracteristica);
        this.nombre_Mascota.set(nombre_Mascota);
        this.Ingreso.set(ingreso);
        this.motivo_Cita.set(motivo_Cita);
        this.IdDueño.set(idDueño);
    }

    public String getTipo_Mascota() {
        return Tipo_Mascota.get();
    }
    public StringProperty tipo_MascotaProperty() {
        return Tipo_Mascota;
    }
    public void setTipo_Mascota(String tipo_Mascota) {
        this.Tipo_Mascota.set(tipo_Mascota);
    }

    public int getIdMascota() {
        return IdMascota.get();
    }

    public IntegerProperty idMascotaProperty() {
        return IdMascota;
    }

    public void setIdMascota(Integer idMascota) {
        this.IdMascota.set(idMascota);
    }

    public String getCaracteristica() {
        return Caracteristica.get();
    }

    public StringProperty caracteristicaProperty() {
        return Caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.Caracteristica.set(caracteristica);
    }

    public String getNombre_Mascota() {
        return nombre_Mascota.get();
    }

    public StringProperty nombreMascProperty() {
        return nombre_Mascota;
    }

    public void setNombre_Mascota(String nombre_Mascota) {
        this.nombre_Mascota.set(nombre_Mascota);
    }

    public String getIngreso() {
        return Ingreso.get();
    }

    public StringProperty ingresoProperty() {
        return Ingreso;
    }

    public void setIngreso(String ingreso) {
        this.Ingreso.set(ingreso);
    }

    public String getMotivo_Cita() {
        return motivo_Cita.get();
    }

    public StringProperty motivo_CitaProperty() {
        return motivo_Cita;
    }

    public void setMotivo_Cita(String motivo_Cita) {
        this.motivo_Cita.set(motivo_Cita);
    }

    public int getIdDueño() {
        return IdDueño.get();
    }

    public IntegerProperty idDueñoProperty() {
        return IdDueño;
    }

    public void setIdDueño(Integer idDueño) {
        this.IdDueño.set(idDueño);
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
}
