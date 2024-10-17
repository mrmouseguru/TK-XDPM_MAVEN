package com.cgm.student_app.usecase;

import com.cgm.student_app.entity.Student;

public interface AddStudentDatabaseBoundary {

    int addStudent(Student student);
    Student findStudentById(int Id);


}
