package application;


import java.sql.SQLException;
import java.util.Scanner;


import service.DbService;

public class Program {
	public static void main(String[] args) throws SQLException{
		programMain();
		
	}
	
	
	public static void programMain()  {
		Scanner sc = new Scanner(System.in);
		DbService service = new DbService();
		try{
			int quantityFunc = 6;
			char caracter;
			int escolha;
			do {
				
				 System.out.printf("1- add User%n2- acess the User%n3- modific User%n4- acess list Users%n5- delete User%n");
				 escolha = sc.nextInt();
				 if(escolha < 1 || escolha > quantityFunc) {
					 
					 System.out.println("Valor incorreto! Digite novamente.");
					 escolha = sc.nextInt();
				 }
				 
				 
				service.dbService(escolha, sc);
				 
				
				
				
				System.out.println("Deseja continuar com o sistema ? (s,n)");
				caracter = sc.next().charAt(0);
				
			} while(caracter == 's');	
			service.closeConnection();
			
		} catch(SQLException error) {
			System.out.println("System error program main: " + error.getMessage());
		} finally {
			sc.close();
			
		}
	}
}


