package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// crar session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// criar session
		Session session = factory.getCurrentSession();

		try {
			
			//criar um objeto Student
			System.out.println("Creating a new student object...");
			Student tempStudent= new Student("Loren","Brin","LB@gmail.com");
			
			//iniciar uma transa��o
			session.beginTransaction();
			
			//salvar a transa��o
			System.out.println("Saving the Student...");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			//commitar a transa��o
			session.getTransaction().commit();
			
			//achar o id
			System.out.println("Saved student. Geberated id: "+tempStudent.getId());
			
			//get uma se��o e iniciar transa��o
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//recuperar student baseado no id
			System.out.println("Getting Studend with id: "+ tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get complete: "+ myStudent);
			
			//comitar a transa��o
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}

		finally {
			factory.close();
		}

	}

}
