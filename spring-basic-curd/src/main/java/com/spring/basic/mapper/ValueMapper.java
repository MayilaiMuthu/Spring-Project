package com.spring.basic.mapper;

import java.util.ArrayList;
import java.util.List;

import com.spring.basic.dto.CURD;
import com.spring.basic.entity.MCURD;

/**
 * @author MayilaiMuthu
 * @apiNote 19-01-2023
 *
 */
public class ValueMapper {

	public static CURD toCURDDTO(MCURD mcurd) {
		CURD curd = new CURD();
		curd.setId(mcurd.getId());
		curd.setName(mcurd.getName());
		return curd;
	}

	public static List<CURD> toCURDDTOs(List<MCURD> mcurds) {
		List<CURD> curds = new ArrayList<>();
		mcurds.stream().forEach(mcurd -> {
			CURD curd = new CURD();
			curd.setId(mcurd.getId());
			curd.setName(mcurd.getName());
			curds.add(curd);
		});
		return curds;
	}

}
