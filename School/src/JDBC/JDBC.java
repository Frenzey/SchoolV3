/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import javax.swing.JOptionPane;

public class JDBC {
	static String pilote="com.mysql.jdbc.Driver";
	static String url="jdbc:mysql://localhost:3306/schoolSQL";
	static String user="root";
	static String mdp ="";
	
	public static Connection connexion = null;
	public static Statement st =null;
	public static PreparedStatement ps=null;
	public static ResultSet rs =null;

	public static void getConnexion(){
		try {
			System.out.println("Connexion � la BD ...");
			Class.forName("com.mysql.jdbc.Driver");
			connexion = DriverManager.getConnection(url, user, mdp);
			System.out.println("Connexion r�ussi !!");
			//JOptionPane.showMessageDialog(null,
					//"Vous avez r�ussi vous connecter au serveur .","Message d\'erreur", JOptionPane.INFORMATION_MESSAGE);
		}
		catch (ClassNotFoundException e) {
			System.out.println("Echec de la connexion � la BD");
			e.printStackTrace();
		}
		catch (SQLException e) {
			System.out.println("Echec lors de l'identification");
			e.printStackTrace();
		}
	}
	public static Connection getInstance(){

		if(connexion == null){
			new JDBC();
			System.out.println("connexion unique");
		}
		//test du singleton 
		else{
			System.out.println("connexion multiple");
		}
		return connexion;   
	}
}