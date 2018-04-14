package com.targetlabsassignment.springfileupload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FileDaoCommandLineRunner implements CommandLineRunner{
	
	@Autowired
	FileDaoService fileDaoService;

	@Override
	public void run(String... args) throws Exception {
		
		FileEntity preUploadedFile1 = new FileEntity("preUploadedText1.txt", "Trisha", "txt", "NotePad");
		fileDaoService.saveFile(preUploadedFile1);
		
		FileEntity preUploadedFile2 = new FileEntity("preUploadedText2.txt", "Erik", "txt", "NotePad++");
		fileDaoService.saveFile(preUploadedFile2);
		
	}

}
