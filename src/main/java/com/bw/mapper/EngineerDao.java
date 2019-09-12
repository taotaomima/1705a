package com.bw.mapper;

import java.util.List;
import java.util.Map;

import com.bw.entity.Engineer;
import com.bw.entity.Profession;

public interface EngineerDao {

	Profession selectProfessionbyName(String string);

	Integer insertEngineer(Engineer engineer);

	List<Map<String, Object>> findAll(Map<String, Object> map);

	List<Profession> selectAll();

	Map<String, Object> findOne(Integer eid);

	Integer updateEn(Engineer en);

	Integer deleteAll(String[] split);

}
