package com.bcsg.bankDetails.util;

import java.util.Comparator;

import com.bcsg.bankDetails.model.BankDetails;

public class ExpiryDateComparator implements Comparator<BankDetails>
{

  @Override
  public int compare(BankDetails detail1, BankDetails detail2)
  {
    if (detail1.getExpiryDate() != null && detail2.getExpiryDate() != null)
    {
      return detail1.getExpiryDate().compareTo(detail2.getExpiryDate());
    }
    else
    {
      return 0;
    }
  }
}
