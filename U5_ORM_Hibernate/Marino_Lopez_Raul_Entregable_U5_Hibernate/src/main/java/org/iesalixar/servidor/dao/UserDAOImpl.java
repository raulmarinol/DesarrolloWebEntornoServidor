package org.iesalixar.servidor.dao;

import java.util.List;


import org.hibernate.Session;
import org.iesalixar.servidor.model.User;
import org.iesalixar.servidor.utils.dao.GenericDAOImpl;

public class UserDAOImpl extends GenericDAOImpl<User> implements UserDAO {

	private Session session;

	public UserDAOImpl(Session session) {
		super(session);
		this.session = session;
	}

	

}
