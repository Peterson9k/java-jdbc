package service;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import Entities.Usuario;
import dao.DatabaseOperation;
import dao.UserDao;

public class DbService{
	private UserDao daoUser = new DatabaseOperation();
	
	public  void dbService(Integer value,  Scanner sc ) throws SQLException{
			switch (value) {
				
			case 1: 
				System.out.print("Digite o nome do usuario: ");
				String setName = sc.next();
				System.out.print("Digite o email do usuario: ");
				String setEmail = sc.next();
				daoUser.addUser(new Usuario(setName, setEmail));
			break;
			
			case 2:
				System.out.print("Digite o id do usuario: ");
				int acessId = sc.nextInt();
				System.out.println(daoUser.getUser(acessId));
			break;
			
			case 3:
				System.out.print("Digite o id do usuario que deseja modificar: ");
				int updateId = sc.nextInt();
				System.out.print("Digite um novo nome: ");
				String updateName = sc.next();
				System.out.print("Digite um novo email: ");
				String updateEmail = sc.next();
				System.out.println("Value atualizado: " + daoUser.updateUser(new Usuario(updateId, updateName, updateEmail)));
								
			break;
			
			case 4:
				System.out.println("Acessar lista de usuarios: ");
				daoUser.getUsers().forEach(System.out::println);
			break;
			
			case 5:
				System.out.print("Digite o Id do usuario que deseja deletar: ");
				int deleteId = sc.nextInt();
				System.out.println("Value deletado: " +  daoUser.deleteUser(deleteId));
			break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + value);
				
			}
	}
	
	public  void closeConnection() throws SQLException {
		daoUser.closeConnection();
	}
	
	
}


