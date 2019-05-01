package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {


		// crar session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// criar session
		Session session = factory.getCurrentSession();


		try {
			
			int studentId= 1;

			//get uma seção e iniciar transação
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//recuperar student baseado no id
			System.out.println("Getting Studend with id: "+ studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating student: "+ myStudent);
			myStudent.setFirstName("Kram");
			
			//comitar a transação
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//update email
			System.out.println("Update email: ");
			session.createQuery("update Student set email='Ugin@tron.com'").executeUpdate();
			
			//comitar a transação
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}

		finally {
			factory.close();
		}

	}

}
