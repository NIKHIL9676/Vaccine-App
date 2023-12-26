package com.vaccine.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaccine.entity.MemberEntity;

@Component
public class DeleteMemberEntityDAOImpl implements DeleteMemberEntityDAO {
	
	SessionFactory sessionFactory;
	
	@Autowired
	public DeleteMemberEntityDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public boolean updateRegisterEntityNoOfMembers(String email) {
		Session session = null;
		Transaction transaction = null;
		String Update_Query = "UPDATE RegisterEntity SET NO_OF_MEMBERS = NO_OF_MEMBERS - 1 WHERE EMAIL_ID = :email";

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(Update_Query).setParameter("email", email);
			int i = query.executeUpdate();
			if (i > 0) {
				transaction.commit();
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return false;
	}


	@Override
	public boolean deleteMemberEntityById(int MemberID) {
	    Session session = null;
	    boolean isMemberEntityDeleted = false;
	    Transaction transaction = null;

	    try {
	        session = sessionFactory.openSession();
	        transaction = session.beginTransaction();
	        MemberEntity entity = session.get(MemberEntity.class, MemberID);

	        if (entity != null) {
	            session.delete(entity);
	            isMemberEntityDeleted = true;
	        } else {
	            System.out.println("MemberEntity with ID " + MemberID + " not found.");
	        }

	        transaction.commit(); // Commit the transaction here if everything is successful
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	        // TODO: handle exception
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }

	    return isMemberEntityDeleted;
	}

}
