package com.github.allanfs.balanceapi;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class BalanceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BalanceApiApplication.class, args);
	}

    @PostConstruct
    public void init(){
      // Setting Spring Boot SetTimeZone
	  // https://stackoverflow.com/a/54321163
      TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
}
