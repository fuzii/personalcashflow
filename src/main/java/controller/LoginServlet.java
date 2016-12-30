package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ResponsavelDao;
import model.Responsavel;

@WebServlet("/login") 
public class LoginServlet extends HttpServlet{

	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// request
		Responsavel responsavel = new Responsavel();
		responsavel.setNome(request.getParameter("login"));
		responsavel.setPassword(request.getParameter("password").toCharArray());
		
		// response
		PrintWriter out = response.getWriter();
		out.print(ResponsavelDao.Login(responsavel));
		
	}
	
}