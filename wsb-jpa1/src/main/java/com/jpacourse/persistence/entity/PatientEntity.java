package com.jpacourse.persistence.entity;

import com.jpacourse.persistence.enums.Gender;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "PATIENT")
public class PatientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private String telephoneNumber;

	private String email;

	@Column(nullable = false)
	private String patientNumber;

	@Column(nullable = false)
	private LocalDate dateOfBirth;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Gender gender;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId", referencedColumnName = "id")
	private AddressEntity addressEntity;

	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
	private List<VisitEntity> visits;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPatientNumber() {
		return patientNumber;
	}

	public void setPatientNumber(String patientNumber) {
		this.patientNumber = patientNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Gender getGender() {return this.gender;}

	public void setGender(Gender gender) {this.gender = gender;}

	public AddressEntity getAddress() {return this.addressEntity;}

	public void setAddress(AddressEntity addressEntity) {this.addressEntity = addressEntity;}

	public List<VisitEntity> getVisits() {return this.visits;}

	public void setVisits(List<VisitEntity> visits) {this.visits = visits;}
}
