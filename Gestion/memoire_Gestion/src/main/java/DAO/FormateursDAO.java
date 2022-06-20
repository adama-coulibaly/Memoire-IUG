package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;


import com.mysql.cj.protocol.Resultset;

import metiers.Formateurs;

public class FormateursDAO {
		
		private Connection connexion;
//		*******************************CONNECTION A LA BDD********************************************************
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
		
//		*******************************AJOUTER Formateur********************************************************
		public void AjouterEtudiant(Formateurs etudiant)
		{
			ConnexionBDD();
			
			try {
				PreparedStatement prepare = connexion.prepareStatement("INSERT INTO formateurs(nom, prenom, email, passe, matiere) VALUES(?, ?, ?, ?, ?);");
				
				prepare.setString(1, etudiant.getNom());  	prepare.setString(2, etudiant.getPrenom());
				prepare.setString(3, etudiant.getEmail());  prepare.setString(4, etudiant.getPasse());
				 prepare.setString(5, etudiant.getMatiere());
				
				prepare.executeUpdate();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
//		*******************************SUPPRIMER Formateurs********************************************************
		public void SupprimerFormateur(Formateurs formateurs)
		{
			ConnexionBDD();
			
			try 
			{
				PreparedStatement prepareSupp = connexion.prepareStatement("DELETE FROM formateurs WHERE id = ?");
				prepareSupp.setInt(1, formateurs.getId());		
				System.out.println("---------- Id Formateurs -------"+formateurs.getId());
				prepareSupp.executeUpdate();
				System.out.println("Supprimer avec succses dans formateurs");
			} catch (SQLException e) 
			{
				System.out.println("Suppression echoue dans formateurs");
				e.printStackTrace();
			}
			
		}
		
//		*******************************AFFICHER Formateurs********************************************************
//		@SuppressWarnings("null")
		public List<Formateurs> AfficherEtudiants(){
			
				List<Formateurs> Formateurs = new ArrayList<Formateurs>();
				ConnexionBDD();
				Statement statement = null;  
				ResultSet resultat = null;
				
				try {
					statement = connexion.createStatement();
					
					resultat = statement.executeQuery("SELECT * FROM formateurs");
					
					
					while(resultat.next())
					{
						int id = Integer.parseInt(resultat.getString("id"));
						String nom = resultat.getNString("nom");
						String prenom = resultat.getNString("prenom");
						String email = resultat.getNString("email");
						String passe = resultat.getNString("passe");
						
						Formateurs formateur = new Formateurs();
						
						formateur.setId(id);
						formateur.setNom(nom);   		formateur.setPrenom(prenom);
						formateur.setEmail(email);			formateur.setPasse(passe);
						Formateurs.add(formateur);
						
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
				return Formateurs;
				
			
		}
		
		
		
		
		
		
	
	

}
