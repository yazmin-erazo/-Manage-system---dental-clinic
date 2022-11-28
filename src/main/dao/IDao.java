package main.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDao<Type> {

    public Type add(Type type) throws SQLException;

    public void remove(int id);

    public Type search(int id);

    public List<Type> listAll();



}
