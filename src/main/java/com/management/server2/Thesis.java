package com.management.server2;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "thesis")
@Entity
@Table(name = "thesis")
public class Thesis implements java.io.Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7913403836244033291L;
	
	private Integer id;
	private Integer studentId;
	private String title;
	private String supervisor;
	private Integer approved;
	

	public Thesis(Integer id, Integer studentId, String title, String supervisor, Integer approved) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.title = title;
		this.supervisor = supervisor;
		this.approved = approved;
	}
	
	public Thesis(){
		
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	
	@XmlElement
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "student_id",unique=true)
	public Integer getStudentId() {
		return studentId;
	}
	
	@XmlElement
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	
	@Column
	public String getTitle() {
		return title;
	}
	@XmlElement
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column
	public String getSupervisor() {
		return supervisor;
	}
	@XmlElement
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	
	@Column
	public Integer getApproved() {
		return approved;
	}
	@XmlElement
	public void setApproved(Integer approved) {
		this.approved = approved;
	}
	@Override
	public String toString() {
		return "Thesis [id=" + id + ", studentId=" + studentId + ", title=" + title + ", supervisor=" + supervisor
				+ ", approved=" + approved + "]";
	}
	
	
	
}
