package com.psl.training.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile.FetchOverride;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@Entity
@Table(name = "student")
public class Student {
	@Id
	private int std_id;
	private String sname;
	private String semail;
	private String smob;
	private String clg;
	double cgpa;
	String T_skills;
	
	@JsonIgnoreProperties(value = {"students"})
	//@ManyToOne	
	
	public Student() {

	}
	public Student(int std_id, String sname, String semail, String smob, String clg, double cgpa, String t_skills) {
		super();
		this.std_id = (Integer) null;
		this.sname = sname;
		this.semail = semail;
		this.smob = smob;
		this.clg = clg;
		this.cgpa = cgpa;
		T_skills = t_skills;
	}
	
	public int getStd_id() {
		return std_id;
	}
	public void setStd_id(int std_id) {
		this.std_id = std_id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	public String getSmob() {
		return smob;
	}
	public void setSmob(String smob) {
		this.smob = smob;
	}
	public String getClg() {
		return clg;
	}
	public void setClg(String clg) {
		this.clg = clg;
	}
	public double getCgpa() {
		return cgpa;
	}
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
	public String getT_skills() {
		return T_skills;
	}
	public void setT_skills(String t_skills) {
		T_skills = t_skills;
	}
	
	@Override
	public String toString() {
		return "student [std_id=" + std_id + ", sname=" + sname + ", semail=" + semail + ", clg=" + clg
				+ ", cgpa=" + cgpa + ", T_skills = "+ T_skills +"]";
	}
}