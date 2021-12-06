/**
 * 
 */
/**
 * @author s727953
 *
 */
package com.jsfspring.curddemo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsfspring.curddemo.entity.MajorDTO;
import com.jsfspring.curddemo.repositry.MajorRepo;
import com.jsfspring.curddemo.service.MajorService;
import com.jsfspring.curddemo.uito.MajorUITO;
import com.jsfspring.curddemo.uito.StudentUITO;

@Service
@Transactional
public class MajorServiceImpl implements MajorService {
	@Autowired
	private MajorRepo majorRepo;

	@Override
	public List<MajorUITO> getAllMajor() {
		List<MajorUITO> majorUITOLst = new ArrayList<>();
		List<MajorDTO> majorDTOLst = majorRepo.findAll();

		majorDTOLst.forEach(dto -> {
			MajorUITO tmpUiTO = new MajorUITO();

			BeanUtils.copyProperties(dto, tmpUiTO);
			majorUITOLst.add(tmpUiTO);
		});

		return majorUITOLst;
	}

	@Override
	public MajorUITO getMajor(MajorUITO majorUITO) {
		System.out.println(">>>>> "+majorUITO.getMajorName());
		MajorDTO dto = majorRepo.findTitleByMajorName(majorUITO.getMajorName());
		MajorUITO uito = new MajorUITO();

		BeanUtils.copyProperties(dto, uito);
		return uito;
	}
}