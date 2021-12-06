package com.jsfspring.curddemo.uito;

import java.io.Serializable;
import java.util.List;

public class MajorUITO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long majorId;
	private String majorName;

	private List<StudentUITO> studentUITOLst;

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

	public List<StudentUITO> getStudentUITOLst() {
		return studentUITOLst;
	}

	public void setStudentUITOLst(List<StudentUITO> studentUITOLst) {
		this.studentUITOLst = studentUITOLst;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((majorId == null) ? 0 : majorId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MajorUITO other = (MajorUITO) obj;
		if (majorId == null) {
			if (other.majorId != null)
				return false;
		} else if (!majorId.equals(other.majorId))
			return false;
		return true;
	}

}
