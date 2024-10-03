package com.cgm;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class SumUIConsoleOutput implements OutputBoundary{

    //fields
  //  private PrintWriter stdOut = null;
    private ResponseEror responseEror = null;
    private ResponseData responseData = null;
    //

    public SumUIConsoleOutput(){
       // stdOut = new PrintWriter(
         //   new OutputStreamWriter(System.out));
    }
    public void output(ResponseData responseData) {
        this.responseData = responseData;
       // stdOut.print("Ket qua la: " + responseData.strSumResult);
       // stdOut.flush();
    }

    public void showError(ResponseEror responseEror){
        this.responseEror = responseEror;
        //err(responseEror);
    }

    private void err(ResponseEror responseEror){
       // stdOut.println("ERROR: " + responseEror.error );
       // stdOut.flush();
    }

    public ResponseEror getResponseEror() {
        return responseEror;
    }

    public ResponseData getResponseData() {
        return responseData;
    }

}
