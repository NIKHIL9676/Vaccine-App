package com.vaccine.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaccine.entity.MemberEntity;


@Component
public class EditMemberEntityDAOImpl implements EditMemberEntityDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public EditMemberEntityDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean updateMemberEntity(int MEMBER_ID, String ID_PROOF_NO, String No_OF_DOSE, String MEMBER_Name) {
        Session session = null;
        Transaction transaction = null;
        boolean isMemberEntityUpdated = false;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            MemberEntity entity = session.get(MemberEntity.class, MEMBER_ID);

            // Check if the entity exists
            if (entity != null) {
                entity.setID_PROOF_NO(ID_PROOF_NO);
                entity.setNo_OF_DOSE(Integer.parseInt(No_OF_DOSE));
                entity.setMEMBER_Name(MEMBER_Name);
                session.update(entity);
                transaction.commit();
                isMemberEntityUpdated = true;
            }
        } catch (NumberFormatException e) {
            // Handle the NumberFormatException (e.g., log, throw a custom exception, etc.)
            e.printStackTrace();
        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return isMemberEntityUpdated;
    }
}
