package com.example.soapservice.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.soapservice.loaneligibility.Achnolodgement;
import com.example.soapservice.loaneligibility.CustomerRequest;
import com.example.soapservice.service.LoanEligibilityService;

@Endpoint
public class LoanEligibilityIndicatorEndpoint {
	public static final String LOAN_ELIGIBILITY_NAMESPACE = "http://www.example.com/soapservice/loanEligibility";

	private final LoanEligibilityService loanEligibilityService;

	public LoanEligibilityIndicatorEndpoint(LoanEligibilityService loanEligibilityService) {
		super();
		this.loanEligibilityService = loanEligibilityService;
	}

	@PayloadRoot(namespace = LOAN_ELIGIBILITY_NAMESPACE, localPart = "CustomerRequest")
	@ResponsePayload
	public Achnolodgement getLoanStatus(@RequestPayload CustomerRequest customerRequest) {
		return loanEligibilityService.checkLoanEligibility(customerRequest);
	}
}
