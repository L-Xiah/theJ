package teststudent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.StudentDao;
import dao.StudentDaoImpl;
import model.Student;

public class StudentTest {

	private Connection conn;

	@Before
	public void init() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 建立连接
			String dburl = "jdbc:oracle:thin:@192.168.199.107:1521:orcl";
			String dbuser = "willi";
			String password = "hahaha";
			conn = DriverManager.getConnection(dburl, dbuser, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@After
	public void destory() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testGetStudentById() throws Exception {
		StudentDao dao = new StudentDaoImpl();
		Student student = dao.getStudentById(5);

		Student stu = new Student(10, "Stark", 23, 85.5);

		assert stu.equals(student);
	}

	@Test
	public void testGetStudentList() throws Exception {
		StudentDao dao = new StudentDaoImpl();
		List<Student> list = dao.getStudentList();
		assert 10 == list.size();
	}

	@Test
	public void testAddStudent() throws Exception {
		StudentDao dao = new StudentDaoImpl();
		Student student = new Student(1, "Jeffery", 20, 85);
		int id = dao.addStudent(student);
		System.out.println(id);
	}
}
