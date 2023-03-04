package com.spring.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.basic.entity.Customer;

/**
 * @author MayilaiMuthu
 * @apiNote 04-03-2023
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
