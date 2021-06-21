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
      
    }
    
    


}