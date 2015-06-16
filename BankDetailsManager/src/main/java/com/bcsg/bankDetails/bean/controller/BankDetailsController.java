package com.bcsg.bankDetails.bean.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bcsg.bankDetails.bean.BankDetailsBean;
import com.bcsg.bankDetails.model.BankDetails;
import com.bcsg.bankDetails.service.BankDetailsService;
import com.bcsg.bankDetails.util.BankDetailsUtil;
import com.bcsg.bankDetails.util.ExpiryDateComparator;

/**
 * @author Kalyani.A
 */
@Controller
public class BankDetailsController
{
  @Autowired
  private BankDetailsService bankDetailsService;

  @RequestMapping(value = "/bankDetails", method = RequestMethod.GET)
  public ModelAndView listBankDetails()
  {
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("bankDetails", prepareListofBean(bankDetailsService.listBankDetails()));
    return new ModelAndView("bankDetailsList", model);
  }

  @RequestMapping(value = "/index", method = RequestMethod.GET)
  public ModelAndView welcome()
  {
    return new ModelAndView("index");
  }

  @RequestMapping(value = "/add", method = RequestMethod.GET)
  public ModelAndView addBankDetails(@ModelAttribute("command") BankDetailsBean bankDetailsBean, BindingResult result)
  {
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("bankDetails", prepareListofBean(bankDetailsService.listBankDetails()));
    return new ModelAndView("addBankDetails", model);
  }

  @RequestMapping(value = "/edit", method = RequestMethod.GET)
  public ModelAndView editEmployee(@ModelAttribute("command") BankDetailsBean bankDetailsBean, BindingResult result)
  {
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("bankDetail", prepareBankDetailsBean(bankDetailsService.getBankDetails(bankDetailsBean.getId())));
    model.put("bankDetails", prepareListofBean(bankDetailsService.listBankDetails()));
    return new ModelAndView("addBankDetails", model);
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public ModelAndView saveBankDetails(@ModelAttribute("command") BankDetailsBean bankDetailBean, BindingResult result)
  {
    BankDetails bankDetails = prepareModel(bankDetailBean);
    bankDetailsService.addBankDetails(bankDetails);
    return new ModelAndView("redirect:/index.html");
  }

  private BankDetails prepareModel(BankDetailsBean bankDetailBean)
  {
    BankDetails bankDetails = new BankDetails();
    bankDetails.setId(bankDetailBean.getId());
    bankDetails.setBank(bankDetailBean.getBank());
    bankDetails.setCardNumber(bankDetailBean.getCardNumber());
    SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy");
    Date date;
    try
    {
      date = sdf.parse(bankDetailBean.getExpiryDate());
      bankDetails.setExpiryDate(date);
    }
    catch (ParseException e)
    {
      e.printStackTrace();
    }
    bankDetailBean.setId(null);
    return bankDetails;
  }

  private List<BankDetailsBean> prepareListofBean(List<BankDetails> bankDetailsList)
  {
    List<BankDetailsBean> beans = null;
    if (bankDetailsList != null && !bankDetailsList.isEmpty())
    {
      beans = new ArrayList<BankDetailsBean>();
      BankDetailsBean bean = null;
      for (BankDetails bankDetails : bankDetailsList)
      {
        bean = prepareBankDetailsBean(bankDetails);
        beans.add(bean);
      }
    }
    Collections.sort(bankDetailsList, Collections.reverseOrder(new ExpiryDateComparator()));

    return beans;
  }

  private BankDetailsBean prepareBankDetailsBean(BankDetails bankDetails)
  {
    BankDetailsBean bean = new BankDetailsBean();
    bean.setBank(bankDetails.getBank());
    bean.setCardNumber(BankDetailsUtil.maskCard(bankDetails.getCardNumber()));
    if (bankDetails.getExpiryDate() != null)
    {
      bean.setExpiryDate(bankDetails.getExpiryDate().toString());
    }
    bean.setId(bankDetails.getId());
    return bean;
  }
}
