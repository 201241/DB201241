package simplehibernate;

import javax.persistence.*;

@Entity
@Table(name = "Cita")
public class Cita {

    @Id
    @GeneratedValue
    @Column(name = "idCita")
    private int idCita;

    @Column(name = "Fecha")
    private String Fecha;

    @Column(name = "Hora")
    private String Hora;

    @Column(name = "Servicio")
    private int Servicio;

    @Column(name = "idMascota")
    private int idMascota;

    public Cita() {
    }

    public Cita(String Fecha, String Hora, int Servicio, int idMascota) {
        this.Fecha = Fecha;
        this.Hora = Hora;
        this.Servicio = Servicio;
        this.idMascota=idMascota; //objeto tipo mascota muchos a uno.
    }


    public String getHora() {
        return Hora;
    }

    public void setHora(String hora) {
        Hora = hora;
    }

    public int getServicio() {
        return Servicio;
    }

    public void setServicio(int servicio) {
        Servicio = servicio;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

}
