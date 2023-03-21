package com.spring.basic.config;

import org.springframework.batch.item.ItemProcessor;

import com.spring.basic.entity.Customer;

/**
 * @author MayilaiMuthu
 * @apiNote 21-03-2023
 *
 */
public class CustomerProcessor implements ItemProcessor<Customer,Customer> {

    @Override
    public Customer process(Customer customer) throws Exception {
            return customer;
    }
}
