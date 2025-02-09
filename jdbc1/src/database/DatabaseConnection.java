package database;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
	
	private static Connection conn;
	
	
	
	public static Connection getConnection() {
		
		
		if(conn == null) {
			try{
				Properties props = loadProps();
				String url = props.getProperty("dburl");
				String user = props.getProperty("user");
				String password = props.getProperty("password");
				conn = DriverManager.getConnection(url, user, password);
			} catch(SQLException error) {
				throw new DbException("Error ao conectar com o Banco de Dados: " + error.getMessage() );
			}
		}
		return conn;
	}
	
	
	private static Properties loadProps() {
		Properties props = new Properties();
		try(FileReader rd = new FileReader(new File("db.properties"))){	
			props.load(rd);
		} catch (IOException error) {
			System.out.println("Erro ao ler o arquivo: " + error.getMessage());
		}
		return props;
	}
}
