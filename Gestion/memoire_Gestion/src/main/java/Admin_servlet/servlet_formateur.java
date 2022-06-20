package Admin_servlet;

import java.io.IOException;

import DAO.FormateursDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metiers.Formateurs;

/**
 * Servlet implementation class servlet_formateur
 */
public class servlet_formateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet_formateur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FormateursDAO FormateurDAO = new FormateursDAO();
		Formateurs formateurS = new Formateurs();	
		
		String ID = request.getParameter("delete");
		if(ID != null)
		{		
		int id = Integer.parseInt(ID);
		request.setAttribute("ID", ID);
		formateurS.getId();
		FormateurDAO.SupprimerFormateur(formateurS);	
		request.setAttribute("Etudiants", FormateurDAO.AfficherEtudiants());
		request.getRequestDispatcher("WEB-INF/admin/formateurs.jsp").forward(request, response);
		}
				
		request.setAttribute("formateurs",FormateurDAO.AfficherEtudiants());
		request.getRequestDispatcher("WEB-INF/admin/formateurs.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FormateursDAO FormateurDAO = new FormateursDAO();
		Formateurs formateur = new Formateurs();	
//		
//		String ID = request.getParameter("delete");
//		if(ID != null)
//		{		
//		int id = Integer.parseInt(ID);
//		request.setAttribute("ID", ID);
//		formateur.getId();
//		FormateurDAO.SupprimerFormateur(formateur);	
//		request.setAttribute("Etudiants", FormateurDAO.AfficherEtudiants());
//		request.getRequestDispatcher("WEB-INF/admin/formateurs.jsp").forward(request, response);
//		}
		
		
		String nom = request.getParameter("nom_m");	
		String prenom = request.getParameter("prenom_m");	
		String email = request.getParameter("email_m");	
		String matiere = request.getParameter("matiere");	
		String passe = request.getParameter("passe");	
		String erreur = "";
		String succes = "";
		
		if (request.getParameter("nom_m")   != " "  && request.getParameter("prenom_m") != "" && 
			request.getParameter("email_m") != " "  && request.getParameter("passe") != "" &&
			request.getParameter("matiere") != ""
		   ) 
		{
			formateur.setNom(request.getParameter("nom_m"));  formateur.setPrenom(request.getParameter("prenom_m"));
			formateur.setEmail(request.getParameter("email_m")); formateur.setPasse(request.getParameter("passe"));
			formateur.setMatiere(request.getParameter("matiere"));
			FormateurDAO.AjouterEtudiant(formateur);
			request.setAttribute("formateur", FormateurDAO);
			
			succes = " Insertions reussi avec succes !";
			request.setAttribute("erreur", succes);
			request.setAttribute("formateurs",FormateurDAO.AfficherEtudiants());
			request.getRequestDispatcher("WEB-INF/admin/formateurs.jsp").forward(request, response);	
		}
		else
		{	
			erreur = " Veuillez Remplir tous les champs !";
			request.setAttribute("erreur", erreur);
			request.setAttribute("formateurs",FormateurDAO.AfficherEtudiants());
			request.getRequestDispatcher("WEB-INF/admin/formateurs.jsp").forward(request, response);	
		}
	
		
	}

}
