package com.BrownField.pss.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.BrownField.pss.Form.BookingForm;



@Controller
public class BookingContoller {

	@RequestMapping(value="/Booking", method=RequestMethod.GET)
	public String getBookingPage(Model model) {
		BookingForm bookingForm= new BookingForm();
		model.addAttribute("BookingForm",bookingForm);
		System.out.println(bookingForm);
		List<String> listNo = Arrays.asList("NO meal","Veg","Non Veg");
        model.addAttribute("meals", listNo);
		return "BookFlight";
	}
}
