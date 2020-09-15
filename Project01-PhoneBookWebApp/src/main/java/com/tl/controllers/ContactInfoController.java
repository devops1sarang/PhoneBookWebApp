package com.tl.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tl.entities.ContactDtlsEntity;
import com.tl.pojos.Contact;
import com.tl.service.ContactService;

@Controller
public class ContactInfoController {

	@Autowired
	private ContactService contactService;

	@GetMapping("/")
	public String loadContactForm(Model model) {
		Contact contactObj = new Contact();
		model.addAttribute("contact", contactObj);
		return "index";
	}

	@PostMapping("/saveContact")
	public String handleSubmitBtn(@ModelAttribute("contact") Contact c, RedirectAttributes redir) {
		boolean isSaved = contactService.saveContact(c);
		if (isSaved) {
			if (c.getCid() != null) {
				redir.addFlashAttribute("saveMsg", "Contact updated successfully!!!");
			} else {
				redir.addFlashAttribute("saveMsg", "Contact saved successfully!!!");
			}
		} else {
			redir.addFlashAttribute("errMsg", "Failed to save contact details.");
		}
		return "redirect:/submitContact";
	}

	@GetMapping("/submitContact")
	public String submitContact(Model model) {
		model.addAttribute("contact", new Contact());
		return "index";
	}

	@GetMapping("/viewContacts")
	public String handleViewCtcsHyperlink(Model model) {
		List<Contact> allContacts = contactService.getAllContacts();
		model.addAttribute("contacts", allContacts);
		return "viewContacts";
	}
}
