package com.bw.service;

import java.util.List;
import java.util.Map;

import com.bw.entity.Engineer;
import com.bw.entity.Profession;

public interface EngineerService {

	Profession selectProfessionbyName(String string);

	void insertEngineer(Engineer engineer);

	List<Map<String, Object>> findAll(Map<String, Object> map);

	List<Profession> selectAll();

	Map<String, Object> findOne(Integer eid);

	boolean updateEn(Engineer en);

	boolean deleteAll(String[] split);

}
