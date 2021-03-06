package com.example.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.thymeleaf.form.PersonForm;
import com.example.thymeleaf.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    private static final List<Person> persons = new ArrayList<>();

    static {
        persons.add(new Person("Даниил", "Ковальчук", "Васильевич","daniilVasil@mail.ru", "1994-04-24", "Moskva", "+72131231231", "Digital-маркетолог "));
    }

    @Value("Данное веб-приложение предназначено для занесения новых сотрудников в таблицу. Для тестирования веб-приложения перейдите на вкладку Employee Information. Всего наилучшего.")
    private String message;

    @Value("First Name or Last Name or Email or Date of Birth is required! Check out!")
    private String errorMessage;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

    @RequestMapping(value = {"/personList"}, method = RequestMethod.GET)
    public String personList(Model model) {
        model.addAttribute("persons", persons);
        return "personList";
    }

    @RequestMapping(value = {"/addPerson"}, method = RequestMethod.GET)
    public String showAddPersonPage(Model model) {

        PersonForm personForm = new PersonForm();
        model.addAttribute("personForm", personForm);

        return "addPerson";
    }

    @RequestMapping(value = {"/addPerson"}, method = RequestMethod.POST)
    public String savePerson(Model model, @ModelAttribute("personForm") PersonForm personForm) {

        String firstName = personForm.getFirstName();
        String lastName = personForm.getLastName();
        String middleName = personForm.getMiddleName();
        String email = personForm.getEmail();
        String dateOfBirth = personForm.getDateOfBirth();
        String placeOfResidence = personForm.getPlaceOfResidence();
        String number = personForm.getNumber();
        String position = personForm.getPosition();

        if (firstName != null && firstName.length() > 0 && lastName != null && lastName.length() > 0 && middleName != null && middleName.length() > 0 && email != null && email.length() > 0 && dateOfBirth != null && dateOfBirth.length() > 0 && number != null && number.length() > 0 && position != null && position.length() > 0) {
            Person newPerson = new Person(firstName, lastName, middleName, email, dateOfBirth, placeOfResidence, number, position);
            persons.add(newPerson);
            return "redirect:/personList";
        } else {
            model.addAttribute("errorMessage", errorMessage);
            return "addPerson";
        }
    }

}