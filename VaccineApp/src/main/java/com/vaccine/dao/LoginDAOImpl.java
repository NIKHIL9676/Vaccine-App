package com.vaccine.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaccine.entity.RegisterEntity;

@Component
public class LoginDAOImpl implements LoginDAO {

	SessionFactory sessionFactory;

	@Autowired
	public LoginDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public RegisterEntity getRegisterEntityByEmail(String email) {
		String getAllEntity = "from RegisterEntity WHERE EMAIL_ID=:email";
		Session session = null;

		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery(getAllEntity);
			query.setParameter("email", email);
			return (RegisterEntity) query.uniqueResult();

		} catch (Exception e) {
			// TODO: handle exception
			if (session != null) {
				session.close();
			}
		}

		return null;
	}

	@Override
	public boolean updateEntityLoginAttempts(RegisterEntity entity) {
		Session session = null;
		Transaction transaction = null;
		boolean isEntityUpdated=false;
		try {
			session=sessionFactory.openSession();
			transaction = session.beginTransaction();

			session.update(entity);

			transaction.commit();
			isEntityUpdated=true;
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
		}finally {
			if(session!=null) {
				session.close();
			}
		}

		return isEntityUpdated;
	}

}
