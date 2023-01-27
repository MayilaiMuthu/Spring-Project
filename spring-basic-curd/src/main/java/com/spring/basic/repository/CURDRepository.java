package com.spring.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.basic.entity.MCURD;

/**
 * @author MayilaiMuthu
 * @apiNote 17-01-2023
 *
 */
public interface CURDRepository extends JpaRepository<MCURD, Integer> {

}
