package train.trip.form;

import java.sql.Time;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ActionForm {

	@NotNull
	private Integer trainTripId;

	@NotNull
	private Time arrTime;

	@NotNull
	private Integer dayNumber;

	@NotNull
	@Size(min=1, max=60, message="{0}は{min}文字以上 {max}文字以下で入力してください")
	private String action;

	public Integer getTrainTripId() {
		return trainTripId;
	}

	public void setTrainTripId(Integer trainTripId) {
		this.trainTripId = trainTripId;
	}

	public Time getArrTime() {
		return arrTime;
	}

	public void setArrTime(Time arrTime) {
		this.arrTime = arrTime;
	}

	public Integer getDayNumber() {
		return dayNumber;
	}

	public void setDayNumber(Integer dayNumber) {
		this.dayNumber = dayNumber;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}

