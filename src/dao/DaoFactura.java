package dao;

import java.sql.SQLException;

import entidades.Factura_Producto;

public interface DaoFactura extends Dao<Factura_Producto>{

    void addFactura( int idFactura,int idCliente) throws SQLException;


}
