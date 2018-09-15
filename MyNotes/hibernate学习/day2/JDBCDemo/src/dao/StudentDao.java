package dao;

import java.sql.SQLException;
import java.util.List;

import model.Student;

public interface StudentDao {
	/**
	 * ���ѧ��
	 * 
	 * @param stu
	 * @return ��Ӻ��ѧ��id
	 * @throws Exception 
	 */
	public int addStudent(Student stu) throws Exception;

	/**
	 * ��IDɾ��ѧ��
	 * 
	 * @param id
	 * @return �Ƿ�ɾ���ɹ�
	 * @throws SQLException 
	 * @throws Exception 
	 */
	public boolean deleteStudentById(int id) throws Exception;

	/**
	 * ����ѧ����Ϣ
	 * 
	 * @param stu
	 * @return �Ƿ���³ɹ�
	 * @throws Exception 
	 */
	public boolean updateStudent(Student stu) throws Exception;

	/**
	 * �����ֻ�ȡѧ����Ϣ
	 * 
	 * @param name
	 * @return
	 * @throws Exception 
	 */
	public Student getStudentByName(String name) throws Exception;

	/**
	 * ��ID��ȡѧ����Ϣ
	 * 
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	public Student getStudentById(int id) throws Exception;

	/**
	 * ��ȡȫ����ѧ���б�
	 * 
	 * @return
	 * @throws Exception 
	 */
	public List<Student> getStudentList() throws Exception;
}
