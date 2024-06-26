package web;

import java.io.IOException;


import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;

import daoo.voyageDaolmpl;
import daoo.typevoyageDaoImpl;
import daoo.IvoyageDAO;
import daoo.ItypevoyageDao;
import daoo.IvoyageDAO;
import metier.entities.typevoyage;
import metier.entities.voyage;
import metier.entities.typevoyage;
@WebServlet (name="cs",urlPatterns= {"/controleur","*.do"})
public class ControleurServlet extends HttpServlet {
IvoyageDAO metier;
ItypevoyageDao metierCol ; 
@Override
public void init() throws ServletException {
	System.out.println("*************************************************************************************************************");

metier = new voyageDaolmpl();
metierCol = new typevoyageDaoImpl() ; 
}
@Override
protected void doGet(HttpServletRequest request,
		 HttpServletResponse response)
		 throws ServletException, IOException {  
		String path=request.getServletPath();
		 if (metier == null) {
		        // Initialize metier if it's null
		        metier = new voyageDaolmpl();
		    }

		if (path.equals("/index.do"))
		{

		request.getRequestDispatcher("voyage.jsp").forward(request,response);
		}
		else if (path.equals("/chercher.do"))
		{
			String motCle=request.getParameter("motCle");
			VoyageModele model= new VoyageModele();
			model.setMotCle(motCle);
			List<voyage> prods = metier.voyageParMC(motCle);
			model.setvoyage(prods);
			request.setAttribute("model", model);
			request.getRequestDispatcher("voyage.jsp").forward(request,response);
		}
		else if (path.equals("/create.do") )
		{
			System.out.println("*************************************************************************************************************");

			List<typevoyage> col = metierCol.getAlltypevoyage();
			System.out.println(col);
			TypeVoyageModel model= new TypeVoyageModel();
			model.settypevoyages(col);
			request.setAttribute("colModel", model);
			request.getRequestDispatcher("saisievoyage.jsp").forward(request,response);		}
		
		
		
		
		
		
		
		else if (path.equals("/save.do") &&
		request.getMethod().equals("POST"))
		{
		 String NOM_voyage=request.getParameter("NOM_voyage");
		int Nb_employee = Integer.parseInt(request.getParameter("Nb_employee"));
		Long idCol=Long.parseLong(request.getParameter("typevoyage"));

		typevoyage col = metierCol.gettypevoyage(idCol);

		voyage p = metier.save(new voyage(NOM_voyage,Nb_employee , col));
		request.setAttribute("voyage", p);
		request.getRequestDispatcher("confirmation.jsp").forward(request,response);
		}
		
		
		else if (path.equals("/supprimer.do"))
		{
		 Long id= Long.parseLong(request.getParameter("id"));
		 metier.deletevoyage(id);
		 response.sendRedirect("chercher.do?motCle=");
		}
		else if (path.equals("/editer.do") )
		{
			
		Long id= Long.parseLong(request.getParameter("id"));
		 voyage p = metier.getvoyage(id);
		 request.setAttribute("voyage", p);
		 
		 List<typevoyage> col = metierCol.getAlltypevoyage();
		 TypeVoyageModel model= new TypeVoyageModel();
		 model.settypevoyages(col);
		 request.setAttribute("colModel", model);
		request.getRequestDispatcher("editervoyage.jsp").forward(request,response);		}
		else if (path.equals("/update.do") )
		{
		Long id = Long.parseLong(request.getParameter("id"));
		String NOM_voyage=request.getParameter("NOM_voyage");
		int Nb_employee =Integer.parseInt(request.getParameter("Nb_employee"));
		Long typevoyageId=Long.parseLong(request.getParameter("typevoyage"));

		voyage p = new voyage();
		p.setID_voyage(id);
		p.setNOM_voyage(NOM_voyage);
		p.setNb_employee(Nb_employee); 
		typevoyage col = metierCol.gettypevoyage(typevoyageId);
		p.settypevoyage(col);
		metier.updatevoyage(p);
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
