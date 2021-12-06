/**
 * 
 */
package com.jsfspring.curddemo.uito;

import java.io.Serializable;

/**
 * @author s727953
 *
 */
public class StudentUITO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4840260415183676656L;
	private Long studId;
	private String firstName;
	private String lastName;
	private String password;
	private String emailId;
	private String neptunId;
	private MajorUITO majorUITO;

	public Long getStudId() {
		return studId;
	}

	public void setStudId(Long studId) {
		this.studId = studId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getNeptunId() {
		return neptunId;
	}

	public void setNeptunId(String neptunId) {
		this.neptunId = neptunId;
	}

	public MajorUITO getMajorUITO() {
		return majorUITO;
	}

	public void setMajorUITO(MajorUITO majorUITO) {
		this.majorUITO = majorUITO;
	}

	@Override
	public String toString() {
		return "StudentUITO [studId=" + studId + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password + ", emailId=" + emailId + ", neptunId=" + neptunId + ", majorUITO=" + majorUITO + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
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
		StudentUITO other = (StudentUITO) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		return true;
	}

}
