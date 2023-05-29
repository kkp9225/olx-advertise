package com.olxadvertise.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "advertise")
@ApiModel(value = "This Model holds information about Advertise")
public class AdvertiseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ApiModelProperty(value = "Title of advertise")
	private String title;
	@Column(name = "current_price")
	@ApiModelProperty(value = "Price of advertise")
	private String price;
	@ApiModelProperty(value = "Category-id of advertise")
	private int categoryId;
	@ApiModelProperty(value = "Description of advertise")
	private String description;
	@ApiModelProperty(value = "Username of user posting advertise")
	private String username;
	@ApiModelProperty(value = "Created date of advertise")
	private Date createdDate;
	@ApiModelProperty(value = "Modified date of advertise")
	private Date modifiedDate;
	@ApiModelProperty(value = "Status of advertise")
	private String status;
	@ApiModelProperty(value = "Category of advertise")
	private String category;
	@ApiModelProperty(value = "Status-id of advertise")
	private int statusId;
	
	public AdvertiseEntity() {}
	
	public AdvertiseEntity(int id, String title, String price, int categoryId, String description, String username,
			Date createdDate, Date modifiedDate, String status, String category, int statusId) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.categoryId = categoryId;
		this.description = description;
		this.username = username;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.status = status;
		this.category = category;
		this.statusId = statusId;
	}
	
	public AdvertiseEntity(int categoryId2, String description2, String price2, String title2) {
		this.title = title2;
		this.price = price2;
		this.categoryId = categoryId2;
		this.description = description2;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	@Override
	public String toString() {
		return "AdvertiseEntity [id=" + id + ", title=" + title + ", price=" + price + ", categoryId=" + categoryId
				+ ", description=" + description + ", username=" + username + ", createdDate=" + createdDate
				+ ", modifiedDate=" + modifiedDate + ", status=" + status + ", category=" + category + ", statusId="
				+ statusId + "]";
	}
}
