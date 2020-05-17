package train.trip.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import train.trip.dao.ScheduleListDao;
import train.trip.dto.ScheduleListDto;
import train.trip.dto.ScheduleResultDto;
import train.trip.mbg.entity.TrainTrip;
import train.trip.mbg.entity.TrainTripExample;
import train.trip.mbg.mapper.TrainTripMapper;
import train.trip.util.Util;

@Service
public class TrainTripService {
	
	@Autowired
	private TrainTripMapper mapper;
	
	@Autowired
	private ScheduleListDao dao;

	public TrainTrip get(Integer id) {
		TrainTrip entity = mapper.selectByPrimaryKey(id);
		
		return entity;
	}

	public List<TrainTrip> getList() {
		TrainTripExample example = new TrainTripExample();
		example.setOrderByClause("id ASC");
		List<TrainTrip> list = mapper.selectByExample(example);
		
		return list;
	}
	
	public void add(TrainTrip entity) throws Exception {
		entity.setDepartureDate(Util.adjustUtcDate(entity.getDepartureDate()));
		mapper.insert(entity);
	}
	
	public void edit(TrainTrip entity) throws Exception {
		entity.setDepartureDate(Util.adjustUtcDate(entity.getDepartureDate()));
		mapper.updateByPrimaryKey(entity);
	}
	
	public int getMaxDayNumber(Integer id) {
		int num = 0;
		Integer max = dao.getMaxDayNumber(id);

		if (max != null) {
			num = max;
		}

		return num;
	}
	
	public String getCurrentDay(Integer id, Integer dayNumber) {
		TrainTrip entity = mapper.selectByPrimaryKey(id);
		Date depDate = entity.getDepartureDate();
		if (depDate == null) {
			return null;
		}
		Calendar cl = Calendar.getInstance();
		cl.setTime(depDate);
		cl.add(Calendar.DATE, dayNumber - 1);
		SimpleDateFormat sdf = new SimpleDateFormat(" yyyy年M月d日 E曜日 ");
		return sdf.format(cl.getTime());
	}
	
	public void getScheduleList(List<ScheduleListDto> list, Integer id, Integer dayNumber) {
		List<ScheduleResultDto> rs = dao.selectByDay(id, dayNumber);

		for (ScheduleResultDto dto : rs) {
			if (dto.getAction() != null && dto.getStationName() == null) {
				ScheduleListDto act = new ScheduleListDto();
				act.setAction(dto.getAction());
				act.setDepArrInfoId(dto.getDepArrInfoId());
				act.setDayNumber(dto.getDayNumber());
				act.setScheduleId(dto.getScheduleId());
				act.setTrainTripId(dto.getTrainTripId());
				list.add(act);
				continue;
			}
			
			if (dto.getDepArr() != null && dto.getDepArr().equals("発")) {
				ScheduleListDto dep = new ScheduleListDto();
				dep.setDepArr(dto.getDepArr());
				dep.setDepArrTime(dto.getDepArrTime());
				dep.setStationName(dto.getStationName());
				list.add(dep);
				ScheduleListDto tr = new ScheduleListDto();
				tr.setTrainName(dto.getTrainName());
				list.add(tr);
				
			} else if (dto.getDepArr() != null && dto.getDepArr().equals("着")) {
				ScheduleListDto arr = new ScheduleListDto();
				arr.setDepArr(dto.getDepArr());
				arr.setDepArrTime(dto.getDepArrTime());
				arr.setStationName(dto.getStationName());
				arr.setDepArrInfoId(dto.getDepArrInfoId());
				arr.setDayNumber(dto.getDayNumber());
				arr.setScheduleId(dto.getScheduleId());
				arr.setTrainTripId(dto.getTrainTripId());
				list.add(arr);
			}
		}
	}
}

