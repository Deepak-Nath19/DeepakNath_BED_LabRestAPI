package com.greatlearning.studentManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.studentManagement.entity.Student;
import com.greatlearning.studentManagement.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository repository;

	@Override
	public List<Student> getAllStudents() {
		return repository.findAll();

	}

	@Override
	public void addOrUpdate(Student student) {
		repository.save(student);

	}

	@Override
	public void deleteByStudentId(int id) {
		repository.deleteById(id);
	}

	@Override
	public Student getStudentById(int id) {
		return repository.findById(id).get();
	}

}
