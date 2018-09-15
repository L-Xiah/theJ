package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBHelper;
import model.Student;

public class StudentDaoImpl implements StudentDao {

	@Override
	public Student getStudentByName(String targetName) throws Exception {
		String sql = "select * from student where name=?";
		PreparedStatement psmt = DBHelper.getConnection().prepareStatement(sql);
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
	public Student getStudentById(int id) throws Exception {
		String sql = "select * from student where id=?";
		PreparedStatement psmt = DBHelper.getConnection().prepareStatement(sql);
		psmt.setInt(1, id);
		ResultSet rs = psmt.executeQuery();

		Student stu = null;
		while (rs.next()) {
			String name = rs.getString("name");
			int age = rs.getInt("age");
			double score = rs.getDouble("score");

			stu = new Student(id, name, age, score);
		}

		return stu;
	}

	@Override
	public List<Student> getStudentList() throws Exception {
		String sql = "select * from student";
		PreparedStatement psmt = DBHelper.getConnection().prepareStatement(sql);
		ResultSet rs = psmt.executeQuery();

		List<Student> list = new ArrayList<Student>();
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			double score = rs.getDouble("score");

			Student stu = new Student(id, name, age, score);
			list.add(stu);
		}

		return list;
	}

	@Override
	public int addStudent(Student stu) throws Exception {
		int retId = -1;

		String sql = "insert into student values(?,?,?,?)";
		PreparedStatement psmt = DBHelper.getConnection().prepareStatement(
				sql, PreparedStatement.RETURN_GENERATED_KEYS);
		psmt.setInt(1, stu.getId());
		psmt.setString(2, stu.getName());
		psmt.setInt(3, stu.getAge());
		psmt.setDouble(4, stu.getScore());
		int count = psmt.executeUpdate();
		if (count > 0) {
			ResultSet rs = psmt.getGeneratedKeys();
			if (rs.next()) {
				// int id = rs.getInt(1);  // for mysql
				
				// oracle 返回的是oracle内置的rowid
				String row = rs.getString(1);
				// 通过rowid去反查当前表中=rowid的主键id 
				retId = getStudentIdByRowIdForOracle(row);
			}
		}

		return retId;
	}

	private int getStudentIdByRowIdForOracle(String rowId) throws Exception {
		int id = -1;
		String sql = "select id from student where rowId=?";
		PreparedStatement psmt = DBHelper.getConnection().prepareStatement(sql);
		psmt.setString(1, rowId);
		ResultSet rs = psmt.executeQuery();
		if (rs.next()) {
			id = rs.getInt("id");
		}
		return id;
	}

	@Override
	public boolean deleteStudentById(int id) throws Exception {
		String sql = "delete from student where id=?";
		PreparedStatement psmt = DBHelper.getConnection().prepareStatement(sql);
		psmt.setInt(1, id);
		psmt.executeUpdate();
		return false;
	}

	@Override
	public boolean updateStudent(Student stu) throws Exception {
		int id = stu.getId();
		Student stu0 = getStudentById(id);
		if (stu0 != null) {
			String sql = "update student set (name=?, age=?, score=?) where id=?";
			PreparedStatement psmt = DBHelper.getConnection().prepareStatement(sql);
			psmt.setString(1, stu.getName());
			psmt.setInt(2, stu.getAge());
			psmt.setDouble(3, stu.getScore());
			psmt.setInt(4, stu.getId());
			psmt.executeUpdate();
		} else {
			addStudent(stu);
		}

		return false;
	}
}
