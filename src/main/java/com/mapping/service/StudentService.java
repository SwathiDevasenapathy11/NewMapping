package com.mapping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapping.entity.Student;
import com.mapping.entity.Teacher;
import com.mapping.repository.IStudentRepository;
import com.mapping.repository.ITeacherRepository;

//Many to one service
@Service
public class StudentService {
	
	@Autowired
	private IStudentRepository studentRepository;
	
	@Autowired
	private ITeacherRepository teacherRepository;
	
	public Student addStudent(Student student) {
		Teacher teacher = teacherRepository.findById(student.getTeacher().getId()).orElseThrow(null);
		student.setTeacher(teacher);
		return studentRepository.save(student);
	}
	
	public Teacher addTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}
}
