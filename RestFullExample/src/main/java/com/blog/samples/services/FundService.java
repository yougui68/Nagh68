/**
 * 
 */
package com.blog.samples.services;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.blog.samples.domain.Fund;

/**
 * @author yosri-amira
 * 
 */
@Service
public class FundService {

	/**
	 * 
	 */
	public FundService() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return Fund
	 */
	public  Fund getFundById(String id) {

		Fund fund = new Fund();
		fund.setFundId("545");
		fund.setFundDescription("High Risk Equity Fund");
		fund.setBidPrice(26.80);
		fund.setOfferPrice(27.40);
		fund.setLastUpdated(new Date());
		return fund;

	}
	
	/**
	 * @param fund
	 * @return
	 */
	public Fund createFund(Fund fund) {
		Fund newFund=null;
		
		if (null!=fund) {
newFund= new Fund();
newFund.setFundId(fund.getFundId());
newFund.setFundDescription(fund.getFundDescription());
newFund.setBidPrice(fund.getBidPrice());
 newFund.setOfferPrice(fund.getOfferPrice());
 newFund.setLastUpdated(fund.getLastUpdated());
 
		}
		return newFund; 
	}
}
