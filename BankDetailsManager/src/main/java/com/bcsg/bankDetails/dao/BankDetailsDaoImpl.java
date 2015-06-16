package com.bcsg.bankDetails.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bcsg.bankDetails.model.BankDetails;

/**
 * @author Kalyani.A
 */
@Repository("bankDetailsDao")
public class BankDetailsDaoImpl implements BankDetailsDao
{
  @Autowired
  private SessionFactory sessionFactory;

  public void addBankDetails(BankDetails bankDetails)
  {
    sessionFactory.getCurrentSession().saveOrUpdate(bankDetails);
  }

  public List<BankDetails> listBankDetails()
  {
    return (List<BankDetails>) sessionFactory.getCurrentSession().createCriteria(BankDetails.class).list();
  }

  public BankDetails getBankDetails(int bankDetailId)
  {
    return (BankDetails) sessionFactory.getCurrentSession().get(BankDetails.class, bankDetailId);
  }
}
