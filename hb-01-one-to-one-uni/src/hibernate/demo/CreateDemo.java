package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {

		// criar session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		//criar os objetos
		Instructor tempInstructor= new Instructor("Victor", "Capaones","v@gmail.com");
		
		InstructorDetail tempInstructorDetail = new InstructorDetail("www.vitao.com","All");
		
		//associar os objetos
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		
		
		// criar session
		Session session = factory.getCurrentSession();

		try {
			
		
			//iniciar uma transação
			session.beginTransaction();
			
			//salvar instrutor
			System.out.println("Salvando o instrutor: "+ tempInstructor);
			session.save(tempInstructor);
			
	
			//commitar a transação
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}

		finally {
			factory.close();
		}

	}

}
