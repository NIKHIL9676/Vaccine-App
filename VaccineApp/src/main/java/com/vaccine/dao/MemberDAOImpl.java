package com.vaccine.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaccine.entity.MemberEntity;
import com.vaccine.entity.RegisterEntity;

@Component
public class MemberDAOImpl implements MemberDAO {

	SessionFactory sessionFactory;

	@Autowired
	public MemberDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public MemberDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRegisterIdByMail(String EMAIL_ID) {
		String getRegisterEntityHql = "from RegisterEntity WHERE EMAIL_ID = :email";
		Session session = null;
		int id = 0;

		try {
			session = sessionFactory.openSession();
			Query<RegisterEntity> query = session.createQuery(getRegisterEntityHql, RegisterEntity.class);
			query.setParameter("email", EMAIL_ID);
			RegisterEntity entity = query.uniqueResult();

			if (entity != null) {
				id = entity.getID();
			} else {
				System.out.println("No matching entity found for email: " + EMAIL_ID);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return id;
	}
	
	

	@Override
	public boolean saveMemberEntity(MemberEntity entity) {
		Session session = null;
		Transaction transaction = null;
		boolean isMemberEntitySaved = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();
			isMemberEntitySaved = true;

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			// TODO: handle exception
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return isMemberEntitySaved;
	}

	@Override
	public boolean updateRegisterEntityNoOfMembers(String email) {
		Session session = null;
		Transaction transaction = null;
		String Update_Query = "UPDATE RegisterEntity SET NO_OF_MEMBERS = NO_OF_MEMBERS + 1 WHERE EMAIL_ID = :email";

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
	public List<MemberEntity> getAllMemberEntityById(int id) {
		System.out.println("Inside the getAllMemberEntityById method");

		Session session = null;
		String getAllMemberEntity = "FROM MemberEntity WHERE ID=:id";

		List<MemberEntity> members = null;
		try {
			System.out.println("Inside the try block");
			session = sessionFactory.openSession();
			Query query = session.createQuery(getAllMemberEntity);
			query.setParameter("id", id);
			System.out.println(getAllMemberEntity);
			System.out.println("HQL " + getAllMemberEntity);
			members = query.getResultList();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception ...!");
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close(); // Close the session in a finally block
			}
		}

		return members;
	}



	public int getRegtisterNoOfMembersByMail(String EMAIL_ID) {
		String getRegisterEntityHql = "from RegisterEntity WHERE EMAIL_ID = :email";
		Session session = null;
		int No_OF_MEMBERS = 0;

		try {
			session = sessionFactory.openSession();
			Query<RegisterEntity> query = session.createQuery(getRegisterEntityHql, RegisterEntity.class);
			query.setParameter("email", EMAIL_ID);
			RegisterEntity entity = query.uniqueResult();

			if (entity != null) {
				No_OF_MEMBERS = entity.getNO_OF_MEMBERS();
			} else {
				System.out.println("No matching entity found for email: " + EMAIL_ID);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return No_OF_MEMBERS;
	}
	
	
	
	
}
