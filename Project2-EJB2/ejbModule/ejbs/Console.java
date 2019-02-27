package ejbs;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

import javax.ejb.EJB;
import ejbs.CRUDBean;
import ejbs.CRUDBeanLocal;

public class Console {
	@EJB 
	static
	CRUDBean bean;
	 
	public static void main(String[] args) throws SQLException {
		
	    Console console = new Console();
	    console.run();
			
	}
	private void run() throws SQLException {
		Connection connection;
		String url="jdbc:mysql://localhost:3306/mysqldb";
		String username = "root";
		String password2 = "root";
		connection= (Connection) DriverManager.getConnection(url, username, password2);
		Scanner scanner = new Scanner(System.in);
	    short number;
	    int id;
	    String nome,password;
	    while (true){
	    	String query="";
			System.out.println("Consola de Admin:\n1 - Novo admin, 2- Apagar Admin");
			
			while(true){
				try{
					number = scanner.nextShort();
					break;
				}catch(Exception e){
					System.out.println("--tente novamente\n");
				}
			}
			if (number==1){
				System.out.println("Insira o nome do admin:");
			    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				while(true){
					try{
						nome = reader.readLine();
						break;
					}catch(Exception e){
						System.out.println("--tente novamente\n");
					}
				}
				System.out.println("Insira a password do admin:");
				while(true){
					try{
						password = reader.readLine();
						break;
					}catch(Exception e){
						System.out.println("--tente novamente\n");
					}
				}
				//bean.WriteDataAdmin(nome, password);
				Random r = new Random();
				id = r.nextInt(100);
				query = "INSERT INTO admin(id,name,pasword) VALUES('"+id+"','"+nome+"', '"+password+"')";
			}else{
				System.out.println("Insira o ID do admin a apagar:");
				while(true){
					try{
						id = scanner.nextInt();
						break;
					}catch(Exception e){
						System.out.println("--tente novamente\n");
					}
				}
				//bean.DeleteAdmin(id);
				query = "DELETE FROM admin WHERE id = +'"+id+"'";
			}
			PreparedStatement preparedStmt = (PreparedStatement) connection.prepareStatement(query);
		      
		      preparedStmt.execute();
	    }
	    
	}
}
