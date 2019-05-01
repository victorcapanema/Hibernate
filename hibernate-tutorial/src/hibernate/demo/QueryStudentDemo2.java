package hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class QueryStudentDemo2 {

	public static void main(String[] args) {

		// crar session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// criar session
		Session session = factory.getCurrentSession();

		try {
			
			
			//iniciar uma transação
			session.beginTransaction();
			
			//Query students
			List<Student> theStudents = session.createQuery("from Student").list();
			
			//mostrar os students
			displayStudents(theStudents);
			
			//query lastname
			theStudents = session.createQuery("from Student s where s.lastName='Flory'").list();
			
			
			//mostrar os students
			System.out.println("\nStudent lastNmae Flory: ");
			displayStudents(theStudents);
			
			
			//query OR
			theStudents =session.createQuery("from Student s where s.lastName='Flory' OR s.firstName='Victor'").list();
			
			//mostrar os students
			System.out.println("\nStudent Student s where s.lastName='Flory' OR s.firstName='Victor' ");
			displayStudents(theStudents);
			
			//Query LIKE
			theStudents =session.createQuery("from Student s where s.email Like '%v@gmail.com'").list();
			
			//mostrar os students
			System.out.println("\nStudent where s.email Like '%v@gmail.com': ");
			displayStudents(theStudents);
			
			//commitar a transação
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}

		finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student x: theStudents) {
			System.out.println(x);
		}
	}

}
