

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class HttpClient {
    public static void main(String[] args) {
        CloseableHttpClient client= HttpClients.createDefault();
        HttpGet get=new HttpGet("http://www.baidu.com");
        CloseableHttpResponse response=null;
        try {
            response=client.execute(get);
            Header headers[] =response.getAllHeaders();
            for (Header header:headers){
                System.out.println(header.getName()+"---"+header.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
