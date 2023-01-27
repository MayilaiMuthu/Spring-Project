package com.spring.basic.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.basic.config.APIResponse;
import com.spring.basic.config.ApplicationConstants;
import com.spring.basic.config.Message;
import com.spring.basic.dto.CURD;
import com.spring.basic.entity.MCURD;
import com.spring.basic.mapper.ValueMapper;
import com.spring.basic.repository.CURDRepository;

/**
 * @author MayilaiMuthu
 * @apiNote 17-01-2023
 *
 */
@Service
public class CURDService {

	@Autowired
	private CURDRepository repository;

	@Autowired
	private Message message;

	private Logger log = LoggerFactory.getLogger(CURDService.class);

	public APIResponse<String> healthCheck() {
		log.info("CURD Service : Method Name is => healthCheck() :: Execution Started..................");
		// Builder Design Pattern
		APIResponse<String> response = APIResponse.<String>builder().results("GOOD")
				.status(ApplicationConstants.MESSAGE_SUCCESS).build();
		log.info("The Output is : " + response.getResults());
		log.info("CURD Service : Method Name is => healthCheck() :: Execution Ended....................");
		return response;
	}

//	@Cacheable(value = "curds")
	public APIResponse<?> getAll() {
		log.info("CURD Service : Method Name is => getAll() :: Execution Started............");
		APIResponse<?> response = new APIResponse<>();
		List<MCURD> mcurd = repository.findAll();
		if (!mcurd.isEmpty()) {
			response = APIResponse.builder().results(ValueMapper.toCURDDTOs(mcurd))
					.status(ApplicationConstants.MESSAGE_SUCCESS).build();
			log.info("The Output is " + ": " + response.getResults());
		} else {
			response = APIResponse.builder().results("Table is Empty").status(ApplicationConstants.MESSAGE_FAIL)
					.build();
			log.error("The Output is " + ": " + response.getResults());
		}
		log.info("CURD Service : Method Name is => getAll() :: Execution Ended.............");
		return response;
	}

	public APIResponse<?> getCURDById(Integer id) {
		log.info("CURD Service : Method Name is => getCURDById() :: Execution Started......................");
		log.debug("Inputs are : " + id);
		APIResponse<?> response = new APIResponse<>();
		if (id != null) {
			MCURD mcurd = repository.findById(id).orElse(null);
			if (mcurd != null) {
				response = APIResponse.builder().results(ValueMapper.toCURDDTO(mcurd))
						.status(ApplicationConstants.MESSAGE_SUCCESS).build();
				log.info("The Output is " + ": " + response.getResults());
			} else {
				response = APIResponse.builder().results("Invalid Parameter ID : " + id)
						.status(ApplicationConstants.MESSAGE_FAIL).build();
				log.error("The Output is " + ": " + response.getResults());
			}
		} else {
			response = APIResponse.builder().results("ID is NULL").status(ApplicationConstants.MESSAGE_ERROR).build();
			log.error("The Output is " + ": " + response.getResults());
		}
		log.info(
				"CURD Service : Method Name is => getCURDById() :: Execution :: Execution Ended......................");
		return response;
	}

	public APIResponse<?> setCURDById(Integer id, String name) {
		log.info("CURD Service : Method Name is => setCURDById() :: Execution Started...............");
		log.debug("Inputs are : " + id + ", " + name);
		APIResponse<?> response = new APIResponse<>();
		if (id != null) {
			MCURD mcurd = repository.findById(id).orElse(null);
			if (mcurd != null) {
				mcurd.setName(name);
				response = APIResponse.builder().results(ValueMapper.toCURDDTO(repository.save(mcurd)))
						.status(ApplicationConstants.MESSAGE_SUCCESS).build();
				repository.flush();
				log.info("The Output is " + ": " + response.getResults());
			} else {
				response = APIResponse.builder().results("Invalid Parameter ID : " + id)
						.status(ApplicationConstants.MESSAGE_FAIL).build();
				log.error("The Output is " + ": " + response.getResults());
			}
		} else {
			response = APIResponse.builder().results("ID is NULL").status(ApplicationConstants.MESSAGE_ERROR).build();
			log.error("The Output is " + ": " + response.getResults());
		}
		log.info("CURD Service : Method Name is => setCURDById() :: Execution Ended...............");
		return response;
	}

	public APIResponse<?> deleteCURDById(Integer id) {
		log.info("CURD Service : Method Name is => deleteCURDById() :: Execution Started....................");
		log.debug("Inputs are : " + id);
		APIResponse<?> response = new APIResponse<>();
		if (id != null) {
			MCURD mcurd = repository.findById(id).orElse(null);
			if (mcurd != null) {
				repository.deleteById(id);
				repository.flush();
				response = APIResponse.builder().results(ValueMapper.toCURDDTO(mcurd))
						.status(ApplicationConstants.MESSAGE_SUCCESS).build();
				log.info("The Output is " + ": " + response.getResults());
			} else {
				response = APIResponse.builder().results("Invalid Parameter ID : " + id)
						.status(ApplicationConstants.MESSAGE_FAIL).build();
				log.error("The Output is " + ": " + response.getResults());
			}
		} else {
			response = APIResponse.builder().results("ID is NULL").status(ApplicationConstants.MESSAGE_ERROR).build();
			log.error("The Output is " + ": " + response.getResults());
		}
		log.info("CURD Service : Method Name is => deleteCURDById() :: Execution Ended....................");
		return response;
	}

