package com.mock.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@Table(name="BLOCK")

@DynamicUpdate(true)
@SelectBeforeUpdate(true)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Block {

                @Id
                @GeneratedValue(strategy=GenerationType.SEQUENCE)
                @Column(name="BLOCK_ID")
                //@XmlAnyElement
                private Long block_id;
                
                @Column(name="SYMBOL", nullable=false, length=40)
                private String symbol;
                
                @Column(name="SIDE", nullable=false, length=40)
                private String side;
                
                @Column(name="ORDER_TYPE", nullable=false, length=40)
                private String type;
                
                @Column(name="QTY_PLACED", nullable=false)
                private long total_quantity;
                
                @Column(name="QTY_EXECUTED" , nullable = true)
                private long executed_quantity;
                
                @Column(name="STOP_PRICE", nullable = true)
                private double stop_price;
                
                @Column(name="LIMIT_PRICE", nullable = true)
                private double limit_price;
                
                @Column(name="STATUS",nullable=false, length = 40)
                private String status;
                
                @Column(name="BLOCK_DATE", nullable = true)
                private Date orderDate;
                
                @Column(name="EXECUTED_DATE" , nullable = true)
                @Temporal(TemporalType.DATE)
                private Date executed_date;
                
                @Column(name = "EXECUTED_PRICE", nullable = true)
                private double executed_price;

                
                public Block() {
                                // TODO Auto-generated constructor stub
                }
                
                public Block(String symbol, String side, String orderType, long qtyPlaced, long qtyExecuted, double stopPrice,
                                                double limitPrice, String status, Date orderDate, Date executedDate) {
                                super();
                                this.symbol = symbol;
                                this.side = side;
                                this.type = orderType;
                                this.total_quantity = qtyPlaced;
                                this.executed_quantity = qtyExecuted;
                                this.stop_price = stopPrice;
                                this.limit_price = limitPrice;
                                this.status = status;
                                this.orderDate = orderDate;
                                this.executed_date = executedDate;
                }



//            @XmlElement
                public Long getBlockId() {
                                return block_id;
                }

                public void setBlockId(Long blockId) {
                                this.block_id = blockId;
                }
                
//            @XmlElement
                public String getSymbol() {
                                return symbol;
                }

                public void setSymbol(String symbol) {
                                this.symbol = symbol;
                }
                
//            @XmlElement
                public String getSide() {
                                return side;
                }

                public void setSide(String side) {
                                this.side = side;
                }
                
//            @XmlElement
                public String getOrderType() {
                                return type;
                }

                public void setOrderType(String orderType) {
                                this.type = orderType;
                }
                
//            @XmlElement
                public long getQtyPlaced() {
                                return total_quantity;
                }

                public void setQtyPlaced(long qtyPlaced) {
                                this.total_quantity = qtyPlaced;
                }
                
//            @XmlElement
                public long getQtyExecuted() {
                                return executed_quantity;
                }

                public void setQtyExecuted(long qtyExecuted) {
                                this.executed_quantity = qtyExecuted;
                }
                
//            @XmlElement
                public double getStopPrice() {
                                return stop_price;
                }

                public void setStopPrice(double stopPrice) {
                                this.stop_price = stopPrice;
                }
                
//            @XmlElement
                public double getLimitPrice() {
                                return limit_price;
                }

                public void setLimitPrice(double limitPrice) {
                                this.limit_price = limitPrice;
                }
                
//            @XmlElement
                public String getStatus() {
                                return status;
                }

                public void setStatus(String status) {
                                this.status = status;
                }
                
//            @XmlElement
                public Date getOrderDate() {
                                return orderDate;
                }

                public void setOrderDate(Date orderDate) {
                                this.orderDate = orderDate;
                }
                
//            @XmlElement
                public Date getExecutedDate() {
                                return executed_date;
                }

                public void setExecutedDate(Date executedDate) {
                                this.executed_date = executedDate;
                }

                
                
                @Override
                public int hashCode() {
                                final int prime = 31;
                                int result = 1;
                                result = prime * result + ((block_id == null) ? 0 : block_id.hashCode());
                                result = prime * result + ((executed_date == null) ? 0 : executed_date.hashCode());
                                long temp;
                                temp = Double.doubleToLongBits(limit_price);
                                result = prime * result + (int) (temp ^ (temp >>> 32));
                                result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
                                result = prime * result + ((type == null) ? 0 : type.hashCode());
                                result = prime * result + (int) (executed_quantity ^ (executed_quantity >>> 32));
                                result = prime * result + (int) (total_quantity ^ (total_quantity >>> 32));
                                result = prime * result + ((side == null) ? 0 : side.hashCode());
                                result = prime * result + ((status == null) ? 0 : status.hashCode());
                                temp = Double.doubleToLongBits(stop_price);
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
                                if (!(obj instanceof Block))
                                                return false;
                                Block other = (Block) obj;
                                if (block_id == null) {
                                                if (other.block_id != null)
                                                                return false;
                                } else if (!block_id.equals(other.block_id))
                                                return false;
                                if (executed_date == null) {
                                                if (other.executed_date != null)
                                                                return false;
                                } else if (!executed_date.equals(other.executed_date))
                                                return false;
                                if (Double.doubleToLongBits(limit_price) != Double.doubleToLongBits(other.limit_price))
                                                return false;
                                if (orderDate == null) {
                                                if (other.orderDate != null)
                                                                return false;
                                } else if (!orderDate.equals(other.orderDate))
                                                return false;
                                if (type == null) {
                                                if (other.type != null)
                                                                return false;
                                } else if (!type.equals(other.type))
                                                return false;
                                if (executed_quantity != other.executed_quantity)
                                                return false;
                                if (total_quantity != other.total_quantity)
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
                                
                                return true;
                }

                @Override
                public String toString() {
                                StringBuilder builder = new StringBuilder();
                                builder.append("Block [block_id=");
                                builder.append(block_id);
                                builder.append(", symbol=");
                                builder.append(symbol);
                                builder.append(", side=");
                                builder.append(side);
                                builder.append(", type=");
                                builder.append(type);
                                builder.append(", total_quantity=");
                                builder.append(total_quantity);
                                builder.append(", executed_quantity=");
                                builder.append(executed_quantity);
                                builder.append(", stop_price=");
                                builder.append(stop_price);
                                builder.append(", limit_price=");
                                builder.append(limit_price);
                                builder.append(", status=");
                                builder.append(status);
                                builder.append(", orderDate=");
                                builder.append(orderDate);
                                builder.append(", executed_date=");
                                builder.append(executed_date);
                                builder.append("]");
                                return builder.toString();
                }

                
                
                
                
}
