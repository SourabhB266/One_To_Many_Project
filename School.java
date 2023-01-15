package com.ty_one_to_many_uni_School.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class School {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String address;
	@OneToMany
	private List<Student> slist;
	@OneToMany
	private List<Teacher> tlist;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Student> getSlist() {
		return slist;
	}
	public void setSlist(List<Student> slist) {
		this.slist = slist;
	}
	public List<Teacher> getTlist() {
		return tlist;
	}
	public void setTlist(List<Teacher> tlist) {
		this.tlist = tlist;
	}
	@Override
	public String toString() {
		return "School [id=" + id + ", name=" + name + ", address=" + address + ", slist=" + slist + ", tlist=" + tlist
				+ "]";
	}
	
	
	
}
