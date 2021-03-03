package simplehibernate;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;

public class DueñoDAO {

        private static SessionFactory factory;
        private static ServiceRegistry serviceRegistry;

        public DueñoDAO(){
            try{
                Configuration configuration = new Configuration();
                System.err.println("Leyendo configuracion." );
                configuration.configure("hibernateMysql.cfg.xml");
                serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
                factory = configuration.buildSessionFactory(serviceRegistry);
                System.out.println("Conectado a base de datos... yes");
            }catch (Throwable ex) {
                System.err.println("No se pudo iniciar la sesion..." + ex);
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

        public List<Dueño>Listado2(){
            Session session1 = factory.openSession();
            Criteria criter = session1.createCriteria(Cita.class);
            //Transaction tr = null;
            List<Dueño> lista2 = null;
            try{
                System.out.println("Conectado a base de datos...");
                //session1 = getSession().openSession();
                //tr = session1.beginTransaction();
                //tr.setTimeout(2);
                //lista = session1.createCriteria(alumno.class).list();
                lista2 = criter.list();
                for(Dueño dueño: lista2){
                    System.out.print("  Nombre del dueño: "+dueño.getNombreDueño());
                    System.out.print("  Direccion: "+dueño.getDireccion());
                    System.out.print("  Num_Telefono: "+dueño.getNumTel());
                    System.out.println("");
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                if(session1.isOpen()){
                    session1.close();
                }
            }
            return lista2;
        }

        public List<Dueño> Buscar(int ciudad){

            System.out.println("id ciudad en buscar DAOalum: "+ ciudad);
            System.out.print("Buscar listas");

            Session session = factory.openSession();
            Criteria cr = session.createCriteria(Cita.class);
            System.out.print("Buscar listas 2");
            cr.add(Restrictions.eq("idCiudad", ciudad));
            List results2 = cr.list();

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
            return results2;

        }


        public Integer addDueño(int IdDueño,String NombreDueño, String Dirreccion, int NumTel){
            Session session = factory.openSession();
            Transaction tx2 = null;
            Integer daoID = null;
            try{
                tx2 = session.beginTransaction();
                Dueño dao2 = new Dueño(IdDueño,NombreDueño, Dirreccion, NumTel);
                daoID = (Integer) session.save(dao2);
                tx2.commit();
            }catch (HibernateException e) {
                if (tx2!=null) tx2.rollback();
                e.printStackTrace();
            }finally {
                session.close();
            }
            return daoID;
        }

        /* Borra cita */
        public void deleteDueño(Integer idDueño){
            Session session = factory.openSession();
            Transaction tx2 = null;
            try{
                tx2 = session.beginTransaction();
                Dueño dao2 =
                        (Dueño)session.get(Dueño.class, idDueño);
                ((org.hibernate.Session) session).delete(dao2);
                tx2.commit();
            }catch (HibernateException e) {
                if (tx2!=null) tx2.rollback();
                e.printStackTrace();
            }finally {
                session.close();
            }
        }


    }

