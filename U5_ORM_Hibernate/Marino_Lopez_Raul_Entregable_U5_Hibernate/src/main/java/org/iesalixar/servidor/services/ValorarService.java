package org.iesalixar.servidor.services;

import java.util.List;

import org.iesalixar.servidor.model.Valorar;

public interface ValorarService {
	
	public void insertNewUser(final Valorar valorar);	
	 
	public void updateUser(final Valorar valorar);	
	
	public void deleteUser(final Valorar valorar);
	
	public Valorar searchById(final Long valorarId);
	
	public List<Valorar> searchAll();

}
