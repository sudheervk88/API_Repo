import com.annotations.ApiTest;
import org.testng.annotations.Test;


public class TestRunner {

    @ApiTest
    public void testMethod1(){
          System.out.println("test1");
      }

      @ApiTest
    public void testMethod2(){
        System.out.println("test2");
    }

    @ApiTest
    public void testMethod3(){
        System.out.println("test3");
    }


}
