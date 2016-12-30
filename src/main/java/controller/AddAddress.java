package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import dao.AddressDao;
import formatter.GenerateJSON;
import formatter.GenerateObject;
import model.Address;

@WebServlet("/addAddress")
public class AddAddress extends HttpServlet{ 
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		try{
			
			Address address = GenerateObject.GetAddress(request); 
			address = AddressDao.Insert(address);
						
			// response
			response.addHeader("Access-Control-Allow-Origin","*");
			response.addHeader("Access-Control-Allow-Methods","POST, GET, OPTIONS, DELETE");
			response.addHeader("Access-Control-Max-Age","3600");
			response.addHeader("Access-Control-Allow-Headers","x-requested-with");
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			response.setStatus(HttpServletResponse.SC_OK);
			
			JSONObject jsonMain = new JSONObject();
			PrintWriter out = response.getWriter();
			out.print(jsonMain.put("address",GenerateJSON.GetAddressJSON(address)));
	
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.toString());
		}
		
	}
}
