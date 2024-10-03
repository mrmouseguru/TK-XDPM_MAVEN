package com.cgm;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestErrorSum {
    
    @Test
    public void test() {
        InputBoundary inputBoundary = new SumUseCaseControl();
        OutputBoundary out = new SumUIConsoleOutput();
        SumUIConsoleOutput outConsole = (SumUIConsoleOutput)out;
        SumUseCaseControl useCaseControl = (SumUseCaseControl)inputBoundary;
        useCaseControl.setSumUIConsoleOutput(out);

        RequestData req = new RequestData("2", "a");
        
        inputBoundary.execute(req);

        assertEquals(outConsole.getResponseEror().error, 
        "ERROR_INVALID_INPUT");
        assertEquals(outConsole.getResponseEror().error, 
        "ERROR_INVALID_INPUT");

        RequestData req2 = new RequestData("2", "2");

       inputBoundary.execute(req2);
       

        assertEquals(outConsole.getResponseData().strSumResult, "4");





        


        
    }
}
