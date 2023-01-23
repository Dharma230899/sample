package com.BrownField.pss.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.BrownField.pss.Form.SearchForm;


@Controller
public class SearchFlightController {

	
	@RequestMapping(value="/Search", method=RequestMethod.GET)
	public String getSearchPage( Model model) {
		//model.addAttribute("searchForm", new SearchForm());
		
		SearchForm searchForm = new SearchForm();
		searchForm.setTrip_type("one way");
		model.addAttribute("searchForm",searchForm);
		System.out.println(searchForm);
		
		List<Integer> listNo = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
        model.addAttribute("list", listNo);
		List<Integer> listProfession = Arrays.asList(1,2,3,4,5,6,7,8,9);
        model.addAttribute("listAdults", listProfession);
        
		return "Search";
	}
	
	@RequestMapping(value="/SelectDepFlights", method=RequestMethod.POST)
	public String getLoginHome(@ModelAttribute(name="searchForm") SearchForm searchForm,Model model) {
		System.out.println(searchForm);
		return "SelectDepFlights";
	}
	
	@RequestMapping(value="/SelectRetFlights", method=RequestMethod.GET)
	public String getReturnPage(@ModelAttribute(name="searchForm")SearchForm searchForm,ModelAndView model) {
		String ret=searchForm.getRetureDate();
		System.out.print(searchForm);
		//model.addObject(ret);
		if(ret == null){
			return "redirect:/Booking";
		}
		else return "SelectRetFlights";
		
//		return "SelectRetFlights";
	}
	
	
}
