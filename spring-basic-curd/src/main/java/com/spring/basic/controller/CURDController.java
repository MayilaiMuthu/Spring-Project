/**
 * 
 */
package com.spring.basic.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.basic.config.APIResponse;
import com.spring.basic.dto.CURD;
import com.spring.basic.service.CURDService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author MayilaiMuthu
 * @apiNote 17-01-2023
 *
 */
@RestController
@RequestMapping("/curd")
@AllArgsConstructor
@Slf4j
public class CURDController {

	private CURDService service;

	@RequestMapping(path = "/health-check", method = RequestMethod.GET)
	public ResponseEntity<APIResponse<String>> healthCheck() {
		log.info("CURD Controller : Method Name is => healthCheck()");
		return new ResponseEntity<>(service.healthCheck(), HttpStatus.OK);
	}

	@GetMapping("/get-all")
	public ResponseEntity<APIResponse<?>> getAll() {
		log.info("CURD Controller : Method Name is => getAll()");
		return new ResponseEntity<>(service.getAll(), HttpStatus.ACCEPTED);
	}

	@GetMapping("/get-by-id/{id}/keys")
	public ResponseEntity<APIResponse<?>> getCURDById(@PathVariable @NotNull Integer id) {
		log.info("CURD Controller : Method Name is => getCURDById()");
		log.debug("Inputs are : " + id);
		return new ResponseEntity<>(service.getCURDById(id), HttpStatus.ACCEPTED);
	}

	@PutMapping("/set-by-id/{id}/keys")
	public ResponseEntity<APIResponse<?>> setCURDById(@PathVariable @NotNull Integer id,
			@RequestParam(required = false) String name) {
		log.info("CURD Controller : Method Name is => setCURDById()");
		log.debug("Inputs are : " + id + ", " + name);
		return new ResponseEntity<>(service.setCURDById(id, name), HttpStatus.IM_USED);
	}

	@DeleteMapping("/delete-by-id/{id}/keys")
	public ResponseEntity<APIResponse<?>> deleteCURDById(@PathVariable @NotNull Integer id) {
		log.info("CURD Controller : Method Name is => deleteCURDById()");
		log.debug("Inputs are : " + id);
		return new ResponseEntity<>(service.deleteCURDById(id), HttpStatus.ALREADY_REPORTED);
	}

	@DeleteMapping("/delete-all")
	public ResponseEntity<APIResponse<?>> deleteAll() {
		log.info("CURD Controller : Method Name is => deleteAll()");
		return new ResponseEntity<>(service.deleteAll(), HttpStatus.ALREADY_REPORTED);
	}

	@PostMapping("/set-by-id")
	public ResponseEntity<APIResponse<?>> saveCURDById(@RequestBody @Valid CURD curd,
			@RequestParam(required = false) Long balance) {
		log.info("CURD Controller : Method Name is => saveCURDById()");
		log.debug("Inputs are : " + curd + ", " + balance);
		return new ResponseEntity<>(service.saveCURDById(curd, balance), HttpStatus.CREATED);
	}

	@PostMapping("/set-all")
	public ResponseEntity<APIResponse<?>> saveAll(@RequestBody List<CURD> curds,
			@RequestParam(required = false) Long balance) {
		log.info("CURD Controller : Method Name is => saveAll()");
		log.debug("Inputs are : " + curds + ", " + balance);
		return new ResponseEntity<>(service.saveAll(curds, balance), HttpStatus.CREATED);
	}

}
