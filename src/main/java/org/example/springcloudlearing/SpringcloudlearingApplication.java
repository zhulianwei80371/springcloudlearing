package org.example.springcloudlearing;

import com.gitee.sunchenbin.mybatis.actable.manager.handler.StartUpHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages ={"com.gitee.sunchenbin.mybatis.actable.dao.*","org.example.springcloudlearing.mapper"})
//@MapperScan(basePackages ={"org.example.springcloudlearing.mapper"})
@ComponentScan(basePackages = {"com.gitee.sunchenbin.mybatis.actable.manager.*","org.example.springcloudlearing.*"})
@EnableTransactionManagement
public class SpringcloudlearingApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run =  SpringApplication.run(SpringcloudlearingApplication.class, args);
//        // 容器中获取actable的核心处理类
//        StartUpHandler bean =run.getBean(StartUpHandler.class, args);
//        // 手动执行actable的建表方法
//        bean.startHandler();
    }

}
