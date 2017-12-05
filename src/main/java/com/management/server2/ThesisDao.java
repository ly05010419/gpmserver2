package com.management.server2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ThesisDao {

	private SessionFactory sessionFactory;
	private Session session;

	public ThesisDao() {
		Configuration configuration = new Configuration().configure();// 创建配置对象
		sessionFactory = configuration.buildSessionFactory();// 创建会话工厂
		session = sessionFactory.openSession();// 开启会话
	}

	public Thesis getThesisById(int id) {
		List<Thesis> list = session.createQuery("from Thesis c where id=?").setInteger(0, id).list();

		Thesis thesis = null;

		for (Thesis t : list) {
			thesis = (Thesis) t;
		}

		return thesis;
	}

	public Thesis getThesisByStudentId(int id) {
		List<Thesis> list = session.createQuery("from Thesis c where student_id=?").setInteger(0, id).list();

		Thesis thesis = null;

		for (Thesis t : list) {
			thesis = (Thesis) t;
		}

		return thesis;
	}

	public List<Thesis> getAllThesis() {

		List<Thesis> list = session.createQuery("from Thesis c").list();

		return list;
	}

	public void updateThesis(int studentId, int approved) {

		Thesis thesis = getThesisByStudentId(studentId);

		thesis.setApproved(approved);
		session.beginTransaction();
		// 保存对象进数据库
		session.save(thesis);
		session.getTransaction().commit();
	}

	public void saveThesis(int studentId, String supervisor, String title, int approved) {

		Thesis thesis = getThesisByStudentId(studentId);

		session.beginTransaction();
		if (thesis != null) {
			session.delete(thesis);
		}
		thesis = new Thesis();

		thesis.setStudentId(studentId);
		thesis.setSupervisor(supervisor);
		thesis.setTitle(title);
		thesis.setApproved(approved);

		// 保存对象进数据库
		session.save(thesis);
		session.getTransaction().commit();
	}

	public void deleteThesis(int id) {
		session.beginTransaction();
		Thesis thesis = this.getThesisById(id);

		session.delete(thesis);
		session.getTransaction().commit();
	}

}
