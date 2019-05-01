package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// criar session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// criar session
		Session session = factory.getCurrentSession();

		try {
			
			//criar um objeto Student
			System.out.println("Creating a new student object...");
			Student tempStudent= new Student("Victor","Cabron","v@gmail.com");
			
			//iniciar uma transação
			session.beginTransaction();
			
			//salvar a transação
			System.out.println("Saving the Student...");
			session.save(tempStudent);
			
			//commitar a transação
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}

		finally {
			factory.close();
		}

	}

}
