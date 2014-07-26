/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sampleapp.beans;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author MURALI
 */
public class FileUploadBean {
    
    public String title;
    public String description;    
    public String tags;
    public MultipartFile thumbnail;
    public MultipartFile largeImage;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public MultipartFile getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(MultipartFile thumbnail) {
        this.thumbnail = thumbnail;
    }

    public MultipartFile getLargeImage() {
        return largeImage;
    }

    public void setLargeImage(MultipartFile largeImage) {
        this.largeImage = largeImage;
    }
    

}
