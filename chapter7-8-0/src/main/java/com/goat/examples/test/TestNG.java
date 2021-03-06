package com.goat.examples.test;


import com.goat.chapter001.entity.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;


/**
     * @Description:
     * @author: Goat
     * @Param:
     * @Return:
     * @Date:   2018/12/4

*/
public class TestNG  {


    @Test
    public void test() {
        KieServices kieServices = KieServices.Factory.get(); //  从工厂中获得KieServices实例
        KieContainer kieContainer = kieServices.newKieClasspathContainer(); //从KieServices中获得KieContainer实例，其会加载kmodule.xml文件并load规则文件
        //建立KieSession到规则文件的通信管道
        KieSession kieSession = kieContainer.newKieSession("test"); // 参数对应   <ksession name="helloWorldSession"/>

//        Person person = new Person("duval yang",12);
        Person person = new Person("duval yang",17);
        kieSession.insert(person);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

}
