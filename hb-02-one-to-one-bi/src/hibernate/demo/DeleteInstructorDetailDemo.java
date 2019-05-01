package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		// criar session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// criar session
		Session session = factory.getCurrentSession();

		try {

			// iniciar uma transação
			session.beginTransaction();

			// obter o objeto intrutor detail
			int theId = 3;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

			System.out.println("tempInstructorDetail: " + tempInstructorDetail);

			System.out.println("\nIntrutor associado: " + tempInstructorDetail.getInstructor());
			
			//deletar o instructordetail
			System.out.println("Deletando o tempInstructorDetail: "+ tempInstructorDetail);
			
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(tempInstructorDetail);
			
			// commitar a transação
			session.getTransaction().commit();

			System.out.println("Done!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			
			factory.close();
		}

	}

}
