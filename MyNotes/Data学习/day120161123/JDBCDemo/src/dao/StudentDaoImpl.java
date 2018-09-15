package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import db.DBUtils;
import model.Student;

public class StudentDaoImpl implements StudentDao {

	@Override
	public Student getStudentByName(String targetName) throws Exception {
		String sql = "select * from student where name=?";
		PreparedStatement psmt = DBUtils.getConnection().prepareStatement(sql);
		psmt.setString(1, targetName);
		ResultSet rs = psmt.executeQuery();

		Student stu = null;
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			double score = rs.getDouble("score");

			stu = new Student(id, name, age, score);
		}

		return stu;
	}

	@Override
	public int addStudent(Student stu) throws Exception {
		String sql = "insert into student values(?,?,?,?)";
		PreparedStatement psmt = DBUtils.getConnection().prepareStatement(sql);
		psmt.setInt(1, stu.getId());
		psmt.setString(2, stu.getName());
		psmt.setInt(3, stu.getAge());
		psmt.setDouble(4, stu.getScore());
		psmt.executeUpdate();

		return -1;
	}

	@Override
	public boolean deleteStudentById(int id) {
		return false;
	}

	@Override
	public boolean updateStudent(Student stu) {
		return false;
	}

	@Override
	public Student getStudentById(int id) {
		return null;
	}

	@Override
	public List<Student> getStudentList() {
		return null;
	}
}
