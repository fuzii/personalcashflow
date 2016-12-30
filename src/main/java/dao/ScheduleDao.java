package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.Establishment;
import model.Schedule;

public class ScheduleDao {

	public static Schedule Insert(Schedule schedule) {	
		
		try { 
			
			// schedule
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO establishment_schedule (establishment_id,day_week,start_time,end_time) values (?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1,schedule.getEstablishment().getId());
			stmt.setString(2,schedule.getDayWeek());
			stmt.setString(3,schedule.getStartTime());
			stmt.setString(4,schedule.getEndTime());
			stmt.execute();

			// get generated schedule id
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next())
				schedule.setId(rs.getLong(1));

			rs.close();
			stmt.close();
			connection.close();
			
			return schedule;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public static List<Schedule> GetSchedules(Establishment establishment) {
	     
		try {
			
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("select * from establishment_schedule where establishment_id=?");
			stmt.setLong(1,establishment.getId());
			ResultSet rs = stmt.executeQuery();

			List<Schedule> schedules = new ArrayList<Schedule>();

			while(rs.next()){
				
				Schedule schedule = new Schedule();
				schedule.setId(rs.getLong("id"));
				schedule.setEstablishment(establishment);
				schedule.setDayWeek(rs.getString("day_week"));
				schedule.setStartTime(rs.getString("start_time"));
				schedule.setEndTime(rs.getString("end_time"));
				
				// created on
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("created"));
				establishment.setCreated(data);
				schedules.add(schedule);
				
			}
			
			rs.close();
			stmt.close();
			connection.close();
			return schedules;
	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
