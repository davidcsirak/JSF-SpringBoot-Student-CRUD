
package com.jsfspring.curddemo.service;

import java.util.List;

import com.jsfspring.curddemo.uito.MajorUITO;

public interface MajorService {

	List<MajorUITO> getAllMajor();

	MajorUITO getMajor(MajorUITO majorUITO);

}