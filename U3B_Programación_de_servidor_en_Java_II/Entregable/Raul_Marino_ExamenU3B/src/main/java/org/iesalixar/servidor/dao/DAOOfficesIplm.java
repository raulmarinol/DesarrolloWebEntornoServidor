package org.iesalixar.servidor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.bd.ConexionBD;
import org.iesalixar.servidor.model.Offices;
import org.iesalixar.servidor.model.Product;

public class DAOOfficesIplm implements DAOOffices {

	@Override
	public Offices getOffices(String officeCode) {
	
		Offices office = null;

		try {

			String sql = "select * from offices where  officeCode=?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, officeCode);
			

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				office = new Offices();
				
				office.setOfficeCode(rs.getString("officeCode"));
				office.setOfficeCode(rs.getString("city"));
				office.setOfficeCode(rs.getString("phone"));
				office.setOfficeCode(rs.getString("addressLine1"));
				office.setOfficeCode(rs.getString("addressLine2"));
				office.setOfficeCode(rs.getString("state"));
				office.setOfficeCode(rs.getString("country"));
				office.setOfficeCode(rs.getString("postalCode"));
				office.setOfficeCode(rs.getString("territory"));

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			ConexionBD.close();
		}

		return office;

	}
	

	@Override
	public ArrayList<Offices> getProductSearch(String searchTerm) {
		
		ArrayList<Offices> offices = new ArrayList<Offices>();
		Offices office = null;

		try {

			String sql = "select * from offices where  officeCode =  ? OR productLine LIKE ?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			statement.setString(1, "%"+searchTerm+"%");
			statement.setString(2, "%"+searchTerm+"%");
			

			ResultSet rs = statement.executeQuery();

			
			while (rs.next()) {

				office = new Offices();
				office.setOfficeCode(rs.getString("officeCode"));
				office.setOfficeCode(rs.getString("city"));
				office.setOfficeCode(rs.getString("phone"));
				office.setOfficeCode(rs.getString("addressLine1"));
				office.setOfficeCode(rs.getString("addressLine2"));
				office.setOfficeCode(rs.getString("state"));
				office.setOfficeCode(rs.getString("country"));
				office.setOfficeCode(rs.getString("postalCode"));
				office.setOfficeCode(rs.getString("territory"));
				
				offices.add(office);

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			ConexionBD.close();
		}

		return offices;

	}
		
	}

	


