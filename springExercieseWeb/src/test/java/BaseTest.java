//import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;

/**
 * @author wanglinlin
 */
public class BaseTest {
    
//	protected Logger log = Logger.getLogger(this.getClass());
    protected static ApplicationContext appContext;
    protected static String[] string = new String[]{"spring/spring-config.xml"};

    @BeforeClass
    public static void setUp() throws Exception {
        Properties properties = System.getProperties();
        properties.put("profiles.active","dev");
        try {
            long start = System.currentTimeMillis();
            System.out.println("加载开始..." + start);
            appContext = new ClassPathXmlApplicationContext(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Before
    public void autoSetBean() {
        appContext.getAutowireCapableBeanFactory()
        	.autowireBeanProperties(this, DefaultListableBeanFactory.AUTOWIRE_BY_NAME, false);
    }

    @AfterClass
    public static void tearDown() throws Exception {
    }
    
}