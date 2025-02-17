package com.CorporationManagement.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate 
@Table(name = "SysDtls")
public class SystemEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "IssueName")
	private String IssueName;
	
	@Column(name = "IssueLocation")
	private String IssueLocation;
	
	@Column(name = "Status")
	private String Status;
	
	@Column(name = "Description")
	private String Description;
	
	@Column(name = "ward")
	private int ward;

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	@Lob
	@Column(name = "image" , nullable = true)
	private byte[] image;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIssueName() {
		return IssueName;
	}

	public void setIssueName(String issueName) {
		IssueName = issueName;
	}

	public String getIssueLocation() {
		return IssueLocation;
	}

	public void setIssueLocation(String issueLocation) {
		IssueLocation = issueLocation;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	public int getWard() {
		return ward;
	}

	public void setWard(int Ward) {
		this.ward = Ward;
	}
	
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	@Column(name = "filename")
	public String filename;
	
	@Column(name = "filetype")
	public String filetype;
	
	
	@Override
	public String toString() {
		return "SystemEntity [id=" + id + ", IssueName=" + IssueName + ", IssueLocation=" + IssueLocation + ", Status="
				+ Status + ",ward=" + ward + ", Description=" + Description + ", image=" + image+ "]";
	}

	public SystemEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SystemEntity(String issueName, String issueLocation, String status, String description, int ward ,String filetype , String filename , byte[] image) {
		super();
		this.IssueName = issueName;
		this.IssueLocation = issueLocation;
		this.Status = status;
		this.Description = description;
		this.ward = ward;
		this.filename = filename;
		this.filetype = filetype;
		this.image = image;
	}
}
