package dao;

import java.util.List;

import model.Student;

public interface StudentDao {
	/**
	 * 添加学生
	 * 
	 * @param stu
	 * @return 添加后的学生id
	 * @throws Exception 
	 */
	public int addStudent(Student stu) throws Exception;

	/**
	 * 以ID删除学生
	 * 
	 * @param id
	 * @return 是否删除成功
	 */
	public boolean deleteStudentById(int id);

	/**
	 * 更新学生信息
	 * 
	 * @param stu
	 * @return 是否更新成功
	 */
	public boolean updateStudent(Student stu);

	/**
	 * 以名字获取学生信息
	 * 
	 * @param name
	 * @return
	 * @throws Exception 
	 */
	public Student getStudentByName(String name) throws Exception;

	/**
	 * 以ID获取学生信息
	 * 
	 * @param id
	 * @return
	 */
	public Student getStudentById(int id);

	/**
	 * 获取全部的学生列表
	 * 
	 * @return
	 */
	public List<Student> getStudentList();
}
