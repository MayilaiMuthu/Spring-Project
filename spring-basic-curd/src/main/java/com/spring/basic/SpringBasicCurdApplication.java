package com.spring.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

/**
 * @author MayilaiMuthu
 * @apiNote 19-01-2023
 *
 */
@SpringBootApplication
@EnableCaching
@EnableEncryptableProperties
@ComponentScan(basePackages = "com.*")
public class SpringBasicCurdApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBasicCurdApplication.class, args);
	}

}
