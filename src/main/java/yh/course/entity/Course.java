package yh.course.entity;

import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "course")
public class Course {
	@Id
	private String id;//ID
	private String name;//课程名
	private String summary;//简介
	private String description;//描述
	private String parentId;//父节点
	private String popular;//热门课程
	private String coverUrl;//课程封面
	private Date createDate;//创建时间
	private Date updateDate;//更新时间

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String catalog) {
		this.description = catalog;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getPopular() {
		return popular;
	}

	public void setPopular(String popular) {
		this.popular = popular;
	}

	public String getCoverUrl() {
		return coverUrl;
	}

	public void setCoverUrl(String url) {
		this.coverUrl = url;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


}
