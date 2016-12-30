package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Address;
import util.Geolocation;

@WebServlet("/getEstablishments") 
public class GetEstablishmentsServlet extends HttpServlet{

	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// request
		Address address = new Address();
		address.setLatitude(Double.parseDouble(request.getParameter("latitude")));
		address.setLongitude(Double.parseDouble(request.getParameter("longitude")));
		
		// response
		PrintWriter out = response.getWriter();
		out.print(Geolocation.GetEstablishmentsJSON(address).toString());
		
	}
	
}
