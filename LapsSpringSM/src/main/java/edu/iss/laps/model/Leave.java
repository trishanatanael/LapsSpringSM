
package edu.iss.laps.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Course class
 *
 * @version $Revision: 1.0
 */
@Entity
@Table(name = "leave_application")
public class Leave {

	public static final String SUBMITTED = "SUBMITTED";
	public static final String APPROVED = "APPROVED";
	public static final String WITHDRAWN = "WITHDRAWN";
	public static final String UPDATED = "UPDATED";
	public static final String REJECTED = "REJECTED";

	/** Attributes for Course **/
	@Id
	@Column(name = "ApplicationID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;
	@Basic
	@NotNull
	@Column(name = "EmployeeID", nullable = false)
	private String employeeId;
	@Temporal(TemporalType.DATE)
	@Column(name = "Submission_Date")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date submissionDate;
	@Temporal(TemporalType.DATE)
	@Column(name = "LeaveFrom")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date leaveFromDate;
	@Temporal(TemporalType.DATE)
	@Column(name = "Leaveto")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date leavetoDate;
	@Column(name = "coursename")
	private String courseName;
	@Column(name = "LeaveType")
	private String leaveType;
	@Column(name = "LeaveReason")
	private String leaveReason;
	@Column(name = "ContactDetails")
	private String contactDetails;
	@Column(name = "WorkDissemenation")
	private String workDissemenation;
	@Column(name = "Status")
	private String status;

	/** Container for CourseApplicationActions **/
	@OneToMany(mappedBy="course", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<LeaveEvent> courseEvent = new ArrayList<LeaveEvent>();

	public Leave() {
	}

	public Leave(int courseId) {
		this.courseId = courseId;
	}

	public Leave(int courseId, String employeeId, String courseName, String organiser, Date fromDate, Date toDate,
			double fees, boolean gstIncluded, String justification, String status, ArrayList<LeaveEvent> events) {
		super();
		this.courseId = courseId;
		this.employeeId = employeeId;
		this.courseName = courseName;
		this.organiser = organiser;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.fees = fees;
		this.gstIncluded = gstIncluded;
		this.justification = justification;
		this.status = status;
		this.courseEvent.addAll(courseEvent);
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getOrganiser() {
		return organiser;
	}

	public void setOrganiser(String organiser) {
		this.organiser = organiser;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public boolean isGstIncluded() {
		return gstIncluded;
	}

	public void setGstIncluded(boolean gstIncluded) {
		this.gstIncluded = gstIncluded;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<CourseEvent> getEvents() {
		 return (new ArrayList<CourseEvent>(courseEvent));
	}

	public void setEvents(ArrayList<CourseEvent> events) {
		this.courseEvent.addAll(courseEvent);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + courseId;
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
		Leave other = (Leave) obj;
		if (courseId != other.courseId)
			return false;
		return true;
	}

	

}