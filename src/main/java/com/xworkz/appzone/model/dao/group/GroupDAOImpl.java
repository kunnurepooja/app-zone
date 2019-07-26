package com.xworkz.appzone.model.dao.group;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.appzone.entity.group.GroupEntity;
import com.xworkz.appzone.entity.login.LoginEntity;
import com.xworkz.appzone.exception.DAOException;

@Repository
public class GroupDAOImpl implements GroupDAO {

	private static final Logger logger = Logger.getLogger(GroupDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public GroupDAOImpl() {
		logger.info("created " + getClass().getSimpleName());
	}

	public Integer saveGroup(GroupEntity groupEntity) throws DAOException {
		logger.info("invoked save method of DAO");
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			Integer id = (Integer) session.save(groupEntity);
			session.getTransaction().commit();
			logger.info("group saved successfully");
			return id;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			logger.error(e.getMessage());
			throw new DAOException(e.getMessage());
		} finally {
			session.close();
		}
	}

	public List<String> fetchAllGroupName() {
		logger.info("inside method of fetch all method of DAO");
		Session session = sessionFactory.openSession();
		try {
			String hqlQuery = "select entity.groupName from GroupEntity as entity";
			Query query = session.createQuery(hqlQuery);
			List<String> list = query.list();
			return list;
		} catch (HibernateException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	public LoginEntity fetchByEmailId(String email) throws DAOException {
		logger.info("invoked fetchByEmailId DAO");
		Session session = sessionFactory.openSession();
		try {
			String hqlQuery = "select user from Login"
					+ "Entity as user where user.emailId=:email";
			Query query = session.createQuery(hqlQuery);
			query.setParameter("email", email);
			LoginEntity entity = (LoginEntity) query.uniqueResult();
			return entity;
		} catch (HibernateException e) {
			logger.error(e.getMessage());
			throw new DAOException(e.getMessage());
		} finally {
			session.close();
		}
	}

}
