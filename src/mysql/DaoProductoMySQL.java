package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DaoProducto;
import factory.Dao_Factory;

public class DaoProductoMySQL implements DaoProducto<Object> {

	public DaoProductoMySQL() throws SQLException {
	}

	@Override
	public void eliminarProducto() {

	}

	@Override
	public void editarProducto() {

	}

	@Override
	public void addProduct( int id, String name, int value) throws SQLException {
		Connection c = Dao_Factory.get_Factory(Dao_Factory.MYSQL_JDBC).getIntance();
		String insert = "INSERT INTO Producto (idProducto, nombre, valor) VALUES (?, ?, ?)";
		PreparedStatement ps = c.prepareStatement(insert);
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setInt(3, value);
		ps.executeUpdate();
		ps.close();
		c.commit();
		//c.close();
	}

	@Override
	public String masVendido() throws SQLException {
		Connection c = Dao_Factory.get_Factory(Dao_Factory.MYSQL_JDBC).getIntance();
		String consulta = "SELECT FP.idProducto, P.nombre\n"
				+ "FROM Factura_Producto FP JOIN Producto P ON FP.idProducto = P.idProducto\n"
				+ "GROUP BY FP.idProducto, P.nombre, P.valor\n" 
				+ "ORDER BY SUM(cantidad) * P.valor DESC\n"
				+ "LIMIT 1";

		java.sql.PreparedStatement ps = c.prepareStatement(consulta);
		ResultSet rs = ps.executeQuery();

		String product = "No Se Encontraron Resultados";
		while (rs.next()) {
			product = rs.getInt(1) + ", " + rs.getString(2);
		}
		//c.close();
		return product;
	}

	@Override
	public void getAll() throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
