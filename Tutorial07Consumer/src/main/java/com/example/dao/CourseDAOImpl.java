package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.model.CourseModel;
import com.example.model.StudentModel;

@Service
public class CourseDAOImpl implements CourseDAO {
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public CourseModel selectCourse(String npm) {
		CourseModel course = restTemplate.getForObject("http://localhost:8080/rest/course/view/" + npm,
				CourseModel.class);
		return course;
	}

	@Override
	public List<CourseModel> selectAllCourses() {
		List<CourseModel> courses = restTemplate.getForObject("http://localhost:8080/rest/course/viewall",
				List.class);
		return courses;
	}

}
