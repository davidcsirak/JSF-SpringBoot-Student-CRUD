/**
 * 
 */
package com.jsfspring.curddemo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

/**
 * @author s727953
 *
 */

@Entity
@Table(name = "STUD_INFO")
@NamedQuery(name = "StudentDTO.findAll", query = "SELECT a FROM StudentDTO a")
public class StudentDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long studId;

	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;

	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Column(name = "EMAIL_ID")
	private String emailId;

	@Column(name = "NEPTUN_ID")
	private String neptunId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MAJOR_ID")
	private MajorDTO majorDTO;

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

	public MajorDTO getMajorDTO() {

		return majorDTO;
	}

	public void setMajorDTO(MajorDTO majorDTO) {
		this.majorDTO = majorDTO;
	}

}
