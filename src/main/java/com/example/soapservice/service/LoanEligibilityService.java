package com.example.soapservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.soapservice.loaneligibility.Achnolodgement;
import com.example.soapservice.loaneligibility.CustomerRequest;
import com.example.soapservice.loaneligibility.ObjectFactory;

@Service
public class LoanEligibilityService {
	private ObjectFactory loanEligebleObjectFactory = new ObjectFactory();
	public Achnolodgement checkLoanEligibility(CustomerRequest customerRequest) {
		Achnolodgement acknowledgement = loanEligebleObjectFactory.createAchnolodgement();
		List<String> mismatchCriteriaList = acknowledgement.getCriteriaMismatched();
		
		if( customerRequest.getAge() < 30 || customerRequest.getAge() > 60 ) {
			mismatchCriteriaList.add("Person age should between 30 to 60");
		}
		
		if( customerRequest.getYearlyIncome() <= 200000 ) {
			mismatchCriteriaList.add("Mininum income should be more than 2 Lakhs");
		}
		
		if( customerRequest.getCibileScore() <= 500 ) {
			mismatchCriteriaList.add("Less CIBIL score please try after  months");
		}
		
		if(mismatchCriteriaList.size() == 0) {
			acknowledgement.setApprovedAmount(500000);
			acknowledgement.setIsEligible(true);
		}
		return acknowledgement;
	}
}
