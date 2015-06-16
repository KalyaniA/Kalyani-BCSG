package com.bcsg.bankDetails.dao;

import java.util.List;

import com.bcsg.bankDetails.model.BankDetails;

/**
 * @author Kalyani.A
 */
public interface BankDetailsDao {
	public void addBankDetails(BankDetails bankDetails);  
	  
	 public List<BankDetails> listBankDetails();  
	   
	 public BankDetails getBankDetails(int id);  
}
 