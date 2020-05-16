package train.trip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import train.trip.mbg.entity.DepArrInfo;
import train.trip.mbg.mapper.DepArrInfoMapper;

@Service
public class DepArrInfoService {
	
	@Autowired
	private DepArrInfoMapper mapper;

	public void add(DepArrInfo entity) throws Exception {
		mapper.insert(entity);
	}
}

