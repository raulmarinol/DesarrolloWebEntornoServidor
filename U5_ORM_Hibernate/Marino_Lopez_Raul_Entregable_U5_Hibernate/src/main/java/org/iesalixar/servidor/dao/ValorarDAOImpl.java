package org.iesalixar.servidor.dao;

import org.hibernate.Session;
import org.iesalixar.servidor.model.Valorar;
import org.iesalixar.servidor.utils.dao.GenericDAOImpl;

public class ValorarDAOImpl extends GenericDAOImpl<Valorar> implements ValorarDAO{
	
	private Session session;

	public ValorarDAOImpl(Session session) {
		super(session);
		this.session = session;
	}

}
