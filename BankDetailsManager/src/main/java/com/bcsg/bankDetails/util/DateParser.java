package com.bcsg.bankDetails.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DateParser
{
  /**
   * Parses given string into a date object.
   * @param dateString date to parse in MMM-yyyy format
   * @return a new date object parsed from a string.
   */
  public static Date parseStringToDate(String dateString)
  {
    if (dateString == null)
    {
      return new Date(0);
    }
    SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy");

    try
    {
      return sdf.parse(dateString);
    }
    catch (ParseException e)
    {
      Logger.getLogger(DateParser.class.getName()).log(Level.WARNING, "parseDateStringToDate: date " + dateString + " could not be parsed", e);
      return new Date(0);
    }
  }
}
