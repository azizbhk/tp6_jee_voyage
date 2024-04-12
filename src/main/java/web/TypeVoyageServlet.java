package web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;

import daoo.typevoyageDaoImpl;
import daoo.ItypevoyageDao;
import metier.entities.typevoyage;

@WebServlet(name = "colServ", urlPatterns = { "/Typevoyages", "/saisietypevoyage", "/savetypevoyage", "/supprimercol",
		"/editercol", "/updatecol" })
public class TypeVoyageServlet extends HttpServlet {
	ItypevoyageDao societe;

	@Override
	public void init() throws ServletException {
		societe = new TypevoyageDaoImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		System.out.println("PATH " + path);
		if (path.equals("/Typevoyages")) {
			List<typevoyage> col = societe.getAllTypeVoyage();
			TypeVoyageModel model = new TypeVoyageModel();

			model.settypevoyages(col);
			request.setAttribute("model", model);
			request.getRequestDispatcher("Typevoyages.jsp").forward(request, response);
			
		} else if (path.equals("/saisietypevoyage")) {
			System.out.println("*************************************************************************************************************");

			request.getRequestDispatcher("saisietypevoyage.jsp").forward(request, response);
			
		} else if (path.equals("/savetypevoyage") && request.getMethod().equals("POST")) {
			System.out.println("************eeee*************************************************************************************************");

			Date datecol = new Date();
			String nom = request.getParameter("nom");
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			try {
				datecol = simpleDateFormat.parse(request.getParameter("datecol"));
			} catch (ParseException e) {
				e.printStackTrace();
			}

			typevoyage col = societe.save(new typevoyage(nom, datecol));
			request.setAttribute("Typevoyage", col);
			response.sendRedirect("Typevoyages");
			
			
		} else if (path.equals("/supprimercol")) {
			Long id = Long.parseLong(request.getParameter("id"));
			societe.deletetypevoyage(id);
			response.sendRedirect("Typevoyages");
			
			
		} else if (path.equals("/editercol")) {
			Long id = Long.parseLong(request.getParameter("id"));
			typevoyage col = societe.gettypevoyage(id); 
			request.setAttribute("Typevoyage", col);
			request.getRequestDispatcher("editertypevoyage.jsp").forward(request, response);
			
			
		} else if (path.equals("/updatecol")) {
			Date datecol = new Date();
			Long id = Long.parseLong(request.getParameter("id"));
			String nomcol = request.getParameter("nomcol");
			typevoyage col = new typevoyage();
			col.setIdcol(id);
			col.setNomcol(nomcol);
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			try {
				datecol = simpleDateFormat.parse(request.getParameter("dateAffection"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			col.setDateAffection(datecol);
			societe.updatetypevoyage(col);
			response.sendRedirect("Typevoyages");
			
		} else {
			response.sendError(Response.SC_NOT_FOUND);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,

			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
