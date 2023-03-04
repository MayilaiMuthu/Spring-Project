package com.spring.basic.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MayilaiMuthu
 * @apiNote 04-03-2023
 *
 */
@RestController
@RequestMapping("/spring-batch")
public class SpringBatchController {

	public String test() {
		return "test success";
	}

}
