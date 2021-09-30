package ejercicio4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import conector.Conector;
import objects.Product;

public class PaymentImpl implements PaymentDAO{
	
	public Payment  createPayment(Payment payment) {
		Connection con2 = Conector.getConnection();
		String sql = "select * from Payment WHERE customerNumber = ?";
		
		try(PreparedStatement stmt = con2.prepareStatement(sql)) {
			System.out.println("Ha entrado");
			stmt.setString(1,name);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				System.out.println("Hay Payment");
				int customerNumber1 = result.getInt("customerNumber");
				String checkNumber= result.getString("checkNumbe");
				String paymentDate = result.getString("paymentDate");
				double amount = result.getDouble("amount");
				return new Product(customerNumber,checkNumber,paymentDate,amount);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("No ha entrado");
		return null;
	}

	@Override
	public List<Payment> getPayment() {
		// TODO Auto-generated method stub
		return null;
	}
}
