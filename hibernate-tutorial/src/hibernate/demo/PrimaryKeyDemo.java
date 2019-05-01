package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
	public static void main(String[] args) {

		// crar session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// criar session
		Session session = factory.getCurrentSession();

		try {

			// criar 3 objeto Student
			System.out.println("Creating a new student object...");
			Student tempStudent1 = new Student("Victor", "Cabron", "v@gmail.com");
			Student tempStudent2 = new Student("Lory", "Flory", "lf@gmail.com");
			Student tempStudent3 = new Student("Bony", "Mary", "m@gmail.com");

			// iniciar uma transação
			session.beginTransaction();

			// salvar a transação
			System.out.println("Saving the Student...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			// commitar a transação
			session.getTransaction().commit();

			System.out.println("Done!");
		}

		finally {
			factory.close();
		}

	}
}
