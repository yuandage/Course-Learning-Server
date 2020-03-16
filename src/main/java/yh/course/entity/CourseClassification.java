package yh.course.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Entity
@Table(name = "course_classification")
public class CourseClassification {
	@Id
	private Integer id;//ID
	private String name;//名称
	private Integer parentId;//父节点
	@Transient
	private List<CourseClassification> courseClassificationList;

	public List<CourseClassification> getCourseClassificationList() {
		return courseClassificationList;
	}

	public void setCourseClassificationList(List<CourseClassification> courseClassificationList) {
		this.courseClassificationList = courseClassificationList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
}