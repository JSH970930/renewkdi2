package com.project.controller;


import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class Bigdata_Controller {
	
	   @GetMapping("/board/bigdata/issuetrend_list")
	   public String getBigdataissueListPage() throws Exception {
	      
	      return "/board/bigdata/issuetrend_list";
	   }
	   
	   @GetMapping("/board/bigdata/emerging_list")
	   public String getBigdataemergingListPage() throws Exception {
	      
	      return "/board/bigdata/emerging_list";
	   }
	   
	   @GetMapping("/board/bigdata/policyissue_list")
	   public String getBigdatapolicyissueListPage() throws Exception {
	      
	      return "/board/bigdata/policyissue_list";
	   }
	   
	   @GetMapping("/board/bigdata/economy_list")
	   public String getBigdataeconomyListPage() throws Exception {
	      
	      return "/board/bigdata/economy_list";
	   }
	   
	   @GetMapping("/board/bigdata/bigdatajisu_list")
	   public String getBigdatabigdatajisuListPage() throws Exception {
	      
	      return "/board/bigdata/bigdatajisu_list";
	   }
	   
	   @GetMapping("/board/bigdata/issuetrend_list_industry")
	   public String getBigdataissue_industryListPage() throws Exception {
	      
	      return "/board/bigdata/issuetrend_list_industry";
	   }
	   @GetMapping("/board/bigdata/issuetrend_list_tradework")
	   public String getBigdataissue_trdaeworkListPage() throws Exception {
	      
	      return "/board/bigdata/issuetrend_list_tradework";
	   }

	   @GetMapping("/board/bigdata/issuetrend_list_prices")
	   public String getBigdataissue_pricesListPage() throws Exception {
	      
	      return "/board/bigdata/issuetrend_list_prices";
	   }

	   @GetMapping("/board/bigdata/issuetrend_list_money")
	   public String getBigdataissue_moneyListPage() throws Exception {
	      
	      return "/board/bigdata/issuetrend_list_money";
	   }





}
