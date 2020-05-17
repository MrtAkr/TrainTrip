package train.trip.dto;

import java.time.LocalTime;

public class ScheduleListDto {
	private Integer trainTripId;
	private Integer scheduleId;
	private Integer depArrInfoId;
	private Integer dayNumber;
	private String depArr;
	private LocalTime depArrTime;
	private String stationName;
	private String trainName;
	private String action;

//	public LocalTime getZonedDepArrTime() {
//		return depArrTime.plusHours(9);
//	}

	public Integer getTrainTripId() {
		return trainTripId;
	}

	public void setTrainTripId(Integer trainTripId) {
		this.trainTripId = trainTripId;
	}

	public Integer getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Integer getDepArrInfoId() {
		return depArrInfoId;
	}

	public void setDepArrInfoId(Integer depArrInfoId) {
		this.depArrInfoId = depArrInfoId;
	}

	public Integer getDayNumber() {
		return dayNumber;
	}

	public void setDayNumber(Integer dayNumber) {
		this.dayNumber = dayNumber;
	}

	public String getDepArr() {
		return depArr;
	}

	public void setDepArr(String depArr) {
		this.depArr = depArr;
	}

	public LocalTime getDepArrTime() {
		return depArrTime;
	}

	public void setDepArrTime(LocalTime depArrTime) {
		this.depArrTime = depArrTime;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
}
