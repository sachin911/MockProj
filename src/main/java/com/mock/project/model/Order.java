package com.mock.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


@Entity
@Table(name="ORDERS")

@DynamicUpdate(true)
@DynamicInsert(true)
@SelectBeforeUpdate(true)
public class Order implements Comparable<Order> {

                @Id
                @GeneratedValue(strategy=GenerationType.AUTO)
                @Column(name="ORDER_ID")
                private Long orderId;
                
                @Column(name="SYMBOL", nullable=false, length=40)
                private String symbol;
                
                @Column(name="SIDE",  length=40)
                private String side;
                
                @Column(name="ORDER_TYPE",  length=40)
                private String orderType;
                
                @Column(name="QUALIFIER",  length=40)
                private String qualifier;
                
                @Column(name="ACCOUNT_TYPE",  length=40)
                private String accountType;
                
                @Column(name="QTY_PLACED")
                private int qtyPlaced;
                
                @Column(name="QTY_EXECUTED")
                private int qtyExecuted;
                
                @Column(name="STOP_PRICE")
                private double stopPrice;
                
                @Column(name="LIMIT_PRICE")
                private double limitPrice;
                
                @Column(name="STATUS")
                private String status;
                
                @Column(name="PRICE")
                private double price;
                
                @Column(name="ORDER_DATE")
                private String orderDate;
                
                @Column(name="EXECUTED_DATE")
                private Date executedDate;

                @Column(name="TRADER_ID")
                private Long traderId;
                
                @Column(name="PM_ID")
                private Long pmId;
                
                @Column(name="BLOCK_ID")
                private Long blockId;
                
                @Column(name="PORTFOLIO_ID")
                private Long portfolioId;

                
                                
                public Order( String symbol, String side, String orderType, String qualifier, String accountType,
                                                int qtyPlaced, int qtyExecuted, double stopPrice, double limitPrice, String status, double price,
                                  Long traderId, Long pmId, Long blockId, Long portfolioId) {
                                super();
                                DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
                                Date dateobj = new Date(); 
                                
                                this.symbol = symbol;
                                this.side = side;
                                this.orderType = orderType;
                                this.qualifier = qualifier;
                                this.accountType = accountType;
                                this.qtyPlaced = qtyPlaced;
                                this.qtyExecuted = qtyExecuted;
                                this.stopPrice = stopPrice;
                                this.limitPrice = limitPrice;
                                this.status = status;
                                this.price = price;
                                this.orderDate = df.format(dateobj);
                                this.executedDate = null;
                                this.traderId = traderId;
                                this.pmId = pmId;
                                this.blockId = blockId;
                                this.portfolioId = portfolioId;
                }






                public Order() {
                                
                                DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
                                Date dateobj = new Date(); 
                                this.orderId =0L;
                                this.symbol = null;
                                this.side = null;
                                this.orderType = null;
                                this.qualifier = null;
                                this.accountType = null;
                                this.qtyPlaced = 0;
                                this.qtyExecuted = 0;
                                this.stopPrice = 0;
                                this.limitPrice = 0;
                                this.status = null;
                                this.price = 0;
                                this.orderDate = df.format(dateobj);
                                this.executedDate = null;
                                this.traderId = null;
                                this.pmId = null;
                                this.blockId = null;
                                this.portfolioId = null;
                }






                @Override
                public int hashCode() {
                                final int prime = 31;
                                int result = 1;
                                result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
                                result = prime * result + ((blockId == null) ? 0 : blockId.hashCode());
                                result = prime * result + ((executedDate == null) ? 0 : executedDate.hashCode());
                                long temp;
                                temp = Double.doubleToLongBits(limitPrice);
                                result = prime * result + (int) (temp ^ (temp >>> 32));
                                result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
                                result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
                                result = prime * result + ((orderType == null) ? 0 : orderType.hashCode());
                                result = prime * result + ((pmId == null) ? 0 : pmId.hashCode());
                                result = prime * result + ((portfolioId == null) ? 0 : portfolioId.hashCode());
                                temp = Double.doubleToLongBits(price);
                                result = prime * result + (int) (temp ^ (temp >>> 32));
                                result = prime * result + qtyExecuted;
                                result = prime * result + qtyPlaced;
                                result = prime * result + ((qualifier == null) ? 0 : qualifier.hashCode());
                                result = prime * result + ((side == null) ? 0 : side.hashCode());
                                result = prime * result + ((status == null) ? 0 : status.hashCode());
                                temp = Double.doubleToLongBits(stopPrice);
                                result = prime * result + (int) (temp ^ (temp >>> 32));
                                result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
                                result = prime * result + ((traderId == null) ? 0 : traderId.hashCode());
                                return result;
                }

