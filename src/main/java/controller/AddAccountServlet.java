package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import dao.AccountDao;
import formatter.GenerateJSON;
import formatter.GenerateObject;
import model.Account;
import util.SendGridEmail;

@WebServlet("/addAccount")
public class AddAccountServlet extends HttpServlet{ 
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		try{
			
			Account account = GenerateObject.GetAccount(request);
			account = AccountDao.Insert(account);
	
			
			// send confirmation mail
			if(System.getenv("SENDGRID_ACTIVE")=="On"){
				String from = System.getenv("SENDGRID_FROM");
				String subject = "[Saudosa Padoca] - Confirmacao de cadastro";
				String content = "Obrigado por se cadastrar no...";
				String to = account.getEmail();
				SendGridEmail.Send(from, to, subject, content);
			}
	
			
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
			out.print(jsonMain.put("account",GenerateJSON.GetAccountJSON(account)));
	
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.toString());
		}
		
	}
}
