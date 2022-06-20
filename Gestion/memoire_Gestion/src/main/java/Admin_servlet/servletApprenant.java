package Admin_servlet;

import java.io.IOException;

import DAO.ApprenantsDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metiers.Apprenants;

/**
 * Servlet implementation class servlet_apprenant
 */
public class servletApprenant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletApprenant() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ApprenantsDAO ApprenantsDAO = new ApprenantsDAO();
		Apprenants apprenantS = new Apprenants();	
		
		String ID = request.getParameter("delete");
		if(ID != null)
		{		
		int id = Integer.parseInt(ID);
		request.setAttribute("ID", ID);
		apprenantS.getId();
		ApprenantsDAO.SupprimerApprenant(apprenantS);	
		request.setAttribute("Etudiants", ApprenantsDAO.AfficherApprenants());
		request.getRequestDispatcher("WEB-INF/admin/apprenants.jsp").forward(request, response);
		}
				
		request.setAttribute("formateurs",ApprenantsDAO.AfficherApprenants());
		request.getRequestDispatcher("WEB-INF/admin/apprenants.jsp").forward(request, response);
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
