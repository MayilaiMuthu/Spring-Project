package com.spring.basic.config;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.basic.entity.Customer;
import com.spring.basic.repository.CustomerRepository;

import java.util.List;

/**
 * @author MayilaiMuthu
 * @apiNote 21-03-2023
 *
 */
@Component
public class CustomerWriter implements ItemWriter<Customer> {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void write(List<? extends Customer> list) throws Exception {
        System.out.println("Thread Name : -"+Thread.currentThread().getName());
        customerRepository.saveAll(list);
    }
}
