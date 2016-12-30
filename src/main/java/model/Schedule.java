package model;

public class Schedule {

	private Long id;
	private Establishment establishment;
	private String dayWeek;
	private String startTime;
	private String endTime;
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDayWeek() {
		return dayWeek;
	}
	public void setDayWeek(String dayWeek) {
		this.dayWeek = dayWeek;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Establishment getEstablishment() {
		return establishment;
	}
	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}
			
}
