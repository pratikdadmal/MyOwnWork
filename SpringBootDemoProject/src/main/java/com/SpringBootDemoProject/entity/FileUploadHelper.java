package com.SpringBootDemoProject.entity;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.JPopupMenu.Separator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sun.xml.bind.api.impl.NameConverter.Standard;

@Component
public class FileUploadHelper {
	
	
	public final String UPLOAD_DIR ="H:\\Softwares Java\\STS4\\SpringBootDemoProject\\src\\main\\resources\\images";
	
	public boolean uploadFiles(MultipartFile multipartfile)
	{
		boolean b = false;
		try
		{
			 
		Files.copy(multipartfile.getInputStream(),Paths.get(UPLOAD_DIR+File.separator+multipartfile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
		
		
		b=true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;

		
  }
}
