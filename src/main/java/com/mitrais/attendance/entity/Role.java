package com.mitrais.attendance.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "mst_role")
public class Role {
	@Id
	@GeneratedValue(generator = "role_uuid")
	@GenericGenerator(name = "role_uuid", strategy = "uuid")
	@Column(unique = true)
	private String id;
	@Column(name = "name")
	private String name;

	public Role(String name) {
		this.name = name;
	}

	public Role() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
