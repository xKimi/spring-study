package beans.lookup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Copyright (c) 2020 Kimi. All Rights Reserved
 *
 * @Date 2020/5/29 18:54
 * @Author Feng Yalong
 */
public class BeanTest {

    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("lookupTest.xml");
        GetBeanTest test = (GetBeanTest) bf.getBean("getBeanTest");
        test.showMe();
    }
}
