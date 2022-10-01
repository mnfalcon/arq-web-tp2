package factory;

import java.sql.Connection;

import java.sql.SQLException;

import dao.DaoCliente;
import dao.DaoFactura;
import dao.DaoFacturaProducto;
import dao.DaoProducto;


public interface Dao_Factory {
	public  final int MYSQL_JDBC = 1;
	public  final int DERBY_JDBC = 2;

	public abstract DaoCliente getDaoCliente() throws SQLException;
	public abstract DaoFactura getDaoFactura() throws SQLException;
	public abstract DaoProducto getDaoProducto() throws SQLException;
	public abstract DaoFacturaProducto getDaoFacturaProducto() throws SQLException;
	public abstract void createTable() throws SQLException;
	public abstract Connection getIntance() throws SQLException;

	public static Dao_Factory get_Factory(int factory) throws SQLException {
		switch (factory) {
		case MYSQL_JDBC:
			return My_SQL_DAO_Factory.getFactory();
		case DERBY_JDBC:
			return Derby_DAO_Factory.getFactory();
		default:
			return null;
		}
	}
}
