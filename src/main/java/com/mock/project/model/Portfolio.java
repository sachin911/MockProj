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
@Table(name="PORTFOLIOS")
@DynamicInsert(true)
@DynamicUpdate(true)
@SelectBeforeUpdate
public class Portfolio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PORTFOLIO_ID")
	private Long portfolio_id;
	
	@Column(name="PORTFOLIO_NAME",nullable=false,length=40)
	private String portfolio_name;
	
//	@Column(name="PM_ID")
//	private Long pm_id;

	public Portfolio(String portfolio_name) {
		super();
		this.portfolio_name = portfolio_name;
		System.out.println(portfolio_name);
//		this.pm_id = pm_id;
	}

	public Portfolio() {
		super();
	}

	public Long getPortfolio_id() {
		return portfolio_id;
	}

	public void setPortfolio_id(Long portfolio_id) {
		this.portfolio_id = portfolio_id;
	}

	public String getPortfolio_name() {
		return portfolio_name;
	}

	public void setPortfolio_name(String portfolio_name) {
		this.portfolio_name = portfolio_name;
	}

//	public Long getPm_id() {
//		return pm_id;
//	}
//
//	public void setPm_id(Long pm_id) {
//		this.pm_id = pm_id;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + ((pm_id == null) ? 0 : pm_id.hashCode());
		result = prime * result + ((portfolio_id == null) ? 0 : portfolio_id.hashCode());
		result = prime * result + ((portfolio_name == null) ? 0 : portfolio_name.hashCode());
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
//		if (pm_id == null) {
//			if (other.pm_id != null)
//				return false;
//		} else if (!pm_id.equals(other.pm_id))
//			return false;
		if (portfolio_id == null) {
			if (other.portfolio_id != null)
				return false;
		} else if (!portfolio_id.equals(other.portfolio_id))
			return false;
		if (portfolio_name == null) {
			if (other.portfolio_name != null)
				return false;
		} else if (!portfolio_name.equals(other.portfolio_name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Portfolio [portfolio_id=" + portfolio_id + ", portfolio_name=" + portfolio_name //+ ", pm_id=" + pm_id
				+ "]";
	}

	
	
	
	
}
