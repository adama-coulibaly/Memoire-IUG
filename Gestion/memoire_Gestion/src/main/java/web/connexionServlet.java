package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import metiers.Formateurs;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.FormateursDAO;

/**
 * Servlet implementation class connexionServlet
 */
public class connexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public connexionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String  email = request.getParameter("email");	
		String passe = request.getParameter("passe");
		HttpSession session1 = request.getSession();
		String Type = (String) request.getSession().getAttribute("typeCompte");
		if (session1 != null) 
		{
			
			
			if(Type.equals("apprenants"))
			{
				request.getRequestDispatcher("WEB-INF/apprenants/app_index.jsp").forward(request, response);
			}
			else if(Type.equals("formateurs")) 
			{
				request.getRequestDispatcher("WEB-INF/formateurs/format_index.jsp").forward(request, response);
			}
			else if(Type.equals("administrateur"))
			{
				this.getServletContext().getRequestDispatcher("/WEB-INF/admin/admin_index.jsp").forward(request, response);	
			}
			
			
		
		}
		else
		{
			String email1 = request.getParameter("email");
		String passe1 = request.getParameter("passe");
		request.setAttribute("email", " ");
		request.setAttribute("passe", " ");
	
		request.getRequestDispatcher("login.jsp").forward(request, response);
	
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FormateursDAO Etudiant = new FormateursDAO();
		Formateurs etudintA = new Formateurs();
		
		String  email = request.getParameter("email");	
		String passe = request.getParameter("passe");
		String typeCompte = request.getParameter("typeCompte");
		String erreurs;
		request.setAttribute("Etudiant", Etudiant.AfficherEtudiants());
		
			try {
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/memoire", "root", "adama");
				Statement State = con.createStatement();
				
				if(typeCompte != null)
				{
					ResultSet resultat = State.executeQuery("SELECT * FROM "+typeCompte+" WHERE email ='"+email+"' and passe ='"+passe+"'");
					if(resultat.next())
					{

						if(typeCompte.equals("apprenants"))
						{
							HttpSession session = request.getSession();
							session.setAttribute("email", email);
							session.setAttribute("passe", passe);
							session.setAttribute("typeCompte", typeCompte);
							request.getRequestDispatcher("WEB-INF/apprenants/app_index.jsp").forward(request, response);
						}
						else if(typeCompte.equals("formateurs"))
						{
							HttpSession session = request.getSession();
							session.setAttribute("email", email);
							session.setAttribute("passe", passe);
							session.setAttribute("typeCompte", typeCompte);
							request.getRequestDispatcher("WEB-INF/formateurs/format_index.jsp").forward(request, response);
						}
						else if(typeCompte.equals("administrateur"))
						{
							HttpSession session = request.getSession();
							session.setAttribute("email", email);
							session.setAttribute("passe", passe);
							session.setAttribute("typeCompte", typeCompte);
							this.getServletContext().getRequestDispatcher("/WEB-INF/admin/admin_index.jsp").forward(request, response);
						}
						else
						{
							System.out.println("Compte introuvable "+typeCompte);
						}
						
							
						
						
						
						
					}
					else if(email != " " && passe == "")
						{
							erreurs = "Veuillez bien remplir les champs ! "+typeCompte;
							request.setAttribute("erreurs", erreurs);		
							request.getRequestDispatcher("login.jsp").forward(request, response);
						}
						else
						{
							erreurs = "Utilisateur non trouvé !";
							request.setAttribute("erreurs", erreurs);		
							request.getRequestDispatcher("login.jsp").forward(request, response);
						}
				}
				
				else
				{
					erreurs = "Veuillez bien remplir les champs ! "+typeCompte;
					request.setAttribute("erreurs", erreurs);
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	

}
