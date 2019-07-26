package com.xworkz.appzone.model.dao.login;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.appzone.dto.login.LoginDTO;
import com.xworkz.appzone.entity.login.LoginEntity;
import com.xworkz.appzone.exception.DAOException;

@Component
public class LoginDAOImpl implements LoginDAO {

	private static final Logger logger = Logger.getLogger(LoginDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public LoginDAOImpl() {
		logger.info("created " + getClass().getSimpleName());
	}

	public LoginEntity getByUserName(LoginDTO user) throws DAOException {
		logger.info("inside save method of dao");
		Session session = sessionFactory.openSession();
		try {
			String hqlQuery = "select login from LoginEntity as login where login.userName='" + user.getUserName()
					+ "' And login.password='" + user.getPassword() + "'";
			Query query = session.createQuery(hqlQuery);
			LoginEntity login = (LoginEntity) query.uniqueResult();
			return login;
		} catch (HibernateException e) {
			logger.error(e.getMessage());
			throw new DAOException(e.getMessage());
		} finally {
			session.close();
		}
	}

	public LoginEntity fetchByEmailId(String email) throws DAOException {
		logger.info("invoked fetchByEmailId DAO");
		Session session = sessionFactory.openSession();
		try {
			String hqlQuery = "select user from LoginEntity as user where user.emailId=:email";
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

	@SuppressWarnings("unchecked")
	public List<String> fetchRole() throws DAOException {
		logger.info("inside fetchRole method");
		Session session = sessionFactory.openSession();
		try {
			String hqlQuery = "select Distinct(user.role) from LoginEntity user";
			Query query = session.createQuery(hqlQuery);
			List<String> roles = query.list();
			return roles;
		} catch (HibernateException e) {
			logger.info(e.getMessage());
			throw new DAOException(e.getMessage());
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<String> fetchUserNames() throws DAOException {
		logger.info("inside fetchRole method");
		Session session = sessionFactory.openSession();
		try {
			String hqlQuery = "select user.userName from LoginEntity user";
			Query query = session.createQuery(hqlQuery);
			List<String> names = query.list();
			return names;
		} catch (HibernateException e) {
			logger.info(e.getMessage());
			throw new DAOException(e.getMessage());
		} finally {
			session.close();
		}
	}

	public int updateRoleByUserName(String userName, String role) throws DAOException {
		logger.info("inside updateRoleByUserName method");
		Session session = sessionFactory.openSession();
		try {
			String hqlQuery = "update LoginEntity user set user.role=:role where user.userName=:name";
			Query query = session.createQuery(hqlQuery);
			query.setParameter("role", role);
			query.setParameter("name", userName);
			return query.executeUpdate();
		} catch (HibernateException e) {
			logger.info(e.getMessage());
			throw new DAOException(e.getMessage());
		} finally {
			session.close();
		}
	}

}
