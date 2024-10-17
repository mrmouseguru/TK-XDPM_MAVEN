package com.cgm.student_app.ui;

import com.cgm.student_app.usecase.AddStudentInputBoundary;
import com.cgm.student_app.usecase.dto.AddStudentInputDTO;

public class AddStudentController {

    private AddStudentInputBoundary addStudentInputBoundary = null;

    

    public AddStudentController(AddStudentInputBoundary addStudentInputBoundary) {
        this.addStudentInputBoundary = addStudentInputBoundary;
    }



    public void execute(AddStudentInputDTO addStudentInputDTO) {

        addStudentInputBoundary.execute(addStudentInputDTO);

        
    }

}
