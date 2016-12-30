package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.LeadDao;
import formatter.GenerateObject;
import model.Address;
import model.Lead;

@WebServlet("/addLead")
public class AddLeadServlet extends HttpServlet{

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {

			Address address = GenerateObject.GetAddress(request);
			Lead lead = GenerateObject.GetLead(request);
			lead.setAddress(address);
			lead = LeadDao.Insert(lead);

			// response
			response.addHeader("Access-Control-Allow-Origin","*");
			response.addHeader("Access-Control-Allow-Methods","POST, GET, OPTIONS, DELETE");
			response.addHeader("Access-Control-Max-Age","3600");
			response.addHeader("Access-Control-Allow-Headers","x-requested-with");
			response.setStatus(HttpServletResponse.SC_OK);

		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.toString());
		}
		
	}
}
