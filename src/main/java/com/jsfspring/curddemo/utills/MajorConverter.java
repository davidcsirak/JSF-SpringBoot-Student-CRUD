package com.jsfspring.curddemo.utills;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsfspring.curddemo.service.MajorService;
import com.jsfspring.curddemo.uito.MajorUITO;

@Service
public class MajorConverter implements Converter {

	@Autowired
	private MajorService majorService;

	private static final Logger LOG = LoggerFactory.getLogger(MajorConverter.class.getName());

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
		LOG.info("getAsObject: " + majorService);

		MajorUITO majorUITO = new MajorUITO();
		majorUITO.setMajorName(string);
		majorUITO = majorService.getMajor(majorUITO);
		System.out.println(majorUITO.toString());
		return majorUITO;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
		LOG.info("getAsString obj class: " + obj.getClass().getName());
		if (obj instanceof MajorUITO) {
			MajorUITO major = (MajorUITO) obj;
			LOG.info("getAsString def name: " + major.getMajorName());
			return major.getMajorName();
		} else {
			StringBuilder sbError = new StringBuilder("The object of class ");
			sbError.append(obj.getClass().getName()).append(" is not of MajorUITO");
			throw new ClassCastException(sbError.toString());
		}
	}
}