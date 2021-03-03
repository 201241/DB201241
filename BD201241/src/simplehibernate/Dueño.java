package simplehibernate;
import javax.persistence.*;

@Entity
@Table(name = "dueño")
public class Dueño {
 //Id_Dueño Nombre_Dueño Direccion Num_Telefono
    @Id
    @GeneratedValue
    @Column(name = "Id_Dueño")
    private int IdDueño;

    @Column(name = "Nombre_Dueño")
    private String NombreDueño;

    @Column(name = "Direccion")
    private String Direccion;

    @Column(name = "Num_Telefono")
    private int NumTel;

    public Dueño(int IdDueño, String NombreDueño, String Direccion, int NumTel){
        this.IdDueño=IdDueño;
        this.NombreDueño=NombreDueño;
        this.Direccion=Direccion;
        this.NumTel=NumTel;
    }

    public Dueño(){

    }

    public int getIdDueño() {
        return IdDueño;
    }

    public void setIdDueño(int idDueño) {
        IdDueño = idDueño;
    }

    public String getNombreDueño() {
        return NombreDueño;
    }

    public void setNombreDueño(String nombreDueño) {
        NombreDueño = nombreDueño;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public int getNumTel() {
        return NumTel;
    }

    public void setNumTel(int numTel) {
        NumTel = numTel;
    }
}
