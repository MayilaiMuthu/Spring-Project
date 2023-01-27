package com.spring.basic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author MayilaiMuthu
 * @apiNote 17-01-2023
 *
 */
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "CURD")
public class MCURD {

	@Id
	@NotNull
	@Column(name = "ID", length = 7)
	private Integer id;

	@Column(name = "NAME", length = 25)
	private String name;

	@Column(name = "BALANCE", length = 10)
	private Long balance;

}
