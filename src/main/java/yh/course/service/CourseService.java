package yh.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yh.course.dao.CourseDao;
import yh.course.entity.Course;
import yh.util.IdWorker;

import java.util.List;

@Service
@Transactional
public class CourseService {
	@Autowired
	private CourseDao courseDao;
	@Autowired
	private IdWorker idWorker;

	public List<Course> findAll() {
		return courseDao.findAll();
	}

	public Course findById(String id) {
		return courseDao.findById(id).orElse(null);
	}

	public List<Course> findByParentId(String parentId) {
		return courseDao.findByParentId(parentId);
	}

	public List<Course> findBySubjectId(Integer subjectId) {
		return courseDao.findBySubjectId(subjectId);
	}

	public void save(Course Course) {
		Course.setId(idWorker.nextStringId());//设置分布式ID
		courseDao.save(Course);
	}

	public void update(Course Course) {
		courseDao.save(Course);
	}

	public void deleteById(String id) {
		courseDao.deleteById(id);
	}

	//第二种方法
	public List<Course> findSearch(Course course) {
		return courseDao.findByName(course.getName());
	}

	public Page<Course> pageQuery(Course course, int page, int size) {
		Pageable pageable = PageRequest.of(page - 1, size);
		return courseDao.findByName(course.getName(), pageable);
	}

	public Page<Course> findAllByPage(int page, int size) {
		Pageable pageable = PageRequest.of(page - 1, size);
		return courseDao.findAll(pageable);
	}

	public Page<Course> findByParentIdPage(String parentId, int page, int size) {
		Pageable pageable = PageRequest.of(page - 1, size);
		return courseDao.findByParentId(parentId, pageable);
	}

	public Page<Course> findBySubjectIdPage(Integer subjectId, int page, int size) {
		Pageable pageable = PageRequest.of(page - 1, size);
		return courseDao.findBySubjectId(subjectId, pageable);
	}

	public List<Course> findPopularCourse() {
		return courseDao.findByPopular("1");
	}

	public List<Course> findByNameLike(String name) {
		return courseDao.findByNameLike("%" + name + "%");
	}
}
