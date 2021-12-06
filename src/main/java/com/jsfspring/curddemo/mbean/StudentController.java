/**
 * 
 */
/**
 * @author s727953
 *
 */
package com.jsfspring.curddemo.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import com.jsfspring.curddemo.service.MajorService;
import com.jsfspring.curddemo.service.StudentService;
import com.jsfspring.curddemo.uito.MajorUITO;
import com.jsfspring.curddemo.uito.StudentUITO;

@Controller("studController")
@SessionScope
public class StudentController {
	@Autowired
	private StudentService studentService;

	@Autowired
	private MajorService majorService;

	private String actionLabel;
	private StudentUITO studUiTO;
	private List<StudentUITO> studUiToList;

	private List<MajorUITO> majorUiToList;

	/**
	 * add or update new Record in DB
	 * 
	 * @return
	 */
	public void doSaveInfoStud() {
		System.out.println(this.getStudUiTO());
		studentService.doSaveStud(this.getStudUiTO());
		getAllStud();
		this.setStudUiTO(new StudentUITO());
		RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Student Details", "Student Details added/Updated Successfully."));

	}

	/**
	 * Default load all the Student info
	 */
	@PostConstruct
	public void getAllStud() {
		if (!this.getStudUiToList().isEmpty()) {
			this.getStudUiToList().clear();
			this.getMajorUiToList().clear();
		}
		System.out.println(" >>>>>>>>>>>>> " + studentService);
		this.getStudUiToList().addAll(studentService.doFetchAllStud());
		this.getMajorUiToList().addAll(majorService.getAllMajor());
		this.setActionLabel("Add");
	}

	/**
	 * Remove selected Student info
	 * 
	 * @return
	 */

	public void deleteStudent(StudentUITO studentUiTO) {
		studentService.doDeleteStud(studentUiTO);
		getAllStud();
	}

	public void editStudent(StudentUITO studentUiTO) {
		this.setActionLabel("Update");
		BeanUtils.copyProperties(studentUiTO, this.getStudUiTO());
		System.out.println(this.getStudUiTO());
	}

	public StudentUITO getStudUiTO() {
		if (studUiTO == null) {
			studUiTO = new StudentUITO();
		}
		return studUiTO;
	}

	public void setStudUiTO(StudentUITO studUiTO) {
		this.studUiTO = studUiTO;
	}

	public List<StudentUITO> getStudUiToList() {
		if (null == studUiToList) {
			studUiToList = new ArrayList<>();
		}
		return studUiToList;
	}

	public String getActionLabel() {
		return actionLabel;
	}

	public void setActionLabel(String actionLabel) {
		this.actionLabel = actionLabel;
	}

	public List<MajorUITO> getMajorUiToList() {
		if (majorUiToList == null) {
			majorUiToList = new ArrayList<>();
		}
		return majorUiToList;
	}

	public void setMajorUiToList(List<MajorUITO> majorUiToList) {
		this.majorUiToList = majorUiToList;
	}
}