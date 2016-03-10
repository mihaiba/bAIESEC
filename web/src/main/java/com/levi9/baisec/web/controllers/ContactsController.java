package com.levi9.baisec.web.controllers;

import static java.util.stream.Collectors.toMap;

import java.security.Principal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.levi9.baisec.web.controllers.models.Contact;

/**
 * File created by a.chmilevski on 2/24/2016 - 10:37 AM. RadiON
 */
@Controller
@RequestMapping(value = "/contacts")
public class ContactsController {
	private static final Logger logger = LoggerFactory.getLogger(ContactsController.class);

	@Autowired
	RestTemplate restTemplate;

	@Value("${rest.url}")
	String restUrl;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index() {
		logger.debug("In index");

		return "redirect:/contacts/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String displayContactList(Principal principal, Model model) {
		logger.debug("In displayContactList");

		ResponseEntity<Contact[]> responseEntity = restTemplate
				.getForEntity(restUrl + "/users/" + principal.getName() + "/contacts", Contact[].class);
		List<Contact> contacts = Arrays.asList(responseEntity.getBody());

		model.addAttribute("contacts", contacts.stream().collect(toMap(Contact::getId, Function.<Contact> identity())));

		return "list";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String displayCreateContact(Model model) {
		logger.debug("In displayCreateContact");
		model.addAttribute("contact", new Contact());
		return "create";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String doCreateContact(@ModelAttribute Contact contact, Principal principal) {
		logger.debug("In doCreateContact");
		ResponseEntity<Contact> responseEntity = restTemplate
				.postForEntity(restUrl + "/users/" + principal.getName() + "/contacts", contact, Contact.class);

		return "redirect:/contacts/view?contactId=" + responseEntity.getBody().getId();
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String displayEditContact(@RequestParam Integer contactId, Model model, Principal principal) {
		logger.debug("In displayEditContact");
		ResponseEntity<Contact> responseEntity = restTemplate
				.getForEntity(restUrl + "/users/" + principal.getName() + "/contacts/" + contactId, Contact.class);
		model.addAttribute("contact", responseEntity.getBody());

		return "edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String doEditContact(@RequestParam Integer contactId, @ModelAttribute Contact contact, Principal principal) {
		logger.debug("In doEditContact");
		restTemplate.put(restUrl + "/users/" + principal.getName() + "/contacts/" + contactId, contact);
		return "redirect:/contacts/view?contactId=" + contactId;
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String displayViewContact(@RequestParam Integer contactId, Model model, Principal principal) {
		logger.debug("In displayViewContact");

		ResponseEntity<Contact> responseEntity = restTemplate
				.getForEntity(restUrl + "/users/" + principal.getName() + "/contacts/" + contactId, Contact.class);
		model.addAttribute("contact", responseEntity.getBody());

		return "view";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String doDeleteContact(@RequestParam Integer contactId, Principal principal) {
		logger.debug("In doDeleteContact");
		Map<String, String> params = new HashMap<>();
		params.put("contactId", contactId.toString());
		restTemplate.delete(restUrl + "/users/" + principal.getName() + "/contacts/{contactId}", params);
		return "redirect:/contacts/list";
	}
}
