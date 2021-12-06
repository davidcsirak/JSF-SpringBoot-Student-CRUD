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
import com.jsfspring.curddemo.entity.StudentDTO;
import com.jsfspring.curddemo.repositry.StudentRepo;
import com.jsfspring.curddemo.service.StudentService;
import com.jsfspring.curddemo.uito.MajorUITO;
import com.jsfspring.curddemo.uito.StudentUITO;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepo studentRepo;

	@Override
	@Transactional(readOnly = false)
	public StudentUITO doSaveStud(StudentUITO studentUiTO) {
		StudentDTO dto = UiToToDto(studentUiTO);
		dto = studentRepo.save(dto);
		BeanUtils.copyProperties(dto, studentUiTO);

		dtoToUito(studentUiTO, dto);
		return studentUiTO;
	}

	private void dtoToUito(StudentUITO studentUiTO, StudentDTO dto) {
		MajorUITO uitTO = new MajorUITO();
		BeanUtils.copyProperties(dto.getMajorDTO(), uitTO);
		studentUiTO.setMajorUITO(uitTO);
	}

	private StudentDTO UiToToDto(StudentUITO studentUiTO) {
		StudentDTO dto = new StudentDTO();
		MajorDTO majorDto = new MajorDTO();
		BeanUtils.copyProperties(studentUiTO, dto);
		BeanUtils.copyProperties(studentUiTO.getMajorUITO(), majorDto);
		dto.setMajorDTO(majorDto);
		List<StudentDTO> lst = new ArrayList<>();
		lst.add(dto);
		majorDto.getStudentdtolst().addAll(lst);
		return dto;
	}

	@Override
	public List<StudentUITO> doFetchAllStud() {
		List<StudentDTO> dtoLst = studentRepo.findAll();
		List<StudentUITO> uiTOLst = new ArrayList<>();
		dtoLst.forEach(dto -> {
			StudentUITO tmpUiTO = new StudentUITO();
			System.out.println(dto.getMajorDTO());
			BeanUtils.copyProperties(dto, tmpUiTO);

			dtoToUito(tmpUiTO, dto);
			uiTOLst.add(tmpUiTO);
		});
		return uiTOLst;
	}

	@Override
	public StudentUITO doGetStud(StudentUITO studentUiTO) {
		if (null != studentUiTO.getEmailId()) {
			StudentDTO dto = new StudentDTO();

			BeanUtils.copyProperties(studentUiTO, dto);
			dto = studentRepo.getOne(dto.getStudId());

			BeanUtils.copyProperties(dto, studentUiTO);
		}
		return studentUiTO;
	}

	@Override
	@Transactional
	public void doDeleteStud(StudentUITO studentUiTO) {

		studentRepo.deleteById(studentUiTO.getStudId());
	}

}