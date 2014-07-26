package com.sampleapp.controller;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletContext;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


/**
 * Created with IntelliJ IDEA.
 * User: xvitcoder
 * Date: 12/21/12
 * Time: 12:22 AM
 */
@Controller
@RequestMapping("/admins")
public class AdminController {

//    @Autowired
//    private TrainService trainService;

    @RequestMapping("data.json")
    public @ResponseBody String getDataList() {
        return null;
    }
    
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String uploadFile(MultipartHttpServletRequest request){ 
     try {
         
        ServletContext context = request.getServletContext();
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String tags = request.getParameter("tags");
        String serverPath = context.getRealPath("/")+"/data";
        File smallImgFolder = new File(serverPath+"/small");
        File largeImgFolder = new File(serverPath+"/large");
        File jsonData = new File(serverPath+"/data.json");
        if(!smallImgFolder.exists())
            smallImgFolder.mkdir();
        if(!largeImgFolder.exists())
            largeImgFolder.mkdir();
        MultipartFile mpfImgfile = request.getFile("thumbnail");
        MultipartFile mpfLargeImgfile = request.getFile("largeImage");
        File smallImgFile = new File(serverPath+"/small"+"/"+mpfImgfile.getOriginalFilename()); 
        File largeImgFile = new File(largeImgFolder.getAbsolutePath()+"/"+mpfLargeImgfile.getOriginalFilename()); 
        if(!smallImgFile.exists())
            smallImgFile.createNewFile();
        if(!largeImgFile.exists())
            largeImgFile.createNewFile();        
        mpfImgfile.transferTo(smallImgFile);
        mpfLargeImgfile.transferTo(largeImgFile);        
         System.out.println("Small file   :::::: "+smallImgFile.getAbsolutePath());
        
//        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObj = new JSONObject();
//        jsonObj.put("name", smallImgFile.getName());
//        jsonObj.put("path", "data/small/"+smallImgFile.getName());
        JSONArray arrThumbnail = new JSONArray();
        arrThumbnail.add("data/small/"+smallImgFile.getName());
        JSONArray arrLarge = new JSONArray();
        arrLarge.add("data/large/"+largeImgFile.getName());
        JSONArray arrTags = new JSONArray();
        arrTags.add(tags);
        
        jsonObj.put("description", description);
        jsonObj.put("title", title);
        jsonObj.put("thumbnail", arrThumbnail);        
        jsonObj.put("large", arrLarge);                
        jsonObj.put("tags", arrTags);
        jsonObj.put("button_list", new JSONArray());
//        jsonArray.add(jsonObj);

        JSONParser parser = new JSONParser();
        JSONArray dataArray = new JSONArray();
        if(jsonData.exists()){
                dataArray = (JSONArray) parser.parse(new FileReader(jsonData.getAbsolutePath()));
            }
        dataArray.add(jsonObj);
        FileWriter file = new FileWriter(jsonData.getAbsolutePath());
        file.write(dataArray.toJSONString());
        file.flush();
        file.close();
        
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }   catch (IllegalStateException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @RequestMapping("/admin")
    public String getTrainPartialPage(ModelMap modelMap) {
        return "admins/admin";
    }
}
