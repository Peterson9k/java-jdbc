package dao;

import java.sql.SQLException;
import java.util.List;

import Entities.Usuario;

public interface UserDao {
	boolean addUser(Usuario user) throws SQLException;
	Usuario getUser(Integer id) throws SQLException;
	boolean updateUser(Usuario user) throws SQLException;
	boolean deleteUser(Integer id) throws SQLException;
	List<Usuario> getUsers() throws SQLException;
	void closeConnection() throws SQLException;
	
}
