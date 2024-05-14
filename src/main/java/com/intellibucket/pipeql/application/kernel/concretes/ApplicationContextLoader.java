package com.intellibucket.pipeql.application.kernel.concretes;

import com.intellibucket.pipeql.application.kernel.abstracts.AbstractApplicationContextLoader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextLoader implements AbstractApplicationContextLoader {
    public static ApplicationContext APPLICATION_CONTEXT;
    @Override
    public void load(){
        APPLICATION_CONTEXT =  new ClassPathXmlApplicationContext("context/view-clients-application-context.xml");
    }

}
