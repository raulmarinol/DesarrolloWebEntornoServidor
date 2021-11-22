package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.Offices;
public interface DAOOffices  {
	
	public Offices getOffices(String officeCode);
	public ArrayList<Offices> getProductSearch(String searchTerm);

}
