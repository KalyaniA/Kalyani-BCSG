package com.bcsg.bankDetails.service;

import java.util.List;

import com.bcsg.bankDetails.model.BankDetails;

/**
 * 
 * @author Kalyani.A
 *
 */
public interface BankDetailsService {

	 public void addBankDetails(BankDetails bankDetails);  
	  
	 public List<BankDetails> listBankDetails();  
	   
	 public BankDetails getBankDetails(int bankDetailId);  
	   
}
