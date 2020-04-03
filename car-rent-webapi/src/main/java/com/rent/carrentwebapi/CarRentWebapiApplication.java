package com.rent.carrentwebapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@MapperScan("com.rent.carrentdal.*.**")
@RestController
@ComponentScans({@ComponentScan("com.rent.carrentcommon"),@ComponentScan("com.rent.carrentdal"),
        @ComponentScan("com.rent.carrentservice")})
@EnableTransactionManagement
@EnableConfigurationProperties
public class CarRentWebapiApplication {

    public static void main(String[] args) {

        SpringApplication.run(CarRentWebapiApplication.class, args);
    }

    @RequestMapping(value="/health/test",method = RequestMethod.GET)
    public String healthTest(){
        return "sucess";
    }

}
