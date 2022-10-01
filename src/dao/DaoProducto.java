package dao;

import entidades.Producto;
import java.sql.SQLException;

public interface DaoProducto<T> extends Dao<Producto>{

		void getAll() throws SQLException;
	    
	    void addProduct( int id, String name, int value) throws SQLException;//guardar en la db	  

		void eliminarProducto();

		void editarProducto();
		
		String masVendido() throws SQLException;
}
