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
@Table(name = "company")
public class Company{
	@Id
	private int comp_id;
	private String cname;
	private String cemail;
	private String cmob;
	private String JD;
	
	
	@JsonIgnoreProperties(value = {"companies"})
	//@ManyToOne	
	
	public Company() {

	}
	public Company(int comp_id, String cname, String cemail, String cmob, String Jd) {
		super();
		this.comp_id = (Integer) null;
		this.cname = cname;
		this.cemail = cemail;
		this.cmob = cmob;
		this.JD= JD;
		
	}
	
	
	
	public int getComp_id() {
		return comp_id;
	}
	public void setComp_id(int comp_id) {
		this.comp_id = comp_id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public String getCmob() {
		return cmob;
	}
	public void setCmob(String cmob) {
		this.cmob = cmob;
	}
	public String getJD() {
		return JD;
	}
	public void setJD(String jD) {
		JD = jD;
	}
	@Override
	public String toString() {
		return "company [compid=" + comp_id + ", cname=" + cname + ", cemail=" + cemail + ", JD=" + JD
				+ "]";
	}
}