package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Student;

public class HibernateTest {
	Session session;
	Transaction transaction;

	@Before
	public void start() {
		Configuration configuration = new Configuration().configure();

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();

		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		session = sessionFactory.openSession();

		transaction = session.beginTransaction();
	}

	@After
	public void end() {
		transaction.commit();
	}

	@Test
	public void testAddStudent() {
		Student student = new Student(232, "dsadd¹þ¹þ¹þ¹þ", 99, 9);
		session.save(student);
	}

	@Test
	public void testGetStudent() {
		Student student = (Student) session.get(Student.class, 232);
		// Student student = (Student) session.load(Student.class, 232);
		System.out.println("s1=" + student.hashCode());
	}

	@Test
	public void testUpdateStudent() {
		Student student = (Student) session.get(Student.class, 232);
		student.setName("ÀîÀ×");
		session.update(student);
	}

	@Test
	public void deleteStudent() {
		Student student = (Student) session.get(Student.class, 232);
		session.delete(student);
	}
}
