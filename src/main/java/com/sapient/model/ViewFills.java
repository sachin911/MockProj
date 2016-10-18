package com.sapient.model;

import java.io.Serializable;
import java.lang.Integer;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ViewFills
 *
 */
@Entity

public class ViewFills implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer Id;
	@Column(name="BLOCK_ID")
	private long block_Id;
	@Column(name="QTY_EXECUTED")
	private long qtyExecuted;
	@Column(name="EXECUTED_PRICE")
	private double executedPrice;
	@Column(name="REMAINING_QTY")
	private long remainingQty;
	@Column(name="EXECUTED_DATE")
	private Date executedDate;
	private static final long serialVersionUID = 1L;

	public ViewFills() {
		super();
	}   
	public Integer getId() {
		return this.Id;
	}
  
	public long getRemainingQty() {
		return remainingQty;
	}
	public void setRemainingQty(long remainingQty) {
		this.remainingQty = remainingQty;
	}
	public long getBlock_Id() {
		return this.block_Id;
	}
	public void setBlock_Id(long block_Id)
	{
		this.block_Id=block_Id;
	}
	public long getQtyExecuted() {
		return this.qtyExecuted;
	}

	public void setQtyExecuted(long qtyExecuted) {
		this.qtyExecuted = qtyExecuted;
	}   
	public double getExecutedPrice() {
		return this.executedPrice;
	}

	public void setExecutedPrice(double executedPrice) {
		this.executedPrice = executedPrice;
	}   
	public Date getExecutedDate() {
		return this.executedDate;
	}

	public void setExecutedDate(Date executedDate) {
		this.executedDate = executedDate;
	}
	@Override
	public String toString() {
		return "ViewFills [Id=" + Id + ", block_Id=" + block_Id + ", qtyExecuted=" + qtyExecuted + ", executedPrice="
				+ executedPrice + ", executedDate=" + executedDate + "]";
	}
   
}
