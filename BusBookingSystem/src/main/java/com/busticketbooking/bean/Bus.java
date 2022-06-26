package com.busticketbooking.bean;

public class Bus {

	private int busId;
	private int busNumber;
	private String busName;
	private String busSource;
	private String busDestination;
	private int totalSeats;
	private int availableSeats;
	private int price;
	private String date;
	private String time;
	private int status;

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public int getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(int busNumber) {
		this.busNumber = busNumber;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getBusSource() {
		return busSource;
	}

	public void setBusSource(String busSource) {
		this.busSource = busSource;
	}

	public String getBusDestination() {
		return busDestination;
	}

	public void setBusDestination(String busDestination) {
		this.busDestination = busDestination;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", busNumber=" + busNumber + ", busName=" + busName + ", busSource=" + busSource
				+ ", busDestination=" + busDestination + ", totalSeats=" + totalSeats + ", availableSeats="
				+ availableSeats + ", price=" + price + ", date=" + date + ", time=" + time + ", status=" + status
				+ "]";
	}
}