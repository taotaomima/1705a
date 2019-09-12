package com.bw.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bw.entity.Engineer;
import com.bw.entity.Profession;
import com.bw.mapper.EngineerDao;

public class FileUtil {
	public static void main(String[] args) throws IOException {
		 ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		 EngineerDao mapper = ac.getBean(EngineerDao.class,"EngineerDao");

		 BufferedReader br = new BufferedReader(new FileReader(new File("src/main/resources/data.txt")));
		
		 String str = null;
		 while((str =  br.readLine())!= null){
			 String[] split = str.split("\\|");
			 Profession selectByName1;
			 Profession selectByName2 = null;
			 if(split[6] != null  && !"".equals(split[6].trim())){
				 selectByName2 = mapper.selectProfessionbyName(split[6]);
			 }else{
				 selectByName2 = new Profession();
			 }
			 Engineer e = new Engineer(null, split[0], split[1], split[2], split[3], split[4], (selectByName1 = mapper.selectProfessionbyName(split[5])) == null ? 0 :selectByName1.getPid() , selectByName2.getPid(),split[7],split[8], split[9]);
			 
			 //数据库添加
			 mapper.insertEngineer(e);
			 
		 }
		 
		 br.close();
		 
	}
}
