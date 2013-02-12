/**
 * 
 */
package com.blog.samples.domain;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.blog.samples.web.utils.DateSerializer;

/**
 * @author yosri-amira
 * 
 */
public class Fund {
	private String fundId;
	private String fundDescription;
	private double bidPrice;
	private double offerPrice;
	private Date lastUpdated;
	public Fund() {
		super();
	}
	/**
	 * @return the fundId
	 */
	public String getFundId() {
		return fundId;
	}
	/**
	 * @param fundId the fundId to set
	 */
	public void setFundId(String fundId) {
		this.fundId = fundId;
	}
	/**
	 * @return the fundDescription
	 */
	public String getFundDescription() {
		return fundDescription;
	}
	/**
	 * @param fundDescription the fundDescription to set
	 */
	public void setFundDescription(String fundDescription) {
		this.fundDescription = fundDescription;
	}
	/**
	 * @return the bidPrice
	 */
	public double getBidPrice() {
		return bidPrice;
	}
	/**
	 * @param bidPrice the bidPrice to set
	 */
	public void setBidPrice(double bidPrice) {
		this.bidPrice = bidPrice;
	}
	/**
	 * @return the offerPrice
	 */
	public double getOfferPrice() {
		return offerPrice;
	}
	/**
	 * @param offerPrice the offerPrice to set
	 */
	public void setOfferPrice(double offerPrice) {
		this.offerPrice = offerPrice;
	}
	/**
	 * @return the lastUpdated
	 */
	@JsonSerialize(using=DateSerializer.class)  
	public Date getLastUpdated() {
		return lastUpdated;
	}
	/**
	 * @param lastUpdated the lastUpdated to set
	 */
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	 @Override  
	        public String toString() {  
	             return "Fund [fundId=" + fundId + ", fundDescription="  
	                       + fundDescription + ", bidPrice=" + bidPrice + ", offerPrice="  
	                       + offerPrice + ", lastUpdated=" + lastUpdated + "]";  
	        }  
}
