package com.bcsg.bankDetails.bean;

import java.util.Date;

/**
 * @author Kalyani.A
 */
public class BankDetailsBean {
  private Integer id;  
  
  private String bank;  
    
  private String cardNumber;  
  
  private String expiryDate;

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public String getBank()
  {
    return bank;
  }

  public void setBank(String bank)
  {
    this.bank = bank;
  }

  public String getCardNumber()
  {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber)
  {
    this.cardNumber = cardNumber;
  }

  public String getExpiryDate()
  {
    return expiryDate;
  }

  public void setExpiryDate(String expiryDate)
  {
    this.expiryDate = expiryDate;
  }
}
