package com.bcsg.bankDetails.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;  
import javax.persistence.Id;  
import javax.persistence.Table;

/**
 * 
 * @author Kalyani.A
 *
 */
@Entity 
@Table(name="BankDetails") 
public class BankDetails implements Serializable{

 
	private static final long serialVersionUID = 1L;

	 @Id  
	 @GeneratedValue(strategy=GenerationType.AUTO)  
	 @Column(name = "Id")  
	 private Integer id;  
	   
	 @Column(name="BANKNAME")  
	 private String bank;  
	   
	 @Column(name="CardNumber")  
	 private String cardNumber;  
	 
	 @Column(name="ExpiryDate")  
	 private Date expiryDate;

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

  public Date getExpiryDate()
  {
    return expiryDate;
  }

  public void setExpiryDate(Date expiryDate)
  {
    this.expiryDate = expiryDate;
  }  
}
