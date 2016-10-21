package com.sapient.model;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Resource;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@Table(name = "BLOCK")
@DynamicUpdate(true)
@DynamicInsert(true)
@SelectBeforeUpdate
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Block implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BLOCK_ID")
	//@XmlAttribute(name="blockId")
	private Long block_id;
	// private Securities secConfig;

	@Column(name = "SIDE", nullable = false, length = 40)
	private String side;

	@Column(name = "SYMBOL", nullable = false, length = 5)
	private String symbol;

	@Column(name = "TOTAL_QUANTITY", nullable = false)
	private Long total_quantity;

	@Column(name = "TYPE", nullable = false, length = 40)
	private String type;

	@Column(name = "STATUS", nullable = false, length = 40)
	private String status;

	@Column(name = "LIMIT_PRICE", nullable = true)
	private double limit_price;

	@Column(name = "STOP_PRICE", nullable = true)
	private double stop_price;

	@Column(name = "EXECUTED_QUANTITY", nullable = true)
	private Long executed_quantity;

	@Column(name = "EXECUTED_DATE", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date executed_date;

	@Column(name = "EXECUTED_PRICE", nullable = true)
	private double executed_price;

	@Column(name = "BLOCK_DATE", nullable = true )
	@Temporal(TemporalType.DATE)
	private Date orderDate;

	@Column(name = "TRADER_ID", nullable = true)
	private Long traderId;
	
//	@XmlElement
	public Long getId() {
		return block_id;
	}

	public void setId(Long block_id) {
		this.block_id = block_id;
	}
	
//	@XmlElement
	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}
	
//	@XmlElement
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
//	@XmlElement
	public Long getTotal_quantity() {
		return total_quantity;
	}

	public void setTotal_quantity(Long total_quantity) {
		this.total_quantity = total_quantity;
	}
	
//	@XmlElement
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
//	@XmlElement
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
//	@XmlElement
	public double getLimit_price() {
		return limit_price;
	}

	public void setLimit_price(double limit_price) {
		this.limit_price = limit_price;
	}
	
//	@XmlElement
	public double getStop_price() {
		return stop_price;
	}

	public void setStop_price(double stop_price) {
		this.stop_price = stop_price;
	}
	
//	@XmlElement
	public Long getExecuted_quantity() {
		return executed_quantity;
	}

	public void setExecuted_quantity(Long executed_quantity) {
		this.executed_quantity = executed_quantity;
	}
	
//	@XmlElement
	public Date getExecuted_date() {
		return executed_date;
	}

	public void setExecuted_date(Date executed_date) {
		this.executed_date = executed_date;
	}
	
//	@XmlElement
	public double getExecuted_price() {
		return executed_price;
	}

	public void setExecuted_price(double executed_price) {
		this.executed_price = executed_price;
	}
	
//	@XmlElement
	public Date getBlock_date() {
		return orderDate;
	}

	public void setBlock_date(Date block_date) {
		this.orderDate = block_date;
	}
	
//	@XmlElement
	public Long getTraderId() {
		return traderId;
	}

	public void setTraderId(Long traderId) {
		this.traderId = traderId;
	}

	public Block() {
		// TODO Auto-generated constructor stub
	}

	public Block(String side, String symbol, Long total_quantity, String type, String status, double limit_price,
			double stop_price, Long executed_quantity, Date executed_date, double executed_price, Date block_date,
			Long traderId) {
		super();
		this.side = side;
		this.symbol = symbol;
		this.total_quantity = total_quantity;
		this.type = type;
		this.status = status;
		this.limit_price = limit_price;
		this.stop_price = stop_price;
		this.executed_quantity = executed_quantity;
		this.executed_date = executed_date;
		this.executed_price = executed_price;
		this.orderDate = block_date;
		this.traderId = traderId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Block [block_id=");
		builder.append(block_id);
		builder.append(", side=");
		builder.append(side);
		builder.append(", symbol=");
		builder.append(symbol);
		builder.append(", total_quantity=");
		builder.append(total_quantity);
		builder.append(", type=");
		builder.append(type);
		builder.append(", status=");
		builder.append(status);
		builder.append(", limit_price=");
		builder.append(limit_price);
		builder.append(", stop_price=");
		builder.append(stop_price);
		builder.append(", executed_quantity=");
		builder.append(executed_quantity);
		builder.append(", executed_date=");
		builder.append(executed_date);
		builder.append(", executed_price=");
		builder.append(executed_price);
		builder.append(", block_date=");
		builder.append(orderDate);
		builder.append(", traderId=");
		builder.append(traderId);
		builder.append("]");
		return builder.toString();
	}

	public Block(String side, String symbol, Long total_quantity, String type, String status, double limit_price,
			double stop_price, Long executed_quantity, Date executed_date, double executed_price) {
		super();
		this.side = side;
		this.symbol = symbol;
		this.total_quantity = total_quantity;
		this.type = type;
		this.status = status;
		this.limit_price = limit_price;
		this.stop_price = stop_price;
		this.executed_quantity = executed_quantity;
		this.executed_date = executed_date;
		this.executed_price = executed_price;
	}

}
