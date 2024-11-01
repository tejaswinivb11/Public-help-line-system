package com.CorporationManagement.Service.impl;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.CorporationManagement.Entity.SystemEntity;
import com.CorporationManagement.Repository.SystemRepository;
import com.CorporationManagement.Service.SystemService;

@Service
public class ServiceImpls implements SystemService{
	
	@Autowired
	private SystemRepository SR;

	@Override
	public List<SystemEntity> getAllIssues() {
		return SR.findAll();
	}

	@Override
	public SystemEntity SaveEntity(SystemEntity Se) {
		return SR.save(Se);
	}

	@Override
	public SystemEntity getIssueById(int id) {
		return SR.findById(id).get();
	}

	@Override
	public SystemEntity UpdateIssue(SystemEntity SE) {
		return SR.save(SE);
	}

	@Override
	public void DeleteIssueById(int id) {
		SR.deleteById(id);
	}

	@Override
	public List<SystemEntity> SortAllAsc() {
		 return SR.findAll(Sort.by(Sort.Direction.ASC, "ward"));
	    
	}

	@Override
	public SystemEntity ImageSave(String name , String IssueLocation ,int ward ,MultipartFile file){
		SystemEntity SE = new SystemEntity();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains("..")) {
			System.out.println("invalid image you have posted");
		}
		try {
			SE.setImage((file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		SE.setIssueName(name);
		SE.setIssueLocation(IssueLocation);
		SE.setWard(ward);
		return SR.save(SE);
	}
	
	public SystemEntity saveFile(String name , String IssueLocation ,int ward ,MultipartFile file) {
		String fileName =StringUtils.cleanPath(file.getOriginalFilename());
		
		if (fileName.contains("..")) {
			System.out.print("its a invalid input");
		}
		
		SystemEntity SE = new SystemEntity();
		SE.setFilename(fileName);
		SE.setIssueName(name);
		SE.setFiletype(file.getContentType());
		try {
			SE.setImage(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SE.setIssueLocation(IssueLocation);
		SE.setWard(ward);
		return SR.save(SE);
	}

	@Override
	public void saveImage(SystemEntity imageGallery) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SystemEntity> getAllActiveImages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<SystemEntity> getImageById(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public byte[] findById(int id) {
		return SR.findById(id).get().getImage();
	}

}
