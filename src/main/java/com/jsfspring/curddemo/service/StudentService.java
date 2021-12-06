
package com.jsfspring.curddemo.service;

import java.util.List;

import com.jsfspring.curddemo.uito.StudentUITO;

public interface StudentService {
	StudentUITO doSaveStud(StudentUITO studentUiTO);

	List<StudentUITO> doFetchAllStud();

	StudentUITO doGetStud(StudentUITO studentUiTO);

	void doDeleteStud(StudentUITO studentUiTO);
}