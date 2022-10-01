package factory;

import mysql.DaoClienteMySQL;

import mysql.DaoFacturaMySQL;
import mysql.DaoFacturaProductoMySQL;
import mysql.DaoProductoMySQL;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import dao.DaoCliente;
import dao.DaoFactura;
import dao.DaoFacturaProducto;
import dao.DaoProducto;

public class My_SQL_DAO_Factory implements Dao_Factory {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    private static final String URI = "jdbc:mysql://localhost:3306/db_integrador";
    private static My_SQL_DAO_Factory miConector;
    private static Connection c;

    private My_SQL_DAO_Factory() throws SQLException {
    	this.createDatabase();
    }
    
	static Dao_Factory getFactory() throws SQLException {
		if(miConector == null) {
			miConector = new My_SQL_DAO_Factory();
		}
		return miConector;
	}

    public Connection getIntance() throws SQLException  {
    	if(c != null) {
    		return c;
    	}else {
    		
    		try {
    			Class.forName(DRIVER).getDeclaredConstructor().newInstance();
    		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
    				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
    			e.printStackTrace();
    			System.exit(1);
    		}
    		c = DriverManager.getConnection(URI, "root", "password");
    		c.setAutoCommit(false);
    		return c;    		
    	}

	}

	private void createDatabase() throws SQLException {
        // SQL command to create a database in MySQL.		
        String sql = "CREATE DATABASE IF NOT EXISTS db_intgrador";
        String url = "jdbc:mysql://localhost:3306/db_integrador";
        c = DriverManager.getConnection(url, "root", "12345");
        c.setAutoCommit(false);
        c.prepareStatement(sql).execute();
        c.commit();
	}
	
	public void createTable() throws SQLException {
		c = getIntance();
		
		String tablaProducto = "CREATE TABLE IF NOT EXISTS Producto("
				+ "idProducto INT,"
				+ "nombre VARCHAR(45),"
				+ "valor FLOAT,"
				+ "PRIMARY KEY(idProducto))";

		c.prepareStatement(tablaProducto).execute();
		c.commit();

		String tablaCliente = "CREATE TABLE IF NOT EXISTS Cliente("
				+ "idCliente INT,"
				+ "nombre VARCHAR(500),"
				+ "email VARCHAR(150),"
				+ "PRIMARY KEY(idCliente))";
		c.prepareStatement(tablaCliente).execute();
		c.commit();
		
		
		String tablaFactura = "CREATE TABLE IF NOT EXISTS Factura("
				+ "idFactura INT,"
				+ "idCliente_FK INT,"
				+ "PRIMARY KEY(idFactura),"
				+ "FOREIGN KEY(idCliente_FK) references Cliente(idCliente))";

		c.prepareStatement(tablaFactura).execute();
		c.commit();
		
		String tablaFactura_Producto = "CREATE TABLE IF NOT EXISTS Factura_Producto("
				+ "idFactura INT,"
				+ "idProducto INT,"
				+ "cantidad INT,"
				+ "PRIMARY KEY(idFactura, idProducto),"
				+ "FOREIGN KEY(idFactura) references Factura(idFactura),"
				+ "FOREIGN KEY(idProducto) references Producto(idProducto))";

		c.prepareStatement(tablaFactura_Producto).execute();
		c.commit();
		//c.close();
	}

    public DaoCliente getDaoCliente() throws SQLException {
        return new DaoClienteMySQL();
    }

    public DaoFactura getDaoFactura() throws SQLException {
        return new DaoFacturaMySQL();
    }

    public DaoProducto getDaoProducto() throws SQLException {
        return new DaoProductoMySQL();
    }

    public DaoFacturaProducto getDaoFacturaProducto() throws SQLException {
        return new DaoFacturaProductoMySQL();
    }

	
}
