package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.bd.PoolDB;
import org.iesalixar.servidor.model.Office;

public class DAOOfficeImpl implements DAOOffice {

	@Override
	public List<Office> getAllOffices() {

		ArrayList<Office> officesList = new ArrayList<>();
		Office office = null;
		Connection con = null;
		try {

			String sql = "select * from offices";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {

				office = new Office();
				office.setOfficeCode(rs.getString("officeCode"));
				office.setCity(rs.getString("city"));
				office.setPhone(rs.getString("phone"));
				office.setAddressLine1(rs.getString("addressLine1"));
				office.setAddressLine2(rs.getString("addressLine2"));
				office.setState(rs.getString("state"));
				office.setCountry(rs.getString("country"));
				office.setPostalCode(rs.getString("postalCode"));
				office.setTerritory(rs.getString("territory"));

				officesList.add(office);

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return officesList;

	}

	@Override
	public Office getByNameOffice(String city) {
		Office office = null;
		Connection con = null;
		try {

			String sql = "select * from offices where city = ?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, city);
			ResultSet rs = statement.executeQuery();

			
			while (rs.next()) {

				office = new Office();
				
				office.setOfficeCode(rs.getString("officeCode"));
				office.setCity(rs.getString("city"));
				office.setPhone(rs.getString("phone"));
				office.setAddressLine1(rs.getString("addressLine1"));
				office.setAddressLine2(rs.getString("addressLine2"));
				office.setState(rs.getString("state"));
				office.setCountry(rs.getString("country"));
				office.setPostalCode(rs.getString("postalCode"));
				office.setTerritory(rs.getString("territory"));

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return office;
	}

	@Override
	public boolean insertOffice(Office office) {
		
		int resultado = 0;
		Connection con = null;

		try {

			String sql = "insert into offices values(?,?,?,?,?,?,?,?,?)";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setString(1, office.getOfficeCode());
			statement.setString(2, office.getCity());
			statement.setString(3, office.getPhone());
			statement.setString(4, office.getAddressLine1());
			statement.setString(5, office.getAddressLine2());
			statement.setString(6, office.getState());
			statement.setString(7, office.getCountry());
			statement.setString(8, office.getPostalCode());
			statement.setString(9, office.getTerritory());
			

			resultado = statement.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return (resultado == 0 ? false : true);
	}

	@Override
	public boolean Office(Office office) {

		int resultado = 0;
		Connection con=null;
		

		try {

			String sql = "update offices set  city=?, phone=?, addressLine1=?, addressLine2=?, state=?, country=?, postalCode=?, territory=?  where officeCode = ?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			
			
			statement.setString(1, office.getCity());
			statement.setString(2, office.getPhone());
			statement.setString(3, office.getAddressLine1());
			statement.setString(4, office.getAddressLine2());
			statement.setString(5, office.getState());
			statement.setString(6, office.getCountry());
			statement.setString(7, office.getPostalCode());
			statement.setString(8, office.getTerritory());
			statement.setString(9, office.getOfficeCode());
			

			resultado = statement.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return (resultado == 0 ? false : true);

	}

	@Override
	public boolean removeOffice(String officeCode) {

			int resultado = 0;
			Connection con = null;

			try {

				String sql = "delete from offices where officeCode=?";
				PoolDB pool = new PoolDB();
				con = pool.getConnection();
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setString(1, officeCode);				

				resultado = statement.executeUpdate();
				

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			return (resultado == 0 ? false : true);

		}

	@Override
	public boolean updateOffice(Office office) {
		int resultado = 0;
		Connection con=null;
		

		try {

			String sql = "update offices set  city=?, phone=?, addressLine1=?, addressLine2=?, state=?, country=?, postalCode=?, territory=? where officeCode = ?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setString(1, office.getCity());
			statement.setString(2, office.getPhone());
			statement.setString(3, office.getAddressLine1());
			statement.setString(4, office.getAddressLine2());
			statement.setString(5, office.getState());
			statement.setString(6, office.getCountry());
			statement.setString(7, office.getPostalCode());
			statement.setString(8, office.getTerritory());
			statement.setString(9, office.getOfficeCode());
			
			

			resultado = statement.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return (resultado == 0 ? false : true);

	}

	@Override
	public Office getOffice(String officeCode) {
		Office office = null;
		Connection con = null;
		try {

			String sql = "select * from offices where officeCode = ?";
			PoolDB pool = new PoolDB();
			con = pool.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, officeCode);
			ResultSet rs = statement.executeQuery();

			
			while (rs.next()) {

				office = new Office();
				
				office.setOfficeCode(rs.getString("officeCode"));
				office.setCity(rs.getString("city"));
				office.setPhone(rs.getString("phone"));
				office.setAddressLine1(rs.getString("addressLine1"));
				office.setAddressLine2(rs.getString("addressLine2"));
				office.setState(rs.getString("state"));
				office.setCountry(rs.getString("country"));
				office.setPostalCode(rs.getString("postalCode"));
				office.setTerritory(rs.getString("territory"));

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return office;
	}
	

	}
