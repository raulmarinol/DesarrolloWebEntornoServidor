package org.iesalixar.servidor.dao;

import java.util.List;


import org.iesalixar.servidor.model.Office;

public interface DAOOffice {

	public List<Office> getAllOffices();
	public Office getByNameOffice(String name);
	public Office getOffice(String officeCode);
	public boolean insertOffice(Office office);
	public boolean Office(Office office);
	public boolean removeOffice(String officeCode);
	public boolean updateOffice(Office office);
	
}
