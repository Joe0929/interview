import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class HttpClientTest {

    public String testGet1(String url){
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();

        HttpGet httpGet=new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response=closeableHttpClient.execute(httpGet);
            HttpEntity entity=response.getEntity();
            String toStringResult= EntityUtils.toString(entity, StandardCharsets.UTF_8);
            EntityUtils.consume(entity);
            return toStringResult;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (closeableHttpClient!=null){
                try {
                    closeableHttpClient.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (response!=null){
                try {
                    response.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


}
