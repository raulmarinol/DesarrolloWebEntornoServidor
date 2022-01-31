package org.iesalixar.servidor.utils.dao;

import java.util.List;

import org.iesalixar.servidor.model.Comments;

public interface GenericDAO<T> {

	
	public void insert(final T objetT);
	
	public void update(final T objectT);	
	
	public void delete(final T objectT);
	
	public Comments searchById(final Long id);
	
	public List<T> searchAll();
	
}
