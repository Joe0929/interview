import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class JunitTest {
    String url;
    public JunitTest(String url){
            this.url=url;
    }
    @Test
    public void gettest(){
        System.out.println(new HttpClientTest().testGet1(this.url));

    }
    @Parameters
    public static Collection<?>data(){
        return Arrays.asList(new Object[][]{
                {"http://www.baidu.com"},{"http://www.qq.com"},{"http://www.taobao.com"}
        });
    }
}
