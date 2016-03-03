package com.levi9.baisec.web.controllers;

import com.levi9.baisec.web.controllers.models.Contact;
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

import java.util.Arrays;
import java.util.List;

/**
 * File created by a.chmilevski on 2/24/2016 - 10:37 AM.
 * RadiON
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
    public String displayContactList(Model model) {
        logger.debug("In displayContactList");

        ResponseEntity<Contact[]> responseEntity = restTemplate.getForEntity(restUrl + "/users/a.chmilevski/contacts", Contact[].class);
        List<Contact> contacts  = Arrays.asList(responseEntity.getBody());
        model.addAttribute("contacts", contacts);

        return "list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String displayCreateContact() {
        logger.debug("In displayCreateContact");

        return "edit";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String doCreateContact() {
        logger.debug("In doCreateContact");

        return "redirect:/contacts/view?contactId=4";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String displayEditContact(@RequestParam Integer contactId, Model model) {
        logger.debug("In displayEditContact");

        //model.addAttribute("contact", contacts.get(contactId));

        return "edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String doEditContact(@RequestParam Integer contactId, @ModelAttribute Contact contact) {
        logger.debug("In doEditContact");

        //contacts.put(contactId, contact);

        return "redirect:/contacts/view?contactId=" + contactId;
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String displayViewContact(@RequestParam Integer contactId, Model model) {
        logger.debug("In displayViewContact");

        //model.addAttribute("contact", contacts.get(contactId));

        return "view";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String doDeleteContact(@RequestParam Integer contactId) {
        logger.debug("In doDeleteContact");

        //contacts.remove(contactId);

        return "redirect:/contacts/list";
    }
}
