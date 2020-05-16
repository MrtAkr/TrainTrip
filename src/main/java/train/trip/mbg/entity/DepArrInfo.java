package train.trip.mbg.entity;

import java.sql.Time;

public class DepArrInfo {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dep_arr_info.id
	 * @mbg.generated
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dep_arr_info.schedule_id
	 * @mbg.generated
	 */
	private Integer scheduleId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dep_arr_info.dep_arr_time
	 * @mbg.generated
	 */
	private Time depArrTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dep_arr_info.station_name
	 * @mbg.generated
	 */
	private String stationName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column dep_arr_info.dep_arr
	 * @mbg.generated
	 */
	private String depArr;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dep_arr_info.id
	 * @return  the value of dep_arr_info.id
	 * @mbg.generated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dep_arr_info.id
	 * @param id  the value for dep_arr_info.id
	 * @mbg.generated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dep_arr_info.schedule_id
	 * @return  the value of dep_arr_info.schedule_id
	 * @mbg.generated
	 */
	public Integer getScheduleId() {
		return scheduleId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dep_arr_info.schedule_id
	 * @param scheduleId  the value for dep_arr_info.schedule_id
	 * @mbg.generated
	 */
	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dep_arr_info.dep_arr_time
	 * @return  the value of dep_arr_info.dep_arr_time
	 * @mbg.generated
	 */
	public Time getDepArrTime() {
		return depArrTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dep_arr_info.dep_arr_time
	 * @param depArrTime  the value for dep_arr_info.dep_arr_time
	 * @mbg.generated
	 */
	public void setDepArrTime(Time depArrTime) {
		this.depArrTime = depArrTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dep_arr_info.station_name
	 * @return  the value of dep_arr_info.station_name
	 * @mbg.generated
	 */
	public String getStationName() {
		return stationName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dep_arr_info.station_name
	 * @param stationName  the value for dep_arr_info.station_name
	 * @mbg.generated
	 */
	public void setStationName(String stationName) {
		this.stationName = stationName == null ? null : stationName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column dep_arr_info.dep_arr
	 * @return  the value of dep_arr_info.dep_arr
	 * @mbg.generated
	 */
	public String getDepArr() {
		return depArr;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column dep_arr_info.dep_arr
	 * @param depArr  the value for dep_arr_info.dep_arr
	 * @mbg.generated
	 */
	public void setDepArr(String depArr) {
		this.depArr = depArr == null ? null : depArr.trim();
	}
}