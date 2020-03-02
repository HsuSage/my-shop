package com.xu.my.shop.commons.context;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class SpringContext implements ApplicationContextAware, DisposableBean {
    private static final Logger logger = LoggerFactory.getLogger(SpringContext.class);

    private static ApplicationContext applicationContext;

    /**
     * 使用ApplicationContext，根据beanId获取实例
     * @param beanId
     * @return T
     * @author Xu
     * @date 2020/2/29 11:02
     */
    public static <T> T getBean(String beanId) {
        assertContextInjected();
        return (T) applicationContext.getBean(beanId);
    }

    /**
     * 使用ApplicationContext，根据clazz获取实例
     * @param clazz
     * @return T
     * @author Xu
     * @date 2020/2/29 11:20
     */
    public static <T> T getBean(Class<T> clazz) {
        assertContextInjected();
        return (T) applicationContext.getBean(clazz);
    }

    @Override
    public void destroy() throws Exception {
        logger.debug("清空ApplicationContext");
        applicationContext = null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContext.applicationContext = applicationContext;
    }

    private static void assertContextInjected() {
        // expression为假时，抛出异常。expression为真，正常运行
        Validate.validState(applicationContext != null,
                "还没有在spring-context.xml中配置SpringContext对象");
    }
}
