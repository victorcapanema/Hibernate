package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {

		// criar session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

	
		
		// criar session
		Session session = factory.getCurrentSession();

		try {
			
		
			//iniciar uma transação
			session.beginTransaction();
			
			//achar o intrutor pela pk id
			int theId =1;
			Instructor tempInstructor=session.get(Instructor.class, theId);
			
			System.out.println("Instrutor: "+ tempInstructor);
	
			//deletar o instrutor
			if(tempInstructor!= null){
				System.out.println("Deletando o intrutor: "+ tempInstructor);
				session.delete(tempInstructor);
			}
			
			
			//commitar a transação
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}

		finally {
			factory.close();
		}

	}

}
