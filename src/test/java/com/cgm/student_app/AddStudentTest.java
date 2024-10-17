package com.cgm.student_app;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.cgm.student_app.database.AddStudentDAOMemory;
import com.cgm.student_app.ui.AddStudentPresenter;
import com.cgm.student_app.usecase.AddStudentInputBoundary;
import com.cgm.student_app.usecase.AddStudentUseCase;
import com.cgm.student_app.usecase.dto.AddStudentInputDTO;
import com.cgm.student_app.usecase.dto.AddStudentOutputDTO;

public class AddStudentTest {

    @Test
    public void testAddStudent() {
        AddStudentDAOMemory database = new AddStudentDAOMemory();
        AddStudentPresenter addStudentPresenter = new AddStudentPresenter();
        AddStudentInputBoundary  addStudentInputBoundary =  
        new AddStudentUseCase(addStudentPresenter, database);

        addStudentInputBoundary.execute(mockStudentInputData());

        AddStudentOutputDTO addStudentOutputDTO = addStudentPresenter.getAddStudentOutputDTO();

        assertEquals(mockStudentInputData().getHoTen(), addStudentOutputDTO.getHoTen());

        
    }

    private AddStudentInputDTO mockStudentInputData(){
        AddStudentInputDTO student1 = null;
        Calendar calendar1 = Calendar.getInstance();
        
        // Đặt ngày, tháng, năm
        calendar1.set(Calendar.YEAR, 1984);
        calendar1.set(Calendar.MONTH, Calendar.NOVEMBER); // Tháng 11 (0 là tháng 1)
        calendar1.set(Calendar.DAY_OF_MONTH, 13);
        
        // Tạo đối tượng Date từ Calendar
        Date date1 = calendar1.getTime();

        //new PhanMemStudent("Nguyen Van A", date1, "HCM", 5, 5, 5)
         student1 = new AddStudentInputDTO("Nguyen Van A", 
        "Kinh Te", date1, "TPHCM",
        9, 9);

        return student1;

    }

}
