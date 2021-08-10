package com.SpringBootDemoProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.SpringBootDemoProject.entity.FileUploadHelper;

@RestController
public class FileUploadedController {
	
	@Autowired
	FileUploadHelper fileuploadhelper;
	
	
	@PostMapping("/uploadfile")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file)
	{
		//first way
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        System.out.println(file.getName());
        System.out.println(file.getContentType());
        
        try
        {
       //Validation
        if(file.isEmpty())
        {
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request Must Contain File");
        }
        if(file.getContentType().equals("image/jpeg/pdf"))
        {
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPEG/PDF content type are allowed");
        }
        
        //file upload code
        boolean  bfile = fileuploadhelper.uploadFiles(file);
        
        
        if(bfile)
        {
        	return ResponseEntity.ok("File Upload Successfully");
        }
        
        }catch (Exception e) {
			e.printStackTrace();
		}
        
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Somthing went wrong!!!");
	}

}
