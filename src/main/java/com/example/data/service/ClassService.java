package com.example.data.service;

import com.example.data.model.Classroom;
import com.example.data.repository.ClassRepository;
import com.example.data.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ClassService implements IClassService{
    @Autowired
    private ClassRepository classRepository;
    @Override
    public void save(Classroom classroom) {
        classRepository.save(classroom);
    }

    @Override
    public List<Classroom> findAll() {
        return (List<Classroom>) classRepository.findAll();
    }

    @Override
    public Classroom findById(Long id) {
        return classRepository.findById(id).orElse(null);
    }
}
