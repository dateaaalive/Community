package com.example.community;

//import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CommunityApplication {

//    @PostConstruct
//    public void init(){
//        System.setProperty("es.set.netty.runtime.available.processors", "false");
//    }

    public static void main(String[] args) {
        SpringApplication.run(CommunityApplication.class, args);
    }

}
