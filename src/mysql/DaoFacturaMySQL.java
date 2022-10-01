package mysql;

import dao.DaoFactura;
import factory.Dao_Factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoFacturaMySQL implements DaoFactura {

	public DaoFacturaMySQL() throws SQLException{

	}

	@Override
	public void addFactura( int idFactura, int idCliente_FK) throws SQLException {
		Connection c = Dao_Factory.get_Factory(Dao_Factory.MYSQL_JDBC).getIntance();
		String insert = "INSERT INTO Factura (idFactura, idCliente_FK) VALUES (?, ?)";
		PreparedStatement ps = c.prepareStatement(insert);
		ps.setInt(1, idFactura);
		ps.setInt(2, idCliente_FK);
		ps.executeUpdate();
		ps.close();
		c.commit();
		//c.close();
	}
}
