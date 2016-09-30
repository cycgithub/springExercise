import com.client.BasicInterface;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * Created by chenyuchao on 2016/9/24.
 */
public class httpClientTest extends BaseTest{
        @Resource(name="httpClient")
    private BasicInterface httpClient;
    @Test
    public void HttpTest(){

        httpClient.doBusiness("\"tansCode\":\"abc\"");
    }
}
