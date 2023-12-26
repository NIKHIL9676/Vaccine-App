package com.vaccine.dao;

import java.io.Serializable;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaccine.entity.RegisterEntity;
import com.vaccine.service.MailService;

@Component
public class RegisterDAOImpl implements RegisterDAO {

	private SessionFactory sessionFactory;
	private MailService mailService;

	@Autowired
	public RegisterDAOImpl(SessionFactory sessionFactory, MailService mailService) {
		super();
		System.out.println("Creating the Object of SessionFactory by @Autowired annotation");
		System.out.println();
		this.mailService = mailService;
		this.sessionFactory = sessionFactory;
		System.out.println("Session factory dao constructor...");
	}

	@Override
	public boolean saveRegisterEntity(RegisterEntity entity) {
		Session session = null;
		Transaction transaction = null;
		boolean isValid = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Serializable save = session.save(entity);
			System.out.println("Save" + save);
			transaction.commit();

			String body = "\t\t\t\n Hi " + entity.getUSERNAME()
					+ "\n You have been successfully registered \n use the following credentials \n username : "
					+ entity.getUSERNAME() + "\n Password : " + entity.getPASSWORD() + "  ";
			mailService.sendMail(entity.getEMAIL_ID(), "Registered Successfully", body);
			System.out.println("Mail Sent successfully");
			System.out.println();

			isValid = true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return isValid;
	}
}
