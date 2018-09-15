package db;

import dao.StudentDao;
import dao.StudentDaoImpl;
import model.Student;

public class DBTest {
	public static void main(String[] args) throws Exception {
		StudentDao stuDao = new StudentDaoImpl();
		Student stu = stuDao.getStudentByName("Stark");
		System.out.println(stu);
	}
}
