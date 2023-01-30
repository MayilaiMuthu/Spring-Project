package com.spring.basic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author MayilaiMuthu
 * @apiNote 30-01-2023
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Movie {

	private String title;
	private String rating;
	private String overview;
	private String releaseYear;
	private String posterUrl;
	private String votes;
	private String genre;
	private String actor;
	private String director;
	private String language;

}
