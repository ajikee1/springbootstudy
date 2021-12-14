package com.example.springbootstudy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

/*
    The entry point of the Spring Boot Application is the class contains @SpringBootApplication annotation.
    This class should have the main method to run the Spring Boot application.
 */

/*
    Application Runner and Command Line Runner interfaces lets you to execute the code after the Spring Boot application is started.
 */

@SpringBootApplication
public class SpringBootStudyApplication implements ApplicationRunner, CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStudyApplication.class, args);
    }


    /*
        Application Runner is an interface used to execute the code after the Spring Boot application started.
     */
    @Override
    public void run(ApplicationArguments arg0) throws Exception {
        System.out.println("***** Application Runner: Code here runs after the Springboot app starts running *****");
    }


    /*
        Command Line Runner is an interface. It is used to execute the code after the Spring Boot application started
     */
    @Override
    public void run(String... args) throws Exception {
        System.out.println("***** Command-Line Runner: Code here runs after the Springboot app starts running *****");
    }
}
