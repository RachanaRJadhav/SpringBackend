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
@Table(name = "selection")
public class Selection{
	@Id
	private int stud_sel_id;
	private int std_id;
	private int comp_id;
	private short is_select;
	private short is_applied;
	
	
	@JsonIgnoreProperties(value = {"selections"})
	//@ManyToOne	
	
	public Selection() {

	}
	public Selection(int stud_sel_id, int std_id, int comp_id, short is_select,short is_applied) {
		super();
		this.stud_sel_id = (Integer) null;
		this.std_id=std_id;
		this.comp_id=comp_id;
		this.is_select=is_select;
		this.is_applied=is_applied;
		
	}
	
	
	
	public int getStud_sel_id() {
		return stud_sel_id;
	}
	public void setStud_sel_id(int stud_sel_id) {
		this.stud_sel_id = stud_sel_id;
	}
	public int getStd_id() {
		return std_id;
	}
	public void setStd_id(int std_id) {
		this.std_id = std_id;
	}
	public int getComp_id() {
		return comp_id;
	}
	public void setComp_id(int comp_id) {
		this.comp_id = comp_id;
	}
	public short getIs_select() {
		return is_select;
	}
	public void setIs_select(short is_select) {
		this.is_select = is_select;
	}
	public short getIs_applied() {
		return is_applied;
	}
	public void setIs_applied(short is_applied) {
		this.is_applied = is_applied;
	}
	@Override
	public String toString() {
		return "selection [stud_sel_id=" + stud_sel_id + ", std_id=" + std_id + ", comp_id=" + comp_id + ", is_select=" + is_select
				+ ", is_applied=" + is_applied + "]";
	}
}