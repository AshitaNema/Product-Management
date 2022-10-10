package com.nagarro.training.Advance_Java_Assignment_3.model;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

public class LoginDao {

	public boolean validate(Users user) throws ClassNotFoundException {
		boolean status = false;
		System.out.println(user.getPass() + " " + user.getUname());

		Session session = HibernateUtil.usersSF().openSession();

		// String newQuery = "from Users";

		String hql = "from Users t where t.uname = '" + user.getUname() + "' and t.pass = '" + user.getPass() + "'";

		Users result = null;

		try {
			result = (Users) session.createQuery(hql).getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("No User exits");
		}

		if (result != null) {
			status = true;
		}

		return status;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
