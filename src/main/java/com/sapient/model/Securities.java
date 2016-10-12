package com.sapient.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@Table(name="SECURITIES")
@DynamicUpdate(true)
@DynamicInsert(true)
@SelectBeforeUpdate
public class Securities {
	@Id
	@Column(name="SECURITY_SYMBOL")
	private String security_symbol;
	
	@Column(name="SECURITY_NAME",nullable=false,length=40)
	private String security_name;
	
	@Column(name="LAST_TRADE_PRICE")
	private double last_trade_price;
	
	@Column(name="MAX_PRICE_SPREAD")
	private double max_price_spread;
	
	@Column(name="MAX_EXECUTIONS")
	private int max_executions;
	
	@Column(name="MAX_INTERVAL")
	private int max_interval;
	
	@Column(name="PROB_PERCENT")
	private double prob_percent;

	public Securities(String security_symbol, String security_name, double last_trade_price, double max_price_spread,
			int max_executions, int max_interval, double prob_percent) {
		super();
		this.security_symbol = security_symbol;
		this.security_name = security_name;
		this.last_trade_price = last_trade_price;
		this.max_price_spread = max_price_spread;
		this.max_executions = max_executions;
		this.max_interval = max_interval;
		this.prob_percent = prob_percent;
	}

	public Securities() {
		super();
	}

	public String getSecurity_symbol() {
		return security_symbol;
	}

	public void setSecurity_symbol(String security_symbol) {
		this.security_symbol = security_symbol;
	}

	public String getSecurity_name() {
		return security_name;
	}

	public void setSecurity_name(String security_name) {
		this.security_name = security_name;
	}

	public double getLast_trade_price() {
		return last_trade_price;
	}

	public void setLast_trade_price(double last_trade_price) {
		this.last_trade_price = last_trade_price;
	}

	public double getMax_price_spread() {
		return max_price_spread;
	}

	public void setMax_price_spread(double max_price_spread) {
		this.max_price_spread = max_price_spread;
	}

	public int getMax_executions() {
		return max_executions;
	}

	public void setMax_executions(int max_executions) {
		this.max_executions = max_executions;
	}

	public int getMax_interval() {
		return max_interval;
	}

	public void setMax_interval(int max_interval) {
		this.max_interval = max_interval;
	}

	public double getProb_percent() {
		return prob_percent;
	}

	public void setProb_percent(double prob_percent) {
		this.prob_percent = prob_percent;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Securities [security_symbol=");
		builder.append(security_symbol);
		builder.append(", security_name=");
		builder.append(security_name);
		builder.append(", last_trade_price=");
		builder.append(last_trade_price);
		builder.append(", max_price_spread=");
		builder.append(max_price_spread);
		builder.append(", max_executions=");
		builder.append(max_executions);
		builder.append(", max_interval=");
		builder.append(max_interval);
		builder.append(", prob_percent=");
		builder.append(prob_percent);
		builder.append("]");
		return builder.toString();
	}
	
}
