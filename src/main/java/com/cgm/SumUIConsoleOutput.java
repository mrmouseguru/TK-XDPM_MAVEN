package com.cgm;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class SumUIConsoleOutput implements OutputBoundary{

    //fields
    private PrintWriter stdOut = null;
    //

    public SumUIConsoleOutput(){
        stdOut = new PrintWriter(
            new OutputStreamWriter(System.out));
    }
    public void output(ResponseData responseData) {
        stdOut.print("Ket qua la: " + responseData.strSumResult);
        stdOut.flush();
    }

    public void showError(ResponseEror responseEror){
        err(responseEror);
    }

    private void err(ResponseEror responseEror){
        stdOut.println("ERROR: " + responseEror.error );
        stdOut.flush();
    }

}
