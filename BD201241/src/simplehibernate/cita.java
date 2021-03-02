package simplehibernate;


import javax.persistence.*;

@Entity
@Table(name = "cita")
public class cita{

    @Id
    @GeneratedValue
    @Column(name = "Id_Cita")
    private int idCita;

    @Column(name = "Fecha")
    private String fecha;

    @Column(name = "Hora")
    private String hora;

    @Column(name = "Servicio")
    private String servicio;

    @Column(name = "Id_Mascota")
    private int id_Mascota;

    public cita(String Fecha, String Hora, String Servicio, int Id_Mascota){
        this.fecha=Fecha;
        this.hora=Hora;
        this.servicio=Servicio;
        this.id_Mascota=Id_Mascota;

    }

    public cita() {

    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public int getId_Mascota() {
        return id_Mascota;
    }

    public void setId_Mascota(int id_Mascota) {
        this.id_Mascota = id_Mascota;
    }
}