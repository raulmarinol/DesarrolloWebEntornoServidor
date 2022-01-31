package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.dao.ValorarDAO;
import org.iesalixar.servidor.dao.ValorarDAOImpl;
import org.iesalixar.servidor.model.Valorar;

public class ValorarServiceImpl implements ValorarService{

	private UserDAO valorarDao;

	public ValorarServiceImpl(final Session session) {
		this.valorarDao = new UserDAOImpl(session);
	}

	@Override
	public void insertNewValorar(Valorar valorar) {

		if (valorar != null && valorar.getId() == null) {
			
			valorarDao.insert(valorar);
		}

	}

	@Override
	public void updateValorar(Valorar valorar) {
		
		if (valorar != null && valorar.getId() != null) {

			valorarDao.update(valorar);
		}

	}

	@Override
	public void deleteValorar(Valorar valorar) {
		
		if (valorar != null && valorar.getId() != null) {

			valorarDao.delete(valorar);
		}
	}

	@Override
	public Valorar searchById(Long valorarId) {
		User valorar = null;

		if (valorarId != null) {

			valorar = valorarDao.searchById(valorarId);
		}

		return valorar;
	}

	@Override
	public List<Valorar> searchAll() {
		
		List<Valorar> valorarList = new ArrayList<Valorar>();

		valorarList = valorarDao.searchAll();

		return valorarList;
	}

	

}


