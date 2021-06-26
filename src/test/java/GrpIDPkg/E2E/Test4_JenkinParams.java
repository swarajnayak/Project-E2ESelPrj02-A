package GrpIDPkg.E2E;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Test4_JenkinParams extends Init
{

    @Test
    public void method4() throws IOException
    {
         
    	String browserName = System.getProperty("browser");
    	System.out.println(browserName);
    	System.out.println("First clone from GITHUB 11:58 PM");
    	System.out.println("Second change from eclipse prj02-A 12:36 AM");
    	System.out.println("Change from develp branch - E2ESelPrj02-A 7:39 PM");
    	System.out.println("Change from master branch - E2ESelPrj02-B 8:18 PM");
    	
    	System.out.println("Added 27th June 2:15");
    	Assert.fail();
    }
    
    


}