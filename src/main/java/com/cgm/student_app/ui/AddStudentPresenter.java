package com.cgm.student_app.ui;

import com.cgm.student_app.usecase.AddStudentOputputBoundary;
import com.cgm.student_app.usecase.dto.AddStudentOutputDTO;

public class AddStudentPresenter implements AddStudentOputputBoundary{
    
    private AddStudentOutputDTO addStudentOutputDTO = null;
    @Override
    public void present(AddStudentOutputDTO addStudentOutputDTO) {
        this.addStudentOutputDTO = addStudentOutputDTO;
        testPrint(addStudentOutputDTO);

    }


    public AddStudentOutputDTO getAddStudentOutputDTO() {
        return addStudentOutputDTO;
    }

    private void testPrint(AddStudentOutputDTO addStudentOutputDTO){

        System.out.println(addStudentOutputDTO.getHoTen());
        System.out.println(addStudentOutputDTO.getDiemTB());
        System.out.println(addStudentOutputDTO.getHocLuc());

    }

}
