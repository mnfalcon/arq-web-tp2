package dao;
import entidades.Cliente;

import java.sql.SQLException;
import java.util.HashMap;

public interface DaoCliente<T> extends Dao<Cliente>{
     
    void addCliente(int id, String nombre, String email ) throws SQLException;

    HashMap<String, Integer> masFacturados() throws SQLException;
}