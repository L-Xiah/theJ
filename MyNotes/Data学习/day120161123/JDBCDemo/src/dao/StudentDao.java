package dao;

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
	 */
	public boolean deleteStudentById(int id);

	/**
	 * ����ѧ����Ϣ
	 * 
	 * @param stu
	 * @return �Ƿ���³ɹ�
	 */
	public boolean updateStudent(Student stu);

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
	 */
	public Student getStudentById(int id);

	/**
	 * ��ȡȫ����ѧ���б�
	 * 
	 * @return
	 */
	public List<Student> getStudentList();
}
