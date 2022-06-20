package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import metiers.Apprenants;
import metiers.Formateurs;

public class ApprenantsDAO {
	
	private Connection connexion;
//	*******************************CONNECTION A LA BDD********************************************************
	public void ConnexionBDD()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		try {
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/memoire", "root", "adama");
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}	
	
//	*******************************AJOUTER APPRENANTS********************************************************
	public void AjouterApprenant(Apprenants apprenant)
	{
		ConnexionBDD();
		
		try {
			PreparedStatement prepare = connexion.prepareStatement("INSERT INTO apprenants(nom, prenom, email, passe) VALUES(?, ?, ?, ?);");
			
			prepare.setString(1, apprenant.getNom());  	prepare.setString(2, apprenant.getPrenom());
			prepare.setString(3, apprenant.getEmail());  prepare.setString(4, apprenant.getPasse());
		
			
			prepare.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//	*******************************SUPPRIMER Formateurs********************************************************
	public void SupprimerApprenant(Apprenants apprenants)
	{
		ConnexionBDD();
		
		try 
		{
			PreparedStatement prepareSupp = connexion.prepareStatement("DELETE FROM apprenants WHERE id = ?");
			prepareSupp.setInt(1, apprenants.getId());		
			System.out.println("---------- Id Formateurs -------"+apprenants.getId());
			prepareSupp.executeUpdate();
			System.out.println("Supprimer avec succses dans formateurs");
		} catch (SQLException e) 
		{
			System.out.println("Suppression echoue dans formateurs");
			e.printStackTrace();
		}
		
	}
	
//	*******************************AFFICHER Formateurs********************************************************
//	@SuppressWarnings("null")
	public List<Apprenants> AfficherApprenants(){
		
			List<Apprenants> Apprenants = new ArrayList<Apprenants>();
			ConnexionBDD();
			Statement statement = null;  
			ResultSet resultat = null;
			
			try {
				statement = connexion.createStatement();
				
				resultat = statement.executeQuery("SELECT * FROM apprenants");
				
				
				while(resultat.next())
				{
					int id = Integer.parseInt(resultat.getString("id"));
					String nom = resultat.getNString("nom");
					String prenom = resultat.getNString("prenom");
					String email = resultat.getNString("email");
					String passe = resultat.getNString("passe");
					
					Apprenants apprenant = new Apprenants();
					
					apprenant.setId(id);
					apprenant.setNom(nom);   		apprenant.setPrenom(prenom);
					apprenant.setEmail(email);			apprenant.setPasse(passe);
					Apprenants.add(apprenant);
					
				}
				
				
				
			} 
			catch (SQLException e) {}
			finally {
				try {
					if(resultat != null) resultat.close();
					if(statement != null) statement.close();
					if(connexion != null) connexion.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			return Apprenants;
			
		
	}
	
	
	
	
	
	



}
