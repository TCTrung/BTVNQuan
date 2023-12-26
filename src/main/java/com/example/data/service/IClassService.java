package com.example.data.service;

import com.example.data.model.Classroom;
import com.example.data.model.Student;

import java.util.List;

public interface IClassService {
    void save(Classroom classroom);
    List<Classroom> findAll();
    Classroom findById(Long id);
}
