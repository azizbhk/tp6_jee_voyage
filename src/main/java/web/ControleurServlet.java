package web;

import java.io.IOException;


import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;

import daoo.DepartementDaolmpl;
import daoo.typevoyageDaoImpl;
import daoo.IDepartementDAO;
import daoo.ItypevoyageDao;
import daoo.IDepartementDAO;
import metier.entities.typevoyage;
import metier.entities.Departement;
import metier.entities.typevoyage;
@WebServlet (name="cs",urlPatterns= {"/controleur","*.do"})
public class ControleurServlet extends HttpServlet {
IDepartementDAO metier;
ItypevoyageDao metierCol ; 
@Override
public void init() throws ServletException {
	System.out.println("*************************************************************************************************************");

metier = new DepartementDaolmpl();
metierCol = new typevoyageDaoImpl() ; 
}
@Override
protected void doGet(HttpServletRequest request,
		 HttpServletResponse response)
		 throws ServletException, IOException {  
		String path=request.getServletPath();
		 if (metier == null) {
		        // Initialize metier if it's null
		        metier = new DepartementDaolmpl();
		    }

		if (path.equals("/index.do"))
		{

		request.getRequestDispatcher("departement.jsp").forward(request,response);
		}
		else if (path.equals("/chercher.do"))
		{
			String motCle=request.getParameter("motCle");
			VoyageModele model= new VoyageModele();
			model.setMotCle(motCle);
			List<Departement> prods = metier.DepartementParMC(motCle);
			model.setDepartement(prods);
			request.setAttribute("model", model);
			request.getRequestDispatcher("departement.jsp").forward(request,response);
		}
		else if (path.equals("/create.do") )
		{
			System.out.println("*************************************************************************************************************");

			List<typevoyage> col = metierCol.getAlltypevoyage();
			System.out.println(col);
			TypeVoyageModel model= new TypeVoyageModel();
			model.settypevoyages(col);
			request.setAttribute("colModel", model);
			request.getRequestDispatcher("saisieDepartement.jsp").forward(request,response);		}
		
		
		
		
		
		
		
		else if (path.equals("/save.do") &&
		request.getMethod().equals("POST"))
		{
		 String NOM_departement=request.getParameter("NOM_departement");
		int Nb_employee = Integer.parseInt(request.getParameter("Nb_employee"));
		Long idCol=Long.parseLong(request.getParameter("typevoyage"));

		typevoyage col = metierCol.gettypevoyage(idCol);

		Departement p = metier.save(new Departement(NOM_departement,Nb_employee , col));
		request.setAttribute("departement", p);
		request.getRequestDispatcher("confirmation.jsp").forward(request,response);
		}
		
		
		else if (path.equals("/supprimer.do"))
		{
		 Long id= Long.parseLong(request.getParameter("id"));
		 metier.deleteDepartement(id);
		 response.sendRedirect("chercher.do?motCle=");
		}
		else if (path.equals("/editer.do") )
		{
			
		Long id= Long.parseLong(request.getParameter("id"));
		 Departement p = metier.getDepartement(id);
		 request.setAttribute("departement", p);
		 
		 List<typevoyage> col = metierCol.getAlltypevoyage();
		 TypeVoyageModel model= new TypeVoyageModel();
		 model.settypevoyages(col);
		 request.setAttribute("colModel", model);
		request.getRequestDispatcher("editerDepartement.jsp").forward(request,response);		}
		else if (path.equals("/update.do") )
		{
		Long id = Long.parseLong(request.getParameter("id"));
		String NOM_departement=request.getParameter("NOM_departement");
		int Nb_employee =Integer.parseInt(request.getParameter("Nb_employee"));
		Long typevoyageId=Long.parseLong(request.getParameter("typevoyage"));

		Departement p = new Departement();
		p.setID_departement(id);
		p.setNOM_departement(NOM_departement);
		p.setNb_employee(Nb_employee); 
		typevoyage col = metierCol.gettypevoyage(typevoyageId);
		p.settypevoyage(col);
		metier.updateDepartement(p);
		response.sendRedirect("chercher.do?motCle=");

		}
		else
		{
			response.sendError(Response.SC_NOT_FOUND);		
		}	
		}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
