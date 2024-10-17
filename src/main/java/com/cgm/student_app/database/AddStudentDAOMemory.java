package com.cgm.student_app.database;

import java.util.HashMap;
import java.util.Map;

import com.cgm.student_app.entity.Student;
import com.cgm.student_app.usecase.AddStudentDatabaseBoundary;

public class AddStudentDAOMemory implements AddStudentDatabaseBoundary{
    private Map<Integer, Student> mockDatabase = new HashMap<>();
    private int currentStudentId = 0;
    @Override
    public int addStudent(Student student) {

        mockDatabase.put(++currentStudentId, student);
        return currentStudentId;

    }
    @Override
    public Student findStudentById(int studentId) {

        Student student = null;

       student =  mockDatabase.get(studentId);

       return student;
    }

    

}
