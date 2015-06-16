package com.bcsg.bankDetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bcsg.bankDetails.dao.BankDetailsDao;
import com.bcsg.bankDetails.model.BankDetails;

/**
 * 
 * @author Kalyani.A
 *
 */
@Service("bankDetailsService")  
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)   
class BankDetailsServiceImpl implements BankDetailsService{

	@Autowired  
	private BankDetailsDao bankDetailsDao;  
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)  
	public void addBankDetails(BankDetails bankDetails) {
	  bankDetailsDao.addBankDetails(bankDetails);
	}

	public List<BankDetails> listBankDetails() {
		return bankDetailsDao.listBankDetails();
	}

	public BankDetails getBankDetails(int bankDetailsId) {
		return bankDetailsDao.getBankDetails(bankDetailsId);
	}
}
