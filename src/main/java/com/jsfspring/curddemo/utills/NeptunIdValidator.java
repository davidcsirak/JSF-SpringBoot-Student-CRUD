package com.jsfspring.curddemo.utills;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FacesValidator("customNeptunIdValidator")
public class NeptunIdValidator implements Validator {

	private static final String NEPTUNID_PATTERN = "[A-Z0-9]{1,6}";

	private Pattern pattern;
	private Matcher matcher;

	public NeptunIdValidator() {
		pattern = Pattern.compile(NEPTUNID_PATTERN);
	}

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		matcher = pattern.matcher(value.toString());
		if (!matcher.matches()) {

			FacesMessage msg = new FacesMessage("NeptunID validation failed.", "Invalid NeptunID format.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);

		}

	}
}
