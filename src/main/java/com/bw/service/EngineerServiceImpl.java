package com.bw.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.entity.Engineer;
import com.bw.entity.Profession;
import com.bw.mapper.EngineerDao;

@Service
public class EngineerServiceImpl implements EngineerService{

	@Resource
	private EngineerDao dao;

	public Profession selectProfessionbyName(String string) {
		// TODO Auto-generated method stub
		return dao.selectProfessionbyName(string);
	}

	public void insertEngineer(Engineer engineer) {
		Integer i=dao.insertEngineer(engineer);
	}

	public List<Map<String, Object>> findAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.findAll(map);
	}

	public List<Profession> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	public Map<String, Object> findOne(Integer eid) {
		// TODO Auto-generated method stub
		return dao.findOne(eid);
	}

	public boolean updateEn(Engineer en) {
		Integer i = dao.updateEn(en);
		if(i>0){
			return true;
		}
		return false;
	}

	public boolean deleteAll(String[] split) {
		Integer i=dao.deleteAll(split);
		if(i>0){
			return true;
		}
		return false;
	}
	
}
