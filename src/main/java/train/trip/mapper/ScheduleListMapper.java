package train.trip.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import train.trip.dto.ScheduleResultDto;

public interface ScheduleListMapper {
	
	public List<ScheduleResultDto> selectByDay(@Param("id") Integer id, @Param("num") Integer num);
	
	public Integer getMaxDayNumber(Integer id);
	
}
