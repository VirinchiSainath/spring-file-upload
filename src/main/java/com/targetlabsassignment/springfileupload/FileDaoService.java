package com.targetlabsassignment.springfileupload;

import java.io.File;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository @Component
@Transactional
public class FileDaoService {
	
	@PersistenceContext
	EntityManager entityManager;

	public int saveFile(FileEntity uploadedFile) {
		entityManager.persist(uploadedFile);
		return uploadedFile.getId();
	}

	public List<FileEntity> getAllFiles() {
		List<FileEntity> fileEntityList = (List<FileEntity>)entityManager.createQuery("from FileEntity").getResultList();
		return fileEntityList;
	}

	public FileEntity getFileById(int fileId) {
		List<FileEntity> fileEntityList = (List<FileEntity>)entityManager.createQuery("from FileEntity").getResultList();
		for(FileEntity fileEntity : fileEntityList){
			if (fileEntity.getId() == fileId) {
				System.out.println("==>" + fileEntity + "<==");
				return fileEntity;
			}
		}
		return null;
	}

}
