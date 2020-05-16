package train.trip.service;

import java.sql.Time;
import java.time.LocalTime;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import train.trip.dao.ScheduleListDao;
import train.trip.form.ActionForm;
import train.trip.form.DepArrInfoForm;
import train.trip.mbg.entity.DepArrInfo;
import train.trip.mbg.entity.Schedule;
import train.trip.mbg.mapper.DepArrInfoMapper;
import train.trip.mbg.mapper.ScheduleMapper;

@Service
public class ScheduleService {
	
	@Autowired
	private ScheduleMapper mapper;
	
	@Autowired
	private DepArrInfoMapper daiMapper;
	
	@Autowired
	private DepArrInfoService service;
	
	@Autowired
	private ScheduleListDao dao;
	
	public void add(Schedule entity) throws Exception {
		mapper.insert(entity);
	}
	
	public int getNextDayNumber(Integer id) {
		int next = 1;
		Integer max = dao.getMaxDayNumber(id);

		if (max != null) {
			next = max + 1;
		}

		return next;
	}
	
	@Transactional
	public void addTrainSchedule(DepArrInfoForm form) throws Exception {
		ModelMapper modelMapper = new ModelMapper();
		Schedule schedule = modelMapper.map(form, Schedule.class);
		mapper.insert(schedule);
		
		DepArrInfo info = new DepArrInfo();
		info.setScheduleId(schedule.getId());
		info.setDepArrTime(Time.valueOf(LocalTime.of(form.getDepTime(), form.getDepMinute())));
		info.setStationName(form.getDepStationName());
		info.setDepArr("発");
		service.add(info);
		
		info = new DepArrInfo();
		info.setScheduleId(schedule.getId());
		info.setDepArrTime(Time.valueOf(LocalTime.of(form.getArrTime(), form.getArrMinute())));
		info.setStationName(form.getArrStationName());
		info.setDepArr("着");
		service.add(info);
	}
	
	public DepArrInfo selectDepArrInfo(Integer id) {
		return daiMapper.selectByPrimaryKey(id);
	}
	
	@Transactional
	public void addActionSchedule(ActionForm form) throws Exception {
		Schedule schedule = new Schedule();
		schedule.setTrainTripId(form.getTrainTripId());
		schedule.setDayNumber(form.getDayNumber());
		schedule.setAction(form.getAction());
		mapper.insert(schedule);
		
		DepArrInfo info = new DepArrInfo();
		info.setScheduleId(schedule.getId());
		info.setDepArrTime(Time.valueOf(form.getArrTime().toLocalTime().plusSeconds(1)));
		service.add(info);
	}
	
	@Transactional
	public void deleteSchedule(Integer scheduleId) throws Exception {
		dao.deleteDepArrInfoByScheduleId(scheduleId);
		mapper.deleteByPrimaryKey(scheduleId);
	}
}
