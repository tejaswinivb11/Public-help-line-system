package com.CorporationManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.CorporationManagement.Entity.SystemEntity;

public interface SystemService {

	List<SystemEntity> getAllIssues();
	
	SystemEntity SaveEntity(SystemEntity Se);
	
	SystemEntity getIssueById(int id);
	
	SystemEntity UpdateIssue(SystemEntity SE);
	
	void DeleteIssueById(int id);
	
	List<SystemEntity> SortAllAsc();
	
	SystemEntity ImageSave(String name , String IssueLocation ,int ward ,MultipartFile file );
	
	void saveImage( SystemEntity imageGallery);
	
	List<SystemEntity> getAllActiveImages();
	
	Optional<SystemEntity> getImageById(int id);
	
	SystemEntity saveFile(String name , String IssueLocation ,int ward ,MultipartFile file);
	
	byte[] findById(int id);
}
