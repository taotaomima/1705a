package com.bw.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bw.entity.Engineer;
import com.bw.entity.Profession;
import com.bw.service.EngineerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class EngineerController {

	@Resource
	private EngineerService service;
	
	@RequestMapping("list.do")
	public String findAll(String ename,String area,Integer pid,@RequestParam(required=false,defaultValue="1")Integer pageNum,ModelMap modelmap){
		PageHelper pahe = new PageHelper();
		pahe.startPage(pageNum, 20);
		Map<String,Object> map = new HashMap<String, Object>(); 
		map.put("ename", ename);
		map.put("area", area);
		map.put("pid", pid);
		List<Map<String,Object>> list=service.findAll(map);
		PageInfo<Map<String,Object>> page = new PageInfo<Map<String,Object>>(list);
		modelmap.put("page", page);
		return "list";
	}
	
	@RequestMapping("selectprofession.do")
	@ResponseBody
	public List<Profession> selectAll(){
		List<Profession> list=service.selectAll();
		return list;
	}
	
	@RequestMapping("toupdate.do")
	@ResponseBody
	public Map<String, Object> toupdate(Integer eid){
		Map<String,Object> map1 = new HashMap<String, Object>(); 
		Map<String,Object> map =service.findOne(eid);
		List<Profession> list=service.selectAll();
		map1.put("map", map);
		map1.put("list", list);
		return map1;
	}
	
	@RequestMapping("update.do")
	@ResponseBody
	public boolean update(Engineer en){
		boolean b=service.updateEn(en);
		return b;
	}
	
	@RequestMapping("deleteAll.do")
	@ResponseBody
	public boolean deleteAll(String eid){
		String[] split = eid.split(",");
		boolean b=service.deleteAll(split);
		return b;
	}
	
	
}
