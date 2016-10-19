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
	
	@Column(name="SIDE", nullable=false, length=40)
	private String side;
	
	@Column(name="SYMBOL", nullable=false, length=40)
	private String symbol;
	
	@Column(name="TOTAL_QUANTITY", nullable=false)
	private long total_quantity;
	
	@Column(name="TYPE", nullable=false, length=40)
	private String type;
	
	@Column(name="STATUS",nullable=false)
	private String status;
	
	@Column(name="LIMIT_PRICE")
	private double limit_price;
	
	@Column(name="STOP_PRICE")
	private double stop_price;
	
	@Column(name="EXECUTED_QUANTITY")
	private long executed_quantity;
	
	@Column(name="EXECUTED_DATE") 
	private Date executed_date;
	
	@Column(name="EXECUTED_PRICE") 
	private double executed_price;
	
	@Column(name="BLOCK_DATE")
	private Date block_date;
	
	@Column(name="TRADER_ID")
	private Long traderId;


	
	public Block() {
		// TODO Auto-generated constructor stub
	}



	public Block(String side, String symbol, long total_quantity, String type, String status, double limit_price,
			double stop_price, long executed_quantity, Date executed_date, double executed_price, Date block_date,
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
		this.block_date = block_date;
		this.traderId = traderId;
	}



	public Long getBlockId() {
		return blockId;
	}



	public void setBlockId(Long blockId) {
		this.blockId = blockId;
	}



	public String getSide() {
		return side;
	}



	public void setSide(String side) {
		this.side = side;
	}



	public String getSymbol() {
		return symbol;
	}



	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}



	public long getTotal_quantity() {
		return total_quantity;
	}



	public void setTotal_quantity(long total_quantity) {
		this.total_quantity = total_quantity;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public double getLimit_price() {
		return limit_price;
	}



	public void setLimit_price(double limit_price) {
		this.limit_price = limit_price;
	}



	public double getStop_price() {
		return stop_price;
	}



	public void setStop_price(double stop_price) {
		this.stop_price = stop_price;
	}



	public long getExecuted_quantity() {
		return executed_quantity;
	}



	public void setExecuted_quantity(long executed_quantity) {
		this.executed_quantity = executed_quantity;
	}



	public Date getExecuted_date() {
		return executed_date;
	}



	public void setExecuted_date(Date executed_date) {
		this.executed_date = executed_date;
	}



	public double getExecuted_price() {
		return executed_price;
	}



	public void setExecuted_price(double executed_price) {
		this.executed_price = executed_price;
	}



	public Date getBlock_date() {
		return block_date;
	}



	public void setBlock_date(Date block_date) {
		this.block_date = block_date;
	}



	public Long getTraderId() {
		return traderId;
	}



	public void setTraderId(Long traderId) {
		this.traderId = traderId;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((blockId == null) ? 0 : blockId.hashCode());
		result = prime * result + ((block_date == null) ? 0 : block_date.hashCode());
		result = prime * result + ((executed_date == null) ? 0 : executed_date.hashCode());
		long temp;
		temp = Double.doubleToLongBits(executed_price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (executed_quantity ^ (executed_quantity >>> 32));
		temp = Double.doubleToLongBits(limit_price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((side == null) ? 0 : side.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		temp = Double.doubleToLongBits(stop_price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		result = prime * result + (int) (total_quantity ^ (total_quantity >>> 32));
		result = prime * result + ((traderId == null) ? 0 : traderId.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (block_date == null) {
			if (other.block_date != null)
				return false;
		} else if (!block_date.equals(other.block_date))
			return false;
		if (executed_date == null) {
			if (other.executed_date != null)
				return false;
		} else if (!executed_date.equals(other.executed_date))
			return false;
		if (Double.doubleToLongBits(executed_price) != Double.doubleToLongBits(other.executed_price))
			return false;
		if (executed_quantity != other.executed_quantity)
			return false;
		if (Double.doubleToLongBits(limit_price) != Double.doubleToLongBits(other.limit_price))
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
		if (Double.doubleToLongBits(stop_price) != Double.doubleToLongBits(other.stop_price))
			return false;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		if (total_quantity != other.total_quantity)
			return false;
		if (traderId == null) {
			if (other.traderId != null)
				return false;
		} else if (!traderId.equals(other.traderId))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Block [blockId=");
		builder.append(blockId);
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
		builder.append(block_date);
		builder.append(", traderId=");
		builder.append(traderId);
		builder.append("]");
		return builder.toString();
	}

	
}


   