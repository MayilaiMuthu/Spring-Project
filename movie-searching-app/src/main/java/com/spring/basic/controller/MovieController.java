package com.spring.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.basic.service.MovieService;

/**
 * @author MayilaiMuthu
 * @apiNote 30-01-2023
 *
 */

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	MovieService movieService;

	@GetMapping("/check")
	public String homeController() {
		return "moviedetails";
	}

	// http://localhost:7072/api/moviedetails.html?title=key

	@GetMapping("/search")
	public String getMovieByName(@RequestParam String title, Model model) {
		try {
			model.addAttribute("movies", movieService.getMovieByName(title));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "moviedetails";
	}
}