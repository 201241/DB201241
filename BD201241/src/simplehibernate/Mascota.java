package simplehibernate;
import javax.persistence.*;

@Entity
@Table(name = "mascota")
public class Mascota {

    //Id_Mascota Caracteristica Nombre_Mascota Ingreso Motivo_cita Id_Dueño

    @Id
    @GeneratedValue
    @Column(name = "Id_Mascota")
    private int IdMascota;

    @Column(name = "Caracteristica")
    private String Caracteristica;

    @Column(name = "Nombre_Mascota")
    private String NombreMascota;

    @Column(name = "Ingreso")
    private String Ingreso;

    @Column(name = "Motivo_cita")
    private String MotivoCita;

    @Column(name = "Id_Dueño")
    private int IdDueño;

    public Mascota(int idMascota, String caracteristica, String nombreMasc, String ingreso, String motivoCita, int idDueño){
        this.IdMascota=idMascota;
        this.Caracteristica=caracteristica;
        this.NombreMascota=nombreMasc;
        this.Ingreso=ingreso;
        this.MotivoCita=motivoCita;
        this.IdDueño=idDueño;
    }

    public Mascota(){

    }

    public int getIdMascota() {
        return IdMascota;
    }

    public void setIdMascota(int idMascota) {
        IdMascota = idMascota;
    }

    public String getCaracteristica() {
        return Caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        Caracteristica = caracteristica;
    }

    public String getNombreMascota() {
        return NombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        NombreMascota = nombreMascota;
    }

    public String getIngreso() {
        return Ingreso;
    }

    public void setIngreso(String ingreso) {
        Ingreso = ingreso;
    }

    public String getMotivoCita() {
        return MotivoCita;
    }

    public void setMotivoCita(String motivoCita) {
        MotivoCita = motivoCita;
    }

    public int getIdDueño() {
        return IdDueño;
    }

    public void setIdDueño(int idDueño) {
        IdDueño = idDueño;
    }
}
