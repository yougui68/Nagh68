/**
 * 
 */
package com.blog.samples.webservice.rest;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.blog.samples.domain.Fund;
import com.blog.samples.services.FundService;

/**
 * @author yosri-amira
 * 
 */
@Controller
public class FundsController {
	@Autowired
	private FundService fundService;
	/**
	 * 
	 */
	@Autowired
	private View jsonView_i;
	/**
	 * @param jsonView_i
	 *            the jsonView_i to set
	 */

	private static Logger log = Logger.getLogger(FundsController.class);

	public void setJsonView_i(View jsonView_i) {
		this.jsonView_i = jsonView_i;
	}

	/**
	 * @param fundService
	 *            the fundService to set
	 */
	public void setFundService(FundService fundService) {
		this.fundService = fundService;
	}

	/**
		 * 
		 */
	private static final String DATA_FIELD = "data";
	/**
		 * 
		 */
	private static final String ERROR_FIELD = "error";

	/**
	 * 
	 */
	public FundsController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param s_p
	 * @return boolean
	 */
	public static boolean isEmpty(String s_p) {
		return (null == s_p) || s_p.trim().length() == 0;
	}

	/**
	 * @param sMessage
	 * @return ModelAndView
	 */
	private ModelAndView createErrorResponse(String sMessage) {
		return new ModelAndView(jsonView_i, ERROR_FIELD, sMessage);
	}

	/**
	 * @param fundid_p
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/rest/funds/{fundId}", method = RequestMethod.GET)
	public ModelAndView getFund(@PathVariable("fundId") String fundid_p) {
		Fund fund = null;
		/* validate fund Id parameter */
		if (isEmpty(fundid_p) && fundid_p.length() < 5) {
			String sMessage = "Error invoking getFund - Invalid fund Id parameter";
			return createErrorResponse(sMessage);

		}

		try {
			fund = fundService.getFundById(fundid_p);
		} catch (Exception e) {
			String sMessage = "Error invoking getFund. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		log.debug("Returing Funds: " + fund.toString());
		return new ModelAndView(jsonView_i, DATA_FIELD, fund);

	}

	/**
	 * @param fund
	 * @param httpServletResponse
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "{/rest/fund}", method = RequestMethod.POST)
	public ModelAndView createFund(@RequestBody Fund fund,
			HttpServletResponse httpServletResponse, WebRequest request) {
		Fund createdFund;
		log.debug("Creating Fund: " + fund.toString());
		try {
			createdFund= fundService.createFund(fund);
		} catch (Exception e) {
			String sMessage = "Error creating Fund. [%1$s]";
			log.debug(sMessage+" "+e.getMessage());
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		httpServletResponse.setStatus(HttpStatus.CREATED.value());
		/* set location of created resource */  
		httpServletResponse.setHeader("Location", request.getContextPath() + "/rest/funds/" + fund.getFundId());
		return new ModelAndView(jsonView_i,DATA_FIELD,createdFund);
	}

}
