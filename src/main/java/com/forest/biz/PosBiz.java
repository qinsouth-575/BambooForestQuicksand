package com.forest.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forest.entity.Position;
import com.forest.mapper.PositionMapper;

@Service
public class PosBiz {
	@Autowired
		private PositionMapper posmapper;
		
		public List<Position> queryAll(){
			return posmapper.selectByExample(null);
		}
}
