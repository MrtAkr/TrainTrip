package train.trip.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import train.trip.dto.ScheduleResultDto;
import train.trip.mapper.ScheduleListMapper;
import train.trip.mbg.entity.DepArrInfoExample;
import train.trip.mbg.mapper.DepArrInfoMapper;

@Repository
public class ScheduleListDao {
	
	@Autowired
	private ScheduleListMapper mapper;
	
	@Autowired
	private DepArrInfoMapper daiMapper;
	
	public List<ScheduleResultDto> selectByDay(Integer id, Integer dayNumber) {
		return mapper.selectByDay(id, dayNumber);
	}
	
	public Integer getMaxDayNumber(Integer id) {
		return mapper.getMaxDayNumber(id);
	}
	
	public void deleteDepArrInfoByScheduleId(Integer id) {
		DepArrInfoExample example = new DepArrInfoExample();
	    example.createCriteria().andScheduleIdEqualTo(id);
	    daiMapper.deleteByExample(example);
	}
}
