package com.targetlabsassignment.springfileupload;

import java.sql.Blob;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FileEntity {
	
	@Id
	@GeneratedValue
	int id;
	
	// meta data
	private String fileName;
	private String fileAuthor;
	private String fileType;
	private String programToRun;
	
	public FileEntity() {
		super();
	}

	public FileEntity(String fileName, String fileAuthor, String fileType, String programToRun) {
		super();
		this.fileName = fileName;
		this.fileAuthor = fileAuthor;
		this.fileType = fileType;
		this.programToRun = programToRun;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileAuthor() {
		return fileAuthor;
	}

	public void setFileAuthor(String fileAuthor) {
		this.fileAuthor = fileAuthor;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getProgramToRun() {
		return programToRun;
	}

	public void setProgramToRun(String programToRun) {
		this.programToRun = programToRun;
	}

	@Override
	public String toString() {
		return "FileEntity{" +
				"id=" + id +
				", fileName='" + fileName + '\'' +
				", fileAuthor='" + fileAuthor + '\'' +
				", fileType='" + fileType + '\'' +
				", programToRun='" + programToRun + '\'' +
				'}';
	}
}
