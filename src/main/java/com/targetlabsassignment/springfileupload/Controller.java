package com.targetlabsassignment.springfileupload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.targetlabsassignment.springfileupload.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {
	
	@Autowired
	FileDaoService fileDaoService;
	
	@RequestMapping("/")
	public String welcomeUsers(){
		return "Welcome to Spring File Upload";
	}
	
	@GetMapping("/list-all-files")
	public List<FileEntity> sendAllFilesList(){
		return fileDaoService.getAllFiles();
	}

	@GetMapping("/files/{fileId}")
	public FileEntity sendFileById(@PathVariable int fileId ){
		FileEntity fileEntity = fileDaoService.getFileById(fileId);
		
		if (fileEntity == null){
			System.out.println("Throwing Resource not found exception");
			throw new ResourceNotFoundException("The resource you trying to view is not yet created");
		}
				
		return fileEntity;
	}
	
	@PostMapping("/files")
	public ResponseEntity<Object> receiveFile(@RequestParam MultipartFile file, @RequestParam String fileAuthor, 
			@RequestParam String fileType, @RequestParam String programToRun){
		FileEntity fileEntity=null;
		try {
			fileEntity = new FileEntity(file.getOriginalFilename(), fileAuthor, fileType, programToRun);
		} catch (Exception e){System.out.println("==> exception in creating new fileEntity");}

		int savedFileId = fileDaoService.saveFile(fileEntity);
		
		//saving file to file system PATH=> /src/main/resoucres/files-uploaded
		File currentDirFile = new File("src\\main\\resources\\files-uploaded\\"+fileEntity.getFileName());
		try {
			System.out.println("==> creating new file");
			currentDirFile.createNewFile();
		    FileOutputStream fos = new FileOutputStream(currentDirFile);
			System.out.println("==> write bytes");
		    fos.write(file.getBytes());
		    fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		URI location = 
		ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedFileId).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
}
