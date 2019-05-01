package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// crar session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// criar session
		Session session = factory.getCurrentSession();

		try {

			int studentId = 1;

			// get uma seção e iniciar transação
			session = factory.getCurrentSession();
			session.beginTransaction();
//			
//			//recuperar student baseado no id
//			System.out.println("Getting Studend with id: "+ studentId);
//			
//			Student myStudent = session.get(Student.class, studentId);
//			
//			//delete student
//			System.out.println("Deletando student: "+myStudent);
//			session.delete(myStudent);

			session.createQuery("delete from Student where id in (7,8)").executeUpdate();

			// comitar a transação
			session.getTransaction().commit();

			System.out.println("Done!");
		}

		finally {
			factory.close();
		}

	}

}