                @Override
                public boolean equals(Object obj) {
                                if (this == obj)
                                                return true;
                                if (obj == null)
                                                return false;
                                if (!(obj instanceof Order))
                                                return false;
                                Order other = (Order) obj;
                                if (accountType == null) {
                                                if (other.accountType != null)
                                                                return false;
                                } else if (!accountType.equals(other.accountType))
                                                return false;
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
                                if (orderId == null) {
                                                if (other.orderId != null)
                                                                return false;
                                } else if (!orderId.equals(other.orderId))
                                                return false;
                                if (orderType == null) {
                                                if (other.orderType != null)
                                                                return false;
                                } else if (!orderType.equals(other.orderType))
                                                return false;
                                if (pmId == null) {
                                                if (other.pmId != null)
                                                                return false;
                                } else if (!pmId.equals(other.pmId))
                                                return false;
                                if (portfolioId == null) {
                                                if (other.portfolioId != null)
                                                                return false;
                                } else if (!portfolioId.equals(other.portfolioId))
                                                return false;
                                if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
                                                return false;
                                if (qtyExecuted != other.qtyExecuted)
                                                return false;
                                if (qtyPlaced != other.qtyPlaced)
                                                return false;
                                if (qualifier == null) {
                                                if (other.qualifier != null)
                                                                return false;
                                } else if (!qualifier.equals(other.qualifier))
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
                                if (traderId == null) {
                                                if (other.traderId != null)
                                                                return false;
                                } else if (!traderId.equals(other.traderId))
                                                return false;
                                return true;
                }

                @Override
                public String toString() {
                                StringBuilder builder = new StringBuilder();
                                builder.append("Order [orderId=");
                                builder.append(orderId);
                                builder.append(", symbol=");
                                builder.append(symbol);
                                builder.append(", side=");
                                builder.append(side);
                                builder.append(", orderType=");
                                builder.append(orderType);
                                builder.append(", qualifier=");
                                builder.append(qualifier);
                                builder.append(", accountType=");
                                builder.append(accountType);
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
                                builder.append(", price=");
                                builder.append(price);
                                builder.append(", orderDate=");
                                builder.append(orderDate);
                                builder.append(", executedDate=");
                                builder.append(executedDate);
                                builder.append(", traderId=");
                                builder.append(traderId);
                                builder.append(", pmId=");
                                builder.append(pmId);
                                builder.append(", blockId=");
                                builder.append(blockId);
                                builder.append(", portfolioId=");
                                builder.append(portfolioId);
                                builder.append("]");
                                return builder.toString();
                }

                public Long getOrderId() {
                                return orderId;
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

                public String getQualifier() {
                                return qualifier;
                }

                public void setQualifier(String qualifier) {
                                this.qualifier = qualifier;
                }

                public String getAccountType() {
                                return accountType;
                }

                public void setAccountType(String accountType) {
                                this.accountType = accountType;
                }

                public int getQtyPlaced() {
                                return qtyPlaced;
                }

                public void setQtyPlaced(int qtyPlaced) {
                                this.qtyPlaced = qtyPlaced;
                }

                public int getQtyExecuted() {
                                return qtyExecuted;
                }

                public void setQtyExecuted(int qtyExecuted) {
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

                public double getPrice() {
                                return price;
                }

                public void setPrice(double price) {
                                this.price = price;
                }

                public String getOrderDate() {
                                return orderDate;
                }

                public void setOrderDate(String orderDate) {
                                this.orderDate = orderDate;
                }

                public Date getExecutedDate() {
                                return executedDate;
                }

                public void setExecutedDate(Date executedDate) {
                                this.executedDate = executedDate;
                }

                public Long getTraderId() {
                                return traderId;
                }

                public void setTraderId(Long traderId) {
                                this.traderId = traderId;
                }

                public Long getPmId() {
                                return pmId;
                }

                public void setPmId(Long pmId) {
                                this.pmId = pmId;
                }

                public Long getBlockId() {
                                return blockId;
                }

                public void setBlockId(Long blockId) {
                                this.blockId = blockId;
                }

                public Long getPortfolioId() {
                                return portfolioId;
                }

                public void setPortfolioId(Long portfolioId) {
                                this.portfolioId = portfolioId;
                }






				@Override
				public int compareTo(Order o) {
					String symbol = o.symbol;
					return this.symbol.compareTo(o.getSymbol());
				}
                
                

                
                
                
                
                
                
                
}
