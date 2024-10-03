package com.cgm;

public class SumUseCaseControl implements InputBoundary {

    //fields
    private SumEntity sumEntity = null;
   //private SumUIConsoleOutput sumUIConsoleOutput = null;
   private OutputBoundary sumUIConsoleOutput = null;

    //methods
    public SumUseCaseControl(){
        sumEntity = new SumEntity();
        //sumUIConsoleOutput = new SumUIConsoleOutput();
    }

    public void setSumUIConsoleOutput(OutputBoundary sumUIConsoleOutput) {
        this.sumUIConsoleOutput = sumUIConsoleOutput;
    }

    public void execute(RequestData requestData) {

        ///uese case
        String strNumber1 = requestData.strNumber1;
        String strNumber2 = requestData.strNumber2;
        //kiểm tra hợp lệ của 2 
        if(isNumber(strNumber1) && isNumber(strNumber2)){
            //gửi thông điệp đến Entity
            //chuyển chuỗi => số
        int num1 = Integer.parseInt(strNumber1);
        int num2 = Integer.parseInt(strNumber2);
        //message đến SumEntity Object
        //setter
        sumEntity.setNum1(num1);
        sumEntity.setNum2(num2);
        //sum
        int sumResult = sumEntity.sum();
        //nhét sumResult vào ResponseData
        ResponseData responseData = new ResponseData();
        responseData.strSumResult = "" + sumResult;

        //messate to SumUIConsoleOutput Object
        sumUIConsoleOutput.output(responseData);
        }else{
            //gủi thong điệp đến Ouput
            ResponseEror resError = new ResponseEror();
            resError.error = "ERROR_INVALID_INPUT";
            sumUIConsoleOutput.showError(resError);
        }
        
        
    }

    private boolean isNumber(String str){
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str); // cố gắng chuyển chuỗi sang số nguyên
            return true; // nếu thành công thì chuỗi là số nguyên
        } catch (NumberFormatException e) {
            return false; // nếu có lỗi NumberFormatException thì không phải số nguyên
        }
    }

}
