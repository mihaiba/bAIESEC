package com.levi9.baisec.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * File created by a.chmilevski on 2/24/2016 - 10:37 AM.
 * RadiON
 */
@Controller
@RequestMapping(value = "/contacts")
public class ContactsController {
    private static final Logger logger = LoggerFactory.getLogger(ContactsController.class);

    private static Map<Integer, Contact> contacts = new HashMap<>();
    private static int maxId = 1;

    public ContactsController(){
        Contact c = new Contact();
        c.setName("Albert Chmilevski");
        c.setPhone("0756929431");
        c.setAddress("Clopotari 25");
        c.setDateOfBirth("14/02/1993");
        contacts.put(maxId, c);
        maxId++;

        c = new Contact();
        c.setName("Alex Ioan");
        c.setPhone("075695555");
        c.setAddress("Targu Cucu");
        c.setDateOfBirth("01/01/1950");
        contacts.put(maxId, c);
        maxId++;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index() {
        logger.debug("In index");

        return "redirect:/contacts/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String displayContactList(Model model) {
        logger.debug("In displayContactList");

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

        model.addAttribute("contact", contacts.get(contactId));

        return "edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String doEditContact(@RequestParam Integer contactId, @ModelAttribute Contact contact) {
        logger.debug("In doEditContact");

        contacts.put(contactId, contact);

        return "redirect:/contacts/view?contactId=" + contactId;
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String displayViewContact(@RequestParam Integer contactId, Model model) {
        logger.debug("In displayViewContact");

        model.addAttribute("contact", contacts.get(contactId));

        return "view";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String doDeleteContact(@RequestParam Integer contactId) {
        logger.debug("In doDeleteContact");

        contacts.remove(contactId);

        return "redirect:/contacts/list";
    }
}
