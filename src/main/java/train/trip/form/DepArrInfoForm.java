package train.trip.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class DepArrInfoForm {
	
	private Integer id;
	
	private Integer trainTripId;
	
	@NotNull
	@Range(min=1, max=31)
	private Integer dayNumber;

	@NotBlank
	@Size(min=1, max=60)
	private String trainName;

	@NotNull
	@Range(min=0, max=23)
	public Integer depTime;

	@NotNull
	@Range(min=0, max=59)
	public Integer depMinute;

	@NotBlank
	@Size(min=1, max=30)
	private String depStationName;

	@NotNull
	@Range(min=0, max=23)
	public Integer arrTime;

	@NotNull
	@Range(min=0, max=59)
	public Integer arrMinute;

	@NotBlank
	@Size(min=1, max=30)
	private String arrStationName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTrainTripId() {
		return trainTripId;
	}

	public void setTrainTripId(Integer trainTripId) {
		this.trainTripId = trainTripId;
	}

	public  Integer getDayNumber() {
		return dayNumber;
	}

	public void setDayNumber( Integer dayNumber) {
		this.dayNumber = dayNumber;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public Integer getDepTime() {
		return depTime;
	}

	public void setDepTime(Integer depTime) {
		this.depTime = depTime;
	}

	public Integer getDepMinute() {
		return depMinute;
	}

	public void setDepMinute(Integer depMinute) {
		this.depMinute = depMinute;
	}

	public String getDepStationName() {
		return depStationName;
	}

	public void setDepStationName(String depStationName) {
		this.depStationName = depStationName;
	}

	public Integer getArrTime() {
		return arrTime;
	}

	public void setArrTime(Integer arrTime) {
		this.arrTime = arrTime;
	}

	public Integer getArrMinute() {
		return arrMinute;
	}

	public void setArrMinute(Integer arrMinute) {
		this.arrMinute = arrMinute;
	}

	public String getArrStationName() {
		return arrStationName;
	}

	public void setArrStationName(String arrStationName) {
		this.arrStationName = arrStationName;
	}
}

