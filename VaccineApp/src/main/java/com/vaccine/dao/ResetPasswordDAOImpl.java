package com.vaccine.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaccine.entity.RegisterEntity;
import com.vaccine.service.MailService;

@Component
public class ResetPasswordDAOImpl implements ResetPasswordDAO {

    private  SessionFactory sessionFactory;
    
    @Autowired
    MailService mailService;
    
    

    @Autowired
    public ResetPasswordDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    
    public ResetPasswordDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}


	public boolean ResetPasswordByMail(String email, String password) {
        Session session = null;
        String updatePassword = "UPDATE RegisterEntity SET PASSWORD=:password WHERE EMAIL_ID=:email";
        int count = 0;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery(updatePassword);
            query.setParameter("password", password);
            query.setParameter("email", email);

            
            count = query.executeUpdate();
            
            mailService.sendMail(email, "Password updated succesfully", "\n Your account password has changed successfully..! \n\n use the below credentials for login \n\n Email Id "+email+"\n \n password "+password);
            
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            // Log or handle the exception appropriately
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return count > 0;
    }

	@Override
	public boolean checkEntityByMail(String email) {
	    Session session = null;
	    String selectByEmail = "FROM RegisterEntity WHERE EMAIL_ID = :email";
	    
	    try {
	        session = sessionFactory.openSession();
	        Query query = session.createQuery(selectByEmail);
	        query.setParameter("email", email);

	        List<RegisterEntity> resultList = query.list();

	        // Check if the list is not empty
	        if (!resultList.isEmpty()) {
	            return true;
	        }
	    } catch (Exception e) {
	        // Log or handle the exception appropriately
	        e.printStackTrace();
	    } finally {
	        if (session != null && session.isOpen()) {
	            session.close();
	        }
	    }

	    return false;
	}

    
    
    
}
