package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.EstablishmentDao;
import dao.ScheduleDao;
import formatter.GenerateJSON;
import formatter.GenerateObject;
import model.Establishment;

@WebServlet("/addSchedule")
public class AddScheduleServlet extends HttpServlet{ 
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		try{
			
			Establishment establishment = EstablishmentDao.GetEstablishmentsById(Long.parseLong(request.getParameter("establishment_id")));			
			ScheduleDao.Insert(GenerateObject.GetSchedule(establishment, request.getParameter("week_start_time"), request.getParameter("week_end_time"), "Segunda"));
			ScheduleDao.Insert(GenerateObject.GetSchedule(establishment, request.getParameter("week_start_time"), request.getParameter("week_end_time"), "Terça"));
			ScheduleDao.Insert(GenerateObject.GetSchedule(establishment, request.getParameter("week_start_time"), request.getParameter("week_end_time"), "Quarta"));
			ScheduleDao.Insert(GenerateObject.GetSchedule(establishment, request.getParameter("week_start_time"), request.getParameter("week_end_time"), "Quinta"));
			ScheduleDao.Insert(GenerateObject.GetSchedule(establishment, request.getParameter("week_start_time"), request.getParameter("week_end_time"), "Sexta"));
			ScheduleDao.Insert(GenerateObject.GetSchedule(establishment, request.getParameter("saturday_start_time"), request.getParameter("saturday_end_time"), "Sábado"));
			ScheduleDao.Insert(GenerateObject.GetSchedule(establishment, request.getParameter("sunday_start_time"), request.getParameter("sunday_end_time"), "Domingo"));			
				
			
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
			out.print(jsonMain.put("schedule",GenerateJSON.GetListScheduleJSON(ScheduleDao.GetSchedules(establishment))));
	
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
		}
		
	}
}
