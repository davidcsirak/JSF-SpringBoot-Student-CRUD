package com.jsfspring.curddemo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "MAJOR_MASTER")
public class MajorDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MAJOR_ID")
	private Long majorId;

	@Column(name = "Major_Name")
	private String majorName;

	@OneToMany(mappedBy = "majorDTO")
	private List<StudentDTO> studentdtolst;

	public Long getMajorId() {
		return majorId;
	}

	public void setMajorId(Long majorId) {
		this.majorId = majorId;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public List<StudentDTO> getStudentdtolst() {
		if (null == studentdtolst) {
			studentdtolst = new ArrayList<>();
		}
		return studentdtolst;
	}

	public void setStudentdtolst(List<StudentDTO> studentdtolst) {
		this.studentdtolst = studentdtolst;
	}
}
