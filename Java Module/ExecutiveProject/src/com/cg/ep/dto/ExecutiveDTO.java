package com.cg.ep.dto;

public class ExecutiveDTO
{
private String flight_no;
private String airline;
private String dep_city;
private String arr_city;
private String dep_day;
private String arr_day;
private String dep_time;
private String arr_time;
private int first_seats;
private int first_seat_fare;
private int buss_seats;
private int buss_seat_fare;


public ExecutiveDTO() 
{
	super();
	
}


public ExecutiveDTO(String flight_no, String airline, String dep_city,
		String arr_city, String dep_day, String arr_day, String dep_time,
		String arr_time, int first_seats, int first_seat_fare,
		int buss_seats, int buss_seat_fare) 
{
	super();
	this.flight_no = flight_no;
	this.airline = airline;
	this.dep_city = dep_city;
	this.arr_city = arr_city;
	this.dep_day = dep_day;
	this.arr_day = arr_day;
	this.dep_time = dep_time;
	this.arr_time = arr_time;
	this.first_seats = first_seats;
	this.first_seat_fare = first_seat_fare;
	this.buss_seats = buss_seats;
	this.buss_seat_fare = buss_seat_fare;
}


public String getFlight_no() {
	return flight_no;
}


public void setFlight_no(String flight_no) {
	this.flight_no = flight_no;
}


public String getAirline() {
	return airline;
}


public void setAirline(String airline) {
	this.airline = airline;
}


public String getDep_city() {
	return dep_city;
}


public void setDep_city(String dep_city) {
	this.dep_city = dep_city;
}


public String getArr_city() {
	return arr_city;
}


public void setArr_city(String arr_city) {
	this.arr_city = arr_city;
}


public String getDep_day() {
	return dep_day;
}


public void setDep_day(String dep_day) {
	this.dep_day = dep_day;
}


public String getArr_day() {
	return arr_day;
}


public void setArr_day(String arr_day) {
	this.arr_day = arr_day;
}


public String getDep_time() {
	return dep_time;
}


public void setDep_time(String dep_time) {
	this.dep_time = dep_time;
}


public String getArr_time() {
	return arr_time;
}


public void setArr_time(String arr_time) {
	this.arr_time = arr_time;
}


public int getFirst_seats() {
	return first_seats;
}


public void setFirst_seats(int first_seats) {
	this.first_seats = first_seats;
}


public int getFirst_seat_fare() {
	return first_seat_fare;
}


public void setFirst_seat_fare(int first_seat_fare) {
	this.first_seat_fare = first_seat_fare;
}


public int getBuss_seats() {
	return buss_seats;
}


public void setBuss_seats(int buss_seats) {
	this.buss_seats = buss_seats;
}


public int getBuss_seat_fare() {
	return buss_seat_fare;
}


public void setBuss_seat_fare(int buss_seat_fare) {
	this.buss_seat_fare = buss_seat_fare;
}


/*@Override
public String toString() {
	return "ExecutiveDTO [flight_no=" + flight_no + ", airline=" + airline
			+ ", dep_city=" + dep_city + ", arr_city=" + arr_city
			+ ", dep_day=" + dep_day + ", arr_day=" + arr_day + ", dep_time="
			+ dep_time + ", arr_time=" + arr_time + ", first_seats="
			+ first_seats + ", first_seat_fare=" + first_seat_fare
			+ ", buss_seats=" + buss_seats + ", buss_seat_fare="
			+ buss_seat_fare + "]";
}
*/
@Override
public String toString() {
	return "ExecutiveDTO [first_seats="+ first_seats + ",buss_seats=" + buss_seats + " ]";


}
}
