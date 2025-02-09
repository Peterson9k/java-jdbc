
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import Entities.Usuario;
import database.DatabaseConnection;
import database.DbException;

public class DatabaseOperation implements UserDao{
	
	private Connection conn;
	
	public DatabaseOperation() {
		this.conn = DatabaseConnection.getConnection();
	}
	
	@Override
	public void closeConnection() throws SQLException {
		if(conn != null) {
			conn.close();
		}
	}
	
	@Override
	public boolean addUser(Usuario user) throws SQLException {
		String sql = "INSERT INTO usuario (name, email) VALUES (?, ?)";

		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setString(1, user.getName());
			stmt.setString(2,  user.getEmail());
			int row = stmt.executeUpdate();
			return row > 0;
		}	
	}
	
	@Override
	public Usuario getUser(Integer id) throws SQLException{
		
		String sql = "SELECT * FROM usuario WHERE id = ?";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			Usuario user = null;
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				user = new Usuario(rs.getInt("id"), rs.getString("name"), rs.getString("email"));
				
			}
			
			if(user == null) {
				throw new DbException("Id nao encontrado no sistema!");
			}
			return user;
			
		}
	}
	
	@Override
	public boolean updateUser(Usuario updateUser) throws SQLException{
		String sql = "UPDATE usuario SET name = ?, email = ? WHERE id = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)){
			
			//if(getUser(id).getId() != id ) {
				//throw new DbException("User not exist!");
			//}
						
			stmt.setString(1, updateUser.getName());
			stmt.setString(2, updateUser.getEmail());
			stmt.setInt(3, updateUser.getId());
			
			
			int row = stmt.executeUpdate();
			return row > 0;
		}
	}
	
	@Override
	public boolean deleteUser(Integer id) throws SQLException {
		String sql = "DELETE FROM usuario WHERE id = ?";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setInt(1, id);
			int rows = stmt.executeUpdate();
			return rows > 0;
		}
	}
	
	@Override	
	public List<Usuario> getUsers() throws SQLException{
		List<Usuario> list = new ArrayList<Usuario>();
		String sql = "SELECT * FROM usuario";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql); 
			ResultSet rs = stmt.executeQuery();
			){
			
			while(rs.next()) {
				list.add(new Usuario(rs.getInt("id"), rs.getString("name"), rs.getString("email")));
			}
			
			
		}
		
		return list;
	}
}
