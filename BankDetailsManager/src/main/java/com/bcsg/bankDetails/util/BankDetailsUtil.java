package com.bcsg.bankDetails.util;


public class BankDetailsUtil
{
  public static String maskCard(String cardNumber)
  {
    String mask = "dddd";
    if (cardNumber == null)
    {
      return "";
    }
    char[] cardNum = cardNumber.toCharArray();
    for (int i = 0; i < cardNum.length; i++)
    {
      if (i < mask.length())
      {
        if (mask.charAt(i) != 'd')
        {
          cardNum = replaceChar(cardNum, i);
        }
      }
      else
      {
        cardNum = replaceChar(cardNum, i);
      }
    }
    return String.valueOf(cardNum);
  }

  public static char[] replaceChar(char[] cardNum, int index)
  {
    if (cardNum[index] != '-')
    {
      cardNum[index] = 'x';
    }
    return cardNum;
  }
}
