package com.cgm.student_app.usecase;

import java.util.Date;

import com.cgm.student_app.entity.KinhTeStudent;
import com.cgm.student_app.entity.PhanMemStudent;
import com.cgm.student_app.entity.Student;
import com.cgm.student_app.usecase.dto.AddStudentInputDTO;
import com.cgm.student_app.usecase.dto.AddStudentOutputDTO;

public class AddStudentUseCase implements AddStudentInputBoundary {
    private AddStudentOputputBoundary addStudentOputputBoundary = null;
    private AddStudentDatabaseBoundary addStudentDBBondary = null;

    public AddStudentUseCase(AddStudentOputputBoundary addStudentOputputBoundary,
            AddStudentDatabaseBoundary addStudentDBBondary) {
        this.addStudentOputputBoundary = addStudentOputputBoundary;
        this.addStudentDBBondary = addStudentDBBondary;
    }

    @Override
    public void execute(AddStudentInputDTO addStudentInputDTO) {

        // validate
        // store Student
        Student student = null;
        String hoTen = addStudentInputDTO.getHoTen();
        Date ngaySinh = addStudentInputDTO.getNgaySinh();
        String diaChi = addStudentInputDTO.getDiaChi();
        if (addStudentInputDTO.getNganh().equals("Phan Mem")) {
            student = new PhanMemStudent(hoTen,
                    ngaySinh, diaChi,
                    addStudentInputDTO.getDiemJava(), addStudentInputDTO.getDiemCss(),
                    addStudentInputDTO.getDiemHtml());
        } else {

            student = new KinhTeStudent(hoTen, ngaySinh, diaChi,
                    addStudentInputDTO.getDiemMarketing(), addStudentInputDTO.getDiemSales());
        }

        //THEM VAO DATABASE
        int addedStudentId = addStudentDBBondary.addStudent(student);

        // tifm sinh vien
        Student addedStudent = addStudentDBBondary.findStudentById(addedStudentId);

        AddStudentOutputDTO addStudentOutputDTO = new AddStudentOutputDTO(
                addedStudent.getMaSV(), addedStudent.getHoTen(), addedStudent.getNganh(),
                addedStudent.getNgaySinh(), addedStudent.getDiaChi(),
                addedStudent.tinhDiemTB(), addedStudent.getHocLuc());

        addStudentOputputBoundary.present(addStudentOutputDTO);

    }

    private boolean validateNgaySinh(Date ngaySinh) {

        // TO-DO
        return false;

    }

    private boolean validateDiem(double diem) {

        // TO-DO
        return false;

    }

}
