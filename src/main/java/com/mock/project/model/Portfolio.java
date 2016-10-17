package com.mock.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@Table(name="PORTFOLIO")
@DynamicInsert(true)
@DynamicUpdate(true)
@SelectBeforeUpdate
public class Portfolio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PORTFOLIO_ID")
	private Long portid;
	
	@Column(name="NAME",nullable=false,length=40)
	private String portname;
	
	@Column(name="PM_ID")
	private Long id;

	public Portfolio(long portid, String portname, long id) {
		super();
		this.portid = portid;
		this.portname = portname;
		this.id = id;
	}

	public Portfolio() {
		super();
	}

	public long getPortid() {
		return portid;
	}

	public void setPortid(long portid) {
		this.portid = portid;
	}

	public String getPortname() {
		return portname;
	}

	public void setPortname(String portname) {
		this.portname = portname;
	}

	public long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (portid ^ (portid >>> 32));
		result = prime * result + ((portname == null) ? 0 : portname.hashCode());
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
		Portfolio other = (Portfolio) obj;
		if (id != other.id)
			return false;
		if (portid != other.portid)
			return false;
		if (portname == null) {
			if (other.portname != null)
				return false;
		} else if (!portname.equals(other.portname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Portfolio [portid=" + portid + ", portname=" + portname + ", id=" + id + "]";
	}

	
	
	
}