	public APIResponse<?> deleteAll() {
		log.info("CURD Service : Method Name is => deleteAll() :: Execution Started...........................");
		APIResponse<?> response = new APIResponse<>();
		List<MCURD> mcurd = repository.findAll();
		if (!mcurd.isEmpty()) {
			repository.deleteAll();
			repository.flush();
			response = APIResponse.builder().results(ValueMapper.toCURDDTOs(mcurd))
					.status(ApplicationConstants.MESSAGE_SUCCESS).build();
			log.info("The Output is " + ": " + response.getResults());
		} else {
			response = APIResponse.builder().results("Table is Empty").status(ApplicationConstants.MESSAGE_FAIL)
					.build();
			log.error("The Output is " + ": " + response.getResults());
		}
		log.info("CURD Service : Method Name is => deleteAll() :: Execution Ended...........................");
		return response;
	}

	public APIResponse<?> saveCURDById(CURD curd, Long balance) {
		log.info("CURD Service : Method Name is => saveCURDById() :: Execution Started...........................");
		log.debug("Inputs are : " + curd + ", " + balance);
		APIResponse<?> response = new APIResponse<>();
		if (curd != null) {
			if (curd.getId() != null) {
				MCURD mcurd = repository.findById(curd.getId()).orElse(null);
				if (mcurd == null) {
					MCURD m = MCURD.build(curd.getId(), curd.getName(), balance);
					response = APIResponse.builder().results(ValueMapper.toCURDDTO(repository.save(m)))
							.status(ApplicationConstants.MESSAGE_SUCCESS).build();
					repository.flush();
					log.info("The Output is " + ": " + response.getResults());
				} else {
					response = APIResponse.builder().results("Already Found : " + curd.getId())
							.status(ApplicationConstants.MESSAGE_FAIL).build();
					log.error("The Output is " + ": " + response.getResults());
				}
			} else {
				response = APIResponse.builder().results("CURD ID is NULL").status(ApplicationConstants.MESSAGE_ERROR)
						.build();
				log.error("The Output is " + ": " + response.getResults());
			}
		} else {
			response = APIResponse.builder().results("CURD is NULL").status(ApplicationConstants.MESSAGE_ERROR).build();
			log.error("The Output is " + ": " + response.getResults());
		}
		log.info("CURD Service : Method Name is => saveCURDById() :: Execution Ended...........................");
		return response;
	}

	public APIResponse<?> saveAll(List<CURD> curds, Long balance) {
		log.info("CURD Service : Method Name is => saveAll() :: Execution Started................");
		log.debug("Inputs are : " + curds + ", " + balance);
		APIResponse<?> response = new APIResponse<>();
		if (curds != null) {
			if (!curds.isEmpty()) {
				message.setOutput("Saved CURDS are ");
				List<MCURD> list = new ArrayList<>();
				curds.stream().forEach(a -> {
					if (a.getId() != null) {
						MCURD mcurd = repository.findById(a.getId()).orElse(null);
						if (mcurd == null) {
							MCURD m = MCURD.build(a.getId(), a.getName(), balance);
							list.add(m);
							message.setOutput(message.getOutput() + ": " + a);
						} else {
							message.setOutput(message.getOutput() + ": " + "Already Found : " + a.getId());
						}
					} else {
						message.setOutput(message.getOutput() + ": " + "CURD ID is NULL");
					}
				});
				if (!list.isEmpty()) {
					repository.saveAll(list);
					repository.flush();
					response = APIResponse.builder().results(message.getOutput())
							.status(ApplicationConstants.MESSAGE_SUCCESS).build();
					log.info("The Output is " + ": " + response.getResults());
				} else {
					response = APIResponse.builder().results(message.getOutput())
							.status(ApplicationConstants.MESSAGE_FAIL).build();
					log.error("The Output is " + ": " + response.getResults());
				}
			} else {
				response = APIResponse.builder().results("List is Empty").status(ApplicationConstants.MESSAGE_ERROR)
						.build();
				log.error("The Output is " + ": " + response.getResults());
			}
		} else {
			response = APIResponse.builder().results("List is NULL").status(ApplicationConstants.MESSAGE_ERROR).build();
			log.error("The Output is " + ": " + response.getResults());
		}
		log.info("CURD Service : Method Name is => saveAll() :: Execution Ended................");
		return response;
	}

}
