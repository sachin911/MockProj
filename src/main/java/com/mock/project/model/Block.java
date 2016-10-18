package com.mock.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@Table(name="BLOCK")

@DynamicUpdate(true)
@SelectBeforeUpdate(true)
@XmlRootElement
public class Block {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="BLOCK_ID")
	private Long blockId;
	
	@Column(name="SYMBOL", nullable=false, length=40)
	private String symbol;
	
	@Column(name="SIDE", nullable=false, length=40)
	private String side;
	
	@Column(name="ORDER_TYPE", nullable=false, length=40)
	private String orderType;
	
	@Column(name="QTY_PLACED", nullable=false)
	private long qtyPlaced;
	
	@Column(name="QTY_EXECUTED")
	private long qtyExecuted;
	
	@Column(name="STOP_PRICE")
	private double stopPrice;
	
	@Column(name="LIMIT_PRICE")
	private double limitPrice;
	
	@Column(name="STATUS",nullable=false)
	private String status;
	
	@Column(name="BLOCK_DATE")
	private Date orderDate;
	
	@Column(name="EXECUTED_DATE") 
	private Date executedDate;

	
	public Block() {
		// TODO Auto-generated constructor stub
	}
	
	public Block(String symbol, String side, String orderType, long qtyPlaced, long qtyExecuted, double stopPrice,
			double limitPrice, String status, Date orderDate, Date executedDate) {
		super();
		this.symbol = symbol;
		this.side = side;
		this.orderType = orderType;
		this.qtyPlaced = qtyPlaced;
		this.qtyExecuted = qtyExecuted;
		this.stopPrice = stopPrice;
		this.limitPrice = limitPrice;
		this.status = status;
		this.orderDate = orderDate;
		this.executedDate = executedDate;
	}



	public Long getBlockId() {
		return blockId;
	}

	public void setBlockId(Long blockId) {
		this.blockId = blockId;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public long getQtyPlaced() {
		return qtyPlaced;
	}

	public void setQtyPlaced(long qtyPlaced) {
		this.qtyPlaced = qtyPlaced;
	}

	public long getQtyExecuted() {
		return qtyExecuted;
	}

	public void setQtyExecuted(long qtyExecuted) {
		this.qtyExecuted = qtyExecuted;
	}

	public double getStopPrice() {
		return stopPrice;
	}

	public void setStopPrice(double stopPrice) {
		this.stopPrice = stopPrice;
	}

	public double getLimitPrice() {
		return limitPrice;
	}

	public void setLimitPrice(double limitPrice) {
		this.limitPrice = limitPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getExecutedDate() {
		return executedDate;
	}

	public void setExecutedDate(Date executedDate) {
		this.executedDate = executedDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((blockId == null) ? 0 : blockId.hashCode());
		result = prime * result + ((executedDate == null) ? 0 : executedDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(limitPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + ((orderType == null) ? 0 : orderType.hashCode());
		result = prime * result + (int) (qtyExecuted ^ (qtyExecuted >>> 32));
		result = prime * result + (int) (qtyPlaced ^ (qtyPlaced >>> 32));
		result = prime * result + ((side == null) ? 0 : side.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		temp = Double.doubleToLongBits(stopPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
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
		Block other = (Block) obj;
		if (blockId == null) {
			if (other.blockId != null)
				return false;
		} else if (!blockId.equals(other.blockId))
			return false;
		if (executedDate == null) {
			if (other.executedDate != null)
				return false;
		} else if (!executedDate.equals(other.executedDate))
			return false;
		if (Double.doubleToLongBits(limitPrice) != Double.doubleToLongBits(other.limitPrice))
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderType == null) {
			if (other.orderType != null)
				return false;
		} else if (!orderType.equals(other.orderType))
			return false;
		if (qtyExecuted != other.qtyExecuted)
			return false;
		if (qtyPlaced != other.qtyPlaced)
			return false;
		if (side == null) {
			if (other.side != null)
				return false;
		} else if (!side.equals(other.side))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (Double.doubleToLongBits(stopPrice) != Double.doubleToLongBits(other.stopPrice))
			return false;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Block [blockId=");
		builder.append(blockId);
		builder.append(", symbol=");
		builder.append(symbol);
		builder.append(", side=");
		builder.append(side);
		builder.append(", orderType=");
		builder.append(orderType);
		builder.append(", qtyPlaced=");
		builder.append(qtyPlaced);
		builder.append(", qtyExecuted=");
		builder.append(qtyExecuted);
		builder.append(", stopPrice=");
		builder.append(stopPrice);
		builder.append(", limitPrice=");
		builder.append(limitPrice);
		builder.append(", status=");
		builder.append(status);
		builder.append(", orderDate=");
		builder.append(orderDate);
		builder.append(", executedDate=");
		builder.append(executedDate);
		builder.append("]");
		return builder.toString();
	}
	
	
}
