package com.spring.basic.dto;

import jakarta.validation.constraints.NotBlank;
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
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CURD {
	
	@NotNull(message = "Id Should not be NULL")
	private Integer id;
	
	@NotBlank(message = "Name Should not be Empty")
	private String name;

}
