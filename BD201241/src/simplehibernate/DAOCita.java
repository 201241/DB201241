package simplehibernate;
//
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Iterator;
import java.util.List;

public class DAOCita {

    private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;


    public DAOCita(){
        try{
            Configuration configuration = new Configuration();
            System.err.println("Leyendo configuracion." );
            configuration.configure("hibernateMysql.cfg.xml");
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            factory = configuration.buildSessionFactory(serviceRegistry);
            System.out.println("Conectado a base de datos... yea");
        }catch (Throwable ex) {
            System.err.println("No se puede crear la Sesion" + ex);
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

        public List<cita> Listado(){
        Session session1 = factory.openSession();
        Criteria criter = session1.createCriteria(cita.class);
        //Transaction tr = null;
        List<cita> lista = null;
        try{
            System.out.println("Conectado a base de datos...");
            //session1 = getSession().openSession();
            //tr = session1.beginTransaction();
            //tr.setTimeout(2);
            //lista = session1.createCriteria(alumno.class).list();
            lista = criter.list();
            for(cita cita: lista){
                System.out.print("  Fecha: "+cita.getFecha());
                System.out.print("  Hora: "+cita.getHora());
                System.out.print("  Servicio: "+cita.getServicio());
                System.out.println("");
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(session1.isOpen()){
                session1.close();
            }
        }
        return lista;
    }

        public List<cita> Buscar(int ciudad){

        System.out.println("id ciudad en buscar DAOalum: "+ ciudad);
        System.out.print("Buscar listas");

        Session session = factory.openSession();
        Criteria cr = session.createCriteria(cita.class);
        System.out.print("Buscar listas 2");
        cr.add(Restrictions.eq("idCiudad", ciudad));
        List results = cr.list();

        System.out.print("Buscar listas final");

/*		Session session1 = factory.openSession();
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
		}*/
        return results;

    }


        public Integer addCita(String Fecha, String Hora, String Servicio, int Id_Mascota){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer daoID = null;
        try{
            tx = session.beginTransaction();
            cita dao = new cita(Fecha, Hora, Servicio, Id_Mascota);
            daoID = (Integer) session.save(dao);
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
        public void deleteCita(Integer idCita){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            cita dao =
                    (cita)session.get(cita.class, idCita);
            ((org.hibernate.Session) session).delete(dao);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }


}


//package simplehibernate;
//        import org.hibernate.*;
//        import org.hibernate.cfg.Configuration;
//        import org.hibernate.criterion.Restrictions;
//        import org.hibernate.service.ServiceRegistry;
//        import org.hibernate.service.ServiceRegistryBuilder;
//
//        import javax.persistence.EntityManager;
//        import javax.persistence.EntityManagerFactory;
//        import javax.persistence.Persistence;
//        import javax.persistence.criteria.CriteriaBuilder;
//        import javax.persistence.criteria.CriteriaQuery;
//        import javax.persistence.criteria.Root;
//        import java.util.Iterator;
//        import java.util.List;
//
//public class DAOAlumno {
//    private static SessionFactory factory;
//    private static ServiceRegistry serviceRegistry;
//
//    SessionFactory session;
//
//    public SessionFactory getSession(){
//        setSession();
//        return  session;
//    }
//
//    public void setSession(){
//        this.session = new Configuration().configure().buildSessionFactory();
//    }
//
//    public List<alumno> Listado(){
//        Session session1 = factory.openSession();
//        Criteria criter = session1.createCriteria(alumno.class);
//        //Transaction tr = null;
//        List<alumno> lista = null;
//        try{
//            //session1 = getSession().openSession();
//            //tr = session1.beginTransaction();
//            //tr.setTimeout(2);
//            //lista = session1.createCriteria(alumno.class).list();
//            lista = criter.list();
//            for(alumno alum: lista){
//                System.out.print("  nombre: "+alum.getNombre());
//                System.out.print("  sexo: "+alum.getSexo());
//                System.out.print("  edad: "+alum.getEdad());
//                System.out.println("");
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        } finally {
//            if(session1.isOpen()){
//                session1.close();
//            }
//        }
//        return lista;
//    }
//
//    public List<alumno> Buscar(int ciudad){
//
//        System.out.println("id ciudad en buscar DAOalum: "+ ciudad);
//        System.out.print("Buscar listas");
//
//        Session session = factory.openSession();
//        Criteria cr = session.createCriteria(alumno.class);
//        System.out.print("Buscar listas 2");
//        cr.add(Restrictions.eq("idCiudad", ciudad));
//        List results = cr.list();
//
//        System.out.print("Buscar listas final");
//
///*		Session session1 = factory.openSession();
//		Criteria crit = session1.createCriteria(alumno.class).add(Restrictions.eq("idCiudad", 1));
//		//Transaction tr = null;
//		List<alumno> lista = null;
//		try{
//			//session1 = getSession().openSession();
//			//tr = session1.beginTransaction();
//			//tr.setTimeout(2);
//			lista = crit.list();
//			//lista = session1.createCriteria(alumno.class).add(Restrictions.like("nombre", letra+"%")).list();
//
//			for(alumno alum: lista){
//				System.out.print("  nombre: "+alum.getNombre());
//				System.out.print("  sexo: "+alum.getSexo());
//				System.out.print("  edad: "+alum.getEdad());
//				System.out.println("");
//			}
//
//		} catch (Exception e){
//			e.printStackTrace();
//		} finally {
//			if(session1.isOpen()){
//				session1.close();
//			}
//		}*/
//        return results;
//
//
//    }
//
//
//    public DAOAlumno(String dato){
//        try{
//            Configuration configuration = new Configuration();
//            System.err.println("Leyendo configuracion." );
//            configuration.configure(dato);
//            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
//            factory = configuration.buildSessionFactory(serviceRegistry);
//        }catch (Throwable ex) {
//            System.err.println("No se puede crear la Sesion" + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//    public Integer addAlumno(String nombre, String sexo, int edad, int idCiudad){
//        Session session = factory.openSession();
//        Transaction tx = null;
//        Integer daoID = null;
//        try{
//            tx = session.beginTransaction();
//            alumno dao = new alumno(nombre, sexo, edad, idCiudad);
//            daoID = (Integer) session.save(dao);
//            tx.commit();
//        }catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//        return daoID;
//    }
//    /* Obtiene todos los alumnos */
//    public alumno listAlumnos( ){
//        Session session = factory.openSession();
//        Transaction tx = null;
//        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("tarea_hibernate");
//
//        EntityManager em =fabrica.createEntityManager();
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//
//        CriteriaQuery<alumno> configconsulta = cb.createQuery(alumno.class);
//
//        Root<alumno> raizAlumno = configconsulta.from(alumno.class);
//        configconsulta.select(raizAlumno);
//
//        List <alumno> alumnos = em.createQuery(configconsulta).getResultList();
//
//        for(alumno alum:alumnos){
//            System.out.print("nombre: "+alum.getNombre());
//            System.out.print("sexo: "+alum.getSexo());
//            System.out.print("edad: "+alum.getEdad());
//        }
//
//        return (alumno) alumnos;
//
///*		try{
//			tx = session.beginTransaction();
//			List employees = session.createQuery( "FROM alumno").list();
//
//			//EntityManager em = fabrica.createEntityManager();
//			//
//			//CriteriaBuilder cb = em.getCriteriaBuilder();
//
//			alumno dao=null;
//			for (Iterator iterator =
//				 employees.iterator(); iterator.hasNext();){
//				dao = (alumno) iterator.next();
//				System.out.print("Nombre:" + dao.getNombre());
//				System.out.print("  Sexo: " + dao.getSexo());
//				System.out.println("  Edad: " + dao.getEdad());
//			}
//			tx.commit();
//			return dao;
//		}catch (HibernateException e) {
//			if (tx!=null) tx.rollback();
//			e.printStackTrace();
//		}finally {
//			session.close();
//		}*/
//        //return null;
//    }
//    /* Actualiza la edad*/
//    public void updateAlumno(Integer AlumnoID, int edad ){
//        Session session = factory.openSession();
//        Transaction tx = null;
//        try{
//            tx = session.beginTransaction();
//            alumno dao =
//                    (alumno)session.get(alumno.class, AlumnoID);
//            dao.setEdad( edad );
//            session.update(dao);
//            tx.commit();
//        }catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//    }
//    /* Borra alumno */
//    public void deleteAlumno(Integer AlumnoID){
//        Session session = factory.openSession();
//        Transaction tx = null;
//        try{
//            tx = session.beginTransaction();
//            alumno dao =
//                    (alumno)session.get(alumno.class, AlumnoID);
//            ((org.hibernate.Session) session).delete(dao);
//            tx.commit();
//        }catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//    }
//}
