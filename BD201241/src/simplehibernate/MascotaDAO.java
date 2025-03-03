package simplehibernate;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.transform.AliasToBeanResultTransformer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
///
public class MascotaDAO {

    private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;

    public MascotaDAO(){
        try{
            Configuration configuration = new Configuration();
            System.err.println("Leyendo configuracion." );
            configuration.configure("hibernateMysql.cfg.xml");
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            factory = configuration.buildSessionFactory(serviceRegistry);
            System.out.println("Conectado a base de datos... yea");
        }catch (Throwable ex) {
            System.err.println("No se pudo conectar...." + ex);
            System.out.println("No conectado a base de datos...");
            throw new ExceptionInInitializerError(ex);
        }
    }


    SessionFactory session;

    public SessionFactory getSession(){
        setSession();
        return  session;
    }

    public void setSession(){
        this.session = new Configuration().configure().buildSessionFactory();
    }

    public List<Mascota>Listado3(){
        Session session1 = factory.openSession();
        Criteria criter = session1.createCriteria(Mascota.class);
        //Transaction tr = null;
        List<Mascota> mascota = new ArrayList<>();
        try{
            ProjectionList listMascota = Projections.projectionList();
            listMascota.add(Projections.property("IdMascota"), "IdMascota");
            listMascota.add(Projections.property("Nombre_Mascota"), "Nombre_Mascota");
            listMascota.add(Projections.property("Ingreso"), "Ingreso");
            listMascota.add(Projections.property("motivo_Cita"), "motivo_Cita");
            listMascota.add(Projections.property("IdDueño"), "IdDueño");

            criter.setProjection(listMascota);

            List<Mascota> mascotas = criter.setResultTransformer(new AliasToBeanResultTransformer(Mascota.class)).list();

            int i =0;
            for(Iterator iterator = mascotas.iterator(); iterator.hasNext();){
                mascota.add((Mascota) iterator.next());
                i++;
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(session1.isOpen()){
                session1.close();
            }
        }
        return mascota;
    }

/*    public List<Mascota> Buscar(int ciudad){

        System.out.println("id ciudad en buscar DAOalum: "+ ciudad);
        System.out.print("Buscar listas");

        Session session = factory.openSession();
        Criteria cr = session.createCriteria(Cita.class);
        System.out.print("Buscar listas 2");
        cr.add(Restrictions.eq("idCiudad", ciudad));
        List results3 = cr.list();

        System.out.print("Buscar listas final");

		Session session1 = factory.openSession();
		Criteria crit = session1.createCriteria(alumno.class).add(Restrictions.eq("idCiudad", 1));
		//Transaction tr = null;
		List<alumno> lista = null;
		try{
			//session1 = getSession().openSession();
			//tr = session1.beginTransaction();
			//tr.setTimeout(2);
			lista = crit.list();
			//lista = session1.createCriteria(alumno.class).add(Restrictions.like("nombre", letra+"%")).list();

			for(alumno alum: lista){
				System.out.print("  nombre: "+alum.getNombre());
				System.out.print("  sexo: "+alum.getSexo());
				System.out.print("  edad: "+alum.getEdad());
				System.out.println("");
			}

		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if(session1.isOpen()){
				session1.close();
			}
		}
        return results3;

    }*/


    public Integer addMascota(int idMascota ,String caracteristica, String nombreMasc, String ingreso, String motivoCita, int idDueño){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer daoID = null;
        try{
            tx = session.beginTransaction();
            Mascota dao3 = new Mascota(idMascota,caracteristica,nombreMasc,ingreso,motivoCita,idDueño);
            daoID = (Integer) session.save(dao3);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return daoID;
    }

    /* Borra cita */
    public void deleteMascota(Integer idMascota){
        Session session = factory.openSession();
        Transaction tx3 = null;
        try{
            tx3 = session.beginTransaction();
            Mascota dao3 =
                    (Mascota) session.get(Mascota.class, idMascota);
            ((Session) session).delete(dao3);
            tx3.commit();
        }catch (HibernateException e) {
            if (tx3!=null) tx3.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
//caracteristica NombreMascota Ingreso MotivoCita IdDueño

    public void updateMascota(Integer idMascota,String tipo_Mascota, String NombreMascota,String caracteristica, String Ingreso, String MotivoCita, int IdDueño){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Mascota dao =
                    (Mascota) session.get(Mascota.class, idMascota);

            dao.setNombre_Mascota(NombreMascota);
            dao.setCaracteristica(caracteristica);
            dao.setIngreso(Ingreso);
            dao.setMotivo_Cita(MotivoCita);
            dao.setIdDueño(IdDueño);

            session.update(dao);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

}

