package com.brijframework.ordering.filters;

import static com.brijframework.ordering.contants.Constants.APP_ID_KEY;
import static com.brijframework.ordering.contants.Constants.BUSINESS_ID_KEY;
import static com.brijframework.ordering.contants.Constants.CUST_APP_ID;
import static com.brijframework.ordering.contants.Constants.OWNER_ID_KEY;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.brijframework.ordering.entities.EOCustBusinessApp;
import com.brijframework.ordering.repository.CustBusinessAppRepository;
import com.brijframework.ordering.util.CommanUtil;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

@Component
@Order(0)
public class TransactionFilter implements Filter {
	
	@Autowired
	private CustBusinessAppRepository custBusinessAppRepository;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String ownerId = req.getHeader(OWNER_ID_KEY);
        String appId = req.getHeader(APP_ID_KEY);
        String businessId = req.getHeader(BUSINESS_ID_KEY);
        MutableHttpServletRequest requestWrapper = new MutableHttpServletRequest(req);
        if(Objects.nonNull(ownerId)&& CommanUtil.isNumeric(ownerId) && Objects.nonNull(businessId) && CommanUtil.isNumeric(businessId) && Objects.nonNull(appId) && CommanUtil.isNumeric(appId)) {
        	EOCustBusinessApp eoCustBusinessApp =custBusinessAppRepository.findByCustIdAndAppIdAndBusinessId(Long.valueOf(ownerId), Long.valueOf(appId),Long.valueOf(businessId)).orElse(new EOCustBusinessApp(Long.valueOf(appId), Long.valueOf(ownerId), Long.valueOf(businessId)));
    		requestWrapper.putHeader(CUST_APP_ID, ""+eoCustBusinessApp.getId());
    		req.setAttribute(CUST_APP_ID, ""+eoCustBusinessApp.getId());
        } else  if(Objects.nonNull(ownerId) && CommanUtil.isNumeric(ownerId) && Objects.nonNull(businessId)&& CommanUtil.isNumeric(businessId)) {
         	EOCustBusinessApp eoCustBusinessApp = custBusinessAppRepository.findByCustIdAndAppIdAndBusinessId(Long.valueOf(ownerId), Long.valueOf(1l),Long.valueOf(businessId)).orElse(new EOCustBusinessApp(Long.valueOf(1l), Long.valueOf(ownerId), Long.valueOf(businessId)));
         	eoCustBusinessApp=custBusinessAppRepository.save(eoCustBusinessApp);
     		requestWrapper.putHeader(CUST_APP_ID, ""+eoCustBusinessApp.getId());
     		req.setAttribute(CUST_APP_ID, ""+eoCustBusinessApp.getId());
         } else  if(Objects.nonNull(ownerId)&& CommanUtil.isNumeric(ownerId)) {
        	List<EOCustBusinessApp> custBusinessAppList = custBusinessAppRepository.findByCustIdAndAppId(Long.valueOf(ownerId), Long.valueOf(1l)).orElse(Arrays.asList(new EOCustBusinessApp(Long.valueOf(1l), Long.valueOf(ownerId), Long.valueOf(1l))));
      		for(EOCustBusinessApp custBusinessApp : custBusinessAppList) {
      			EOCustBusinessApp eoCustBusinessApp=custBusinessAppRepository.save(custBusinessApp);
         		requestWrapper.putHeader(CUST_APP_ID, ""+eoCustBusinessApp.getId());
         		req.setAttribute(CUST_APP_ID, ""+eoCustBusinessApp.getId());
      		}
         }
        chain.doFilter(requestWrapper, response);
    }
}