package com.sales.message.suite;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.sales.message.parser.MessageParserTest;

@RunWith(Suite.class)
@SuiteClasses({MessageParserTest.class})
public class TestSuite {

	public static void main(String[] args) {
            Result execResult = JUnitCore.runClasses(TestSuite.class);
            for(Failure failure:execResult.getFailures())
            	System.out.println(failure.toString());
            
            if(execResult.wasSuccessful())
            	System.out.println("Executed Successfully....");
	}

}
