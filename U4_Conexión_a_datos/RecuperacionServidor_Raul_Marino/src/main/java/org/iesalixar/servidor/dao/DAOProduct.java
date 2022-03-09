package org.iesalixar.servidor.dao;

import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.model.Product;

public interface DAOProduct {
	
	public Product getProduct(String productName);
	public Product getProductByCode(String code);
	public ArrayList<Product> getProductSearch(String searchTerm);
	public List<Product> getAllProducts();
	public boolean updateProduct(Product product);
	public boolean cambiarProductLine(String productLine,String productName);

}
