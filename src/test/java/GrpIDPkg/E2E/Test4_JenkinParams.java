package GrpIDPkg.E2E;

import java.io.IOException;

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
      
    }
    
    


}