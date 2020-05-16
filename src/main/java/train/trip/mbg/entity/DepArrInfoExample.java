package train.trip.mbg.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DepArrInfoExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table dep_arr_info
	 * @mbg.generated
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table dep_arr_info
	 * @mbg.generated
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table dep_arr_info
	 * @mbg.generated
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dep_arr_info
	 * @mbg.generated
	 */
	public DepArrInfoExample() {
		oredCriteria = new ArrayList<>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dep_arr_info
	 * @mbg.generated
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dep_arr_info
	 * @mbg.generated
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dep_arr_info
	 * @mbg.generated
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dep_arr_info
	 * @mbg.generated
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dep_arr_info
	 * @mbg.generated
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dep_arr_info
	 * @mbg.generated
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dep_arr_info
	 * @mbg.generated
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dep_arr_info
	 * @mbg.generated
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dep_arr_info
	 * @mbg.generated
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table dep_arr_info
	 * @mbg.generated
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table dep_arr_info
	 * @mbg.generated
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		protected void addCriterionForJDBCTime(String condition, Date value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Time(value.getTime()), property);
		}

		protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property + " cannot be null or empty");
			}
			List<java.sql.Time> timeList = new ArrayList<>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				timeList.add(new java.sql.Time(iter.next().getTime()));
			}
			addCriterion(condition, timeList, property);
		}

		protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andScheduleIdIsNull() {
			addCriterion("schedule_id is null");
			return (Criteria) this;
		}

		public Criteria andScheduleIdIsNotNull() {
			addCriterion("schedule_id is not null");
			return (Criteria) this;
		}

		public Criteria andScheduleIdEqualTo(Integer value) {
			addCriterion("schedule_id =", value, "scheduleId");
			return (Criteria) this;
		}

		public Criteria andScheduleIdNotEqualTo(Integer value) {
			addCriterion("schedule_id <>", value, "scheduleId");
			return (Criteria) this;
		}

		public Criteria andScheduleIdGreaterThan(Integer value) {
			addCriterion("schedule_id >", value, "scheduleId");
			return (Criteria) this;
		}

		public Criteria andScheduleIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("schedule_id >=", value, "scheduleId");
			return (Criteria) this;
		}

		public Criteria andScheduleIdLessThan(Integer value) {
			addCriterion("schedule_id <", value, "scheduleId");
			return (Criteria) this;
		}

		public Criteria andScheduleIdLessThanOrEqualTo(Integer value) {
			addCriterion("schedule_id <=", value, "scheduleId");
			return (Criteria) this;
		}

		public Criteria andScheduleIdIn(List<Integer> values) {
			addCriterion("schedule_id in", values, "scheduleId");
			return (Criteria) this;
		}

		public Criteria andScheduleIdNotIn(List<Integer> values) {
			addCriterion("schedule_id not in", values, "scheduleId");
			return (Criteria) this;
		}

		public Criteria andScheduleIdBetween(Integer value1, Integer value2) {
			addCriterion("schedule_id between", value1, value2, "scheduleId");
			return (Criteria) this;
		}

		public Criteria andScheduleIdNotBetween(Integer value1, Integer value2) {
			addCriterion("schedule_id not between", value1, value2, "scheduleId");
			return (Criteria) this;
		}

		public Criteria andDepArrTimeIsNull() {
			addCriterion("dep_arr_time is null");
			return (Criteria) this;
		}

		public Criteria andDepArrTimeIsNotNull() {
			addCriterion("dep_arr_time is not null");
			return (Criteria) this;
		}

		public Criteria andDepArrTimeEqualTo(Date value) {
			addCriterionForJDBCTime("dep_arr_time =", value, "depArrTime");
			return (Criteria) this;
		}

		public Criteria andDepArrTimeNotEqualTo(Date value) {
			addCriterionForJDBCTime("dep_arr_time <>", value, "depArrTime");
			return (Criteria) this;
		}

		public Criteria andDepArrTimeGreaterThan(Date value) {
			addCriterionForJDBCTime("dep_arr_time >", value, "depArrTime");
			return (Criteria) this;
		}

		public Criteria andDepArrTimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCTime("dep_arr_time >=", value, "depArrTime");
			return (Criteria) this;
		}

		public Criteria andDepArrTimeLessThan(Date value) {
			addCriterionForJDBCTime("dep_arr_time <", value, "depArrTime");
			return (Criteria) this;
		}

		public Criteria andDepArrTimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCTime("dep_arr_time <=", value, "depArrTime");
			return (Criteria) this;
		}

		public Criteria andDepArrTimeIn(List<Date> values) {
			addCriterionForJDBCTime("dep_arr_time in", values, "depArrTime");
			return (Criteria) this;
		}

		public Criteria andDepArrTimeNotIn(List<Date> values) {
			addCriterionForJDBCTime("dep_arr_time not in", values, "depArrTime");
			return (Criteria) this;
		}

		public Criteria andDepArrTimeBetween(Date value1, Date value2) {
			addCriterionForJDBCTime("dep_arr_time between", value1, value2, "depArrTime");
			return (Criteria) this;
		}

		public Criteria andDepArrTimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCTime("dep_arr_time not between", value1, value2, "depArrTime");
			return (Criteria) this;
		}

		public Criteria andStationNameIsNull() {
			addCriterion("station_name is null");
			return (Criteria) this;
		}

		public Criteria andStationNameIsNotNull() {
			addCriterion("station_name is not null");
			return (Criteria) this;
		}

		public Criteria andStationNameEqualTo(String value) {
			addCriterion("station_name =", value, "stationName");
			return (Criteria) this;
		}

		public Criteria andStationNameNotEqualTo(String value) {
			addCriterion("station_name <>", value, "stationName");
			return (Criteria) this;
		}

		public Criteria andStationNameGreaterThan(String value) {
			addCriterion("station_name >", value, "stationName");
			return (Criteria) this;
		}

		public Criteria andStationNameGreaterThanOrEqualTo(String value) {
			addCriterion("station_name >=", value, "stationName");
			return (Criteria) this;
		}

		public Criteria andStationNameLessThan(String value) {
			addCriterion("station_name <", value, "stationName");
			return (Criteria) this;
		}

		public Criteria andStationNameLessThanOrEqualTo(String value) {
			addCriterion("station_name <=", value, "stationName");
			return (Criteria) this;
		}

		public Criteria andStationNameLike(String value) {
			addCriterion("station_name like", value, "stationName");
			return (Criteria) this;
		}

		public Criteria andStationNameNotLike(String value) {
			addCriterion("station_name not like", value, "stationName");
			return (Criteria) this;
		}

		public Criteria andStationNameIn(List<String> values) {
			addCriterion("station_name in", values, "stationName");
			return (Criteria) this;
		}

		public Criteria andStationNameNotIn(List<String> values) {
			addCriterion("station_name not in", values, "stationName");
			return (Criteria) this;
		}

		public Criteria andStationNameBetween(String value1, String value2) {
			addCriterion("station_name between", value1, value2, "stationName");
			return (Criteria) this;
		}

		public Criteria andStationNameNotBetween(String value1, String value2) {
			addCriterion("station_name not between", value1, value2, "stationName");
			return (Criteria) this;
		}

		public Criteria andDepArrIsNull() {
			addCriterion("dep_arr is null");
			return (Criteria) this;
		}

		public Criteria andDepArrIsNotNull() {
			addCriterion("dep_arr is not null");
			return (Criteria) this;
		}

		public Criteria andDepArrEqualTo(String value) {
			addCriterion("dep_arr =", value, "depArr");
			return (Criteria) this;
		}

		public Criteria andDepArrNotEqualTo(String value) {
			addCriterion("dep_arr <>", value, "depArr");
			return (Criteria) this;
		}

		public Criteria andDepArrGreaterThan(String value) {
			addCriterion("dep_arr >", value, "depArr");
			return (Criteria) this;
		}

		public Criteria andDepArrGreaterThanOrEqualTo(String value) {
			addCriterion("dep_arr >=", value, "depArr");
			return (Criteria) this;
		}

		public Criteria andDepArrLessThan(String value) {
			addCriterion("dep_arr <", value, "depArr");
			return (Criteria) this;
		}

		public Criteria andDepArrLessThanOrEqualTo(String value) {
			addCriterion("dep_arr <=", value, "depArr");
			return (Criteria) this;
		}

		public Criteria andDepArrLike(String value) {
			addCriterion("dep_arr like", value, "depArr");
			return (Criteria) this;
		}

		public Criteria andDepArrNotLike(String value) {
			addCriterion("dep_arr not like", value, "depArr");
			return (Criteria) this;
		}

		public Criteria andDepArrIn(List<String> values) {
			addCriterion("dep_arr in", values, "depArr");
			return (Criteria) this;
		}

		public Criteria andDepArrNotIn(List<String> values) {
			addCriterion("dep_arr not in", values, "depArr");
			return (Criteria) this;
		}

		public Criteria andDepArrBetween(String value1, String value2) {
			addCriterion("dep_arr between", value1, value2, "depArr");
			return (Criteria) this;
		}

		public Criteria andDepArrNotBetween(String value1, String value2) {
			addCriterion("dep_arr not between", value1, value2, "depArr");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table dep_arr_info
	 * @mbg.generated
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table dep_arr_info
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }
}