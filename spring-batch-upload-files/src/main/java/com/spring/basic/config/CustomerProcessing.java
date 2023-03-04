package com.spring.basic.config;

import org.springframework.batch.item.ItemProcessor;

import com.spring.basic.entity.Customer;

/**
 * @author MayilaiMuthu
 * @apiNote 04-03-2023
 *
 */
public class CustomerProcessing implements ItemProcessor<Customer, Customer> {

	@Override
	public Customer process(Customer item) throws Exception {
		// TODO Auto-generated method stub
		return item;
	}

}
