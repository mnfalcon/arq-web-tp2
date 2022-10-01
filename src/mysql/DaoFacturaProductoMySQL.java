package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.DaoFacturaProducto;
import factory.Dao_Factory;

public class DaoFacturaProductoMySQL implements DaoFacturaProducto {

	public DaoFacturaProductoMySQL() throws SQLException{

	}

	@Override
	public void addFacturaProducto( int idFactura, int idProducto, int cantidad) throws SQLException {
		Connection c = Dao_Factory.get_Factory(Dao_Factory.MYSQL_JDBC).getIntance();
		String insert = "INSERT INTO Factura_Producto (idFactura, idProducto,cantidad) VALUES (?, ?,?)";
		PreparedStatement ps = c.prepareStatement(insert);
		ps.setInt(1, idFactura);
		ps.setInt(2, idProducto);
		ps.setInt(3, cantidad);
		ps.executeUpdate();
		ps.close();
		c.commit();
		//c.close();
	}
}
