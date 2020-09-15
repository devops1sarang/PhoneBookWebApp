package com.tl.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tl.pojos.Contact;
import com.tl.service.ContactService;

@Controller
public class ViewContactsController {

	@Autowired
	private ContactService contactService;

	public String handleAddCtctsHyperLink(Model model) {
		return null;
	}

	@GetMapping("/editContact")
	public String editContact(@RequestParam("cid") Integer cid, Model model) {
		Contact contact = contactService.getContactByid(cid);
		model.addAttribute("contact", contact);
		return "index";
	}

	@GetMapping("/deleteContact")
	public String deleteContact(@RequestParam("cid") Integer cid, Model model) {
		contactService.deleteContactById(cid);
		return "redirect:viewContacts";
	}
}
