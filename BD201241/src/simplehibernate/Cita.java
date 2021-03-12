package simplehibernate;


import javafx.beans.property.*;
import java.io.Serializable;

public class Cita implements Serializable{
    private  final IntegerProperty idCita = new SimpleIntegerProperty();
    private final StringProperty fecha = new SimpleStringProperty();
    private final StringProperty hora = new SimpleStringProperty();
    private final StringProperty servicio = new SimpleStringProperty();
    private final IntegerProperty Id_Mascota = new SimpleIntegerProperty();
    private Cita cita;
    //hibernate 2.M
    //bolsa
    //objeto tipo mascota muchos 1
    public Cita(Integer idCita,String Fecha, String Hora, String Servicio, Integer Id_Mascota){
        this.idCita.set(idCita);
        this.fecha.set(Fecha);
        this.hora.set(Hora);
        this.servicio.set(Servicio);
        this.Id_Mascota.set(Id_Mascota);

    }
    public Cita (){ }


    public int getIdCita() {
        return idCita.get();
    }

    public IntegerProperty idCitaProperty() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita.set(idCita);
    }

    public String getFecha() {
        return fecha.get();
    }

    public StringProperty fechaProperty() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha.set(fecha);
    }

    public String getHora() {
        return hora.get();
    }

    public StringProperty horaProperty() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora.set(hora);
    }

    public String getServicio() {
        return servicio.get();
    }

    public StringProperty servicioProperty() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio.set(servicio);
    }

    public int getId_Mascota() {
        return Id_Mascota.get();
    }

    public IntegerProperty id_MascotaProperty() {
        return Id_Mascota;
    }

    public void setId_Mascota(Integer id_Mascota) {
        this.Id_Mascota.set(id_Mascota);
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }
}