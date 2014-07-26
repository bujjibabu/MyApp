/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sampleapp.controller;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author bujji
 */
@Controller
@RequestMapping("/views")
public class HomeController {
    
    
    
    @RequestMapping("data.json")
    public @ResponseBody JSONArray getArtData(HttpServletRequest request) { 
        JSONParser parser = new JSONParser();
        JSONArray array = null;
        try {        
            ServletContext context = request.getServletContext();
            String serverPath = context.getRealPath("/")+"/data";
            File folder = new File(serverPath+"/data");
            File dataFile = new File(serverPath+"/data.json");
            if(dataFile.exists()){
                array = (JSONArray) parser.parse(new FileReader(dataFile.getAbsolutePath()));
            }
//            JSONArray jsonArray = new JSONArray();

//            File arrFiles[] = folder.listFiles();
//            for(File file : arrFiles){
////                System.out.println("File name : "+file.getAbsolutePath());
//                JSONObject jsonObj = new JSONObject();
//                jsonObj.put("name", file.getName());
//                jsonObj.put("path", "images/"+file.getName());
////                jsonObj.put("desc", file.getAbsolutePath()+" .... "+new Date());
//                jsonArray.add(jsonObj);
//            }
        
        
//        File folder1 = new File("E:\\data.json");
//        if(!folder1.exists())folder1.createNewFile();
//            System.out.println("File created.......");
//            
//		FileWriter file = new FileWriter("E:\\data.json");
//		file.write(jsonArray.toJSONString());
//		file.flush();
//		file.close();
//                
//                System.out.println("Data writing done...");
////                
//                array = (JSONArray) parser.parse(new FileReader("E:\\data.json"));
////                
//                System.out.println("Data reading done...."+array.toJSONString());
                
	} catch (Exception e) {
		e.printStackTrace();
	}
        
        
        return array;
    }
    
    
    @RequestMapping("/home")
    public String displayHome(){
        return "views/home";
    }
    
}
