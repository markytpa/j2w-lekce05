package cz.czechitas.java2webapps.lekce5.controller;

import cz.czechitas.java2webapps.lekce5.entity.Person;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Filip Jirsák
 */
@Controller
public class FamousPeopleController {
  private final List<Person> people;

  public FamousPeopleController() {
    people = new ArrayList(List.of(
            new Person("Angela", "Merkelová", LocalDate.of(1954, 7, 17)),
            new Person("Bill", "Gates", LocalDate.of(1955, 10, 28)),
            new Person("Greta", "Thunbergová", LocalDate.of(2003, 1, 3))
    ));
  }

  @GetMapping("/")
  public ModelAndView list() {
    ModelAndView modelAndView = new ModelAndView("index");
    modelAndView.addObject("people", people);
    return modelAndView;
  }

  @GetMapping(path = "/", params = "query")
  public ModelAndView search(String query) {
    Iterator<Person> filteredPeople = people.stream()
            .filter(person -> person.getGivenName().contains(query) || person.getLastName().contains(query))
            .iterator();
    ModelAndView modelAndView = new ModelAndView("index");
    modelAndView.addObject("people", filteredPeople);
    return modelAndView;
  }

  @PostMapping("/")
  public String append(Person person) {
    people.add(person);
    return "redirect:/";
  }

  @GetMapping("/edit")
  public ModelAndView edit(int id) {
    ModelAndView modelAndView = new ModelAndView("edit");
    modelAndView.addObject("id", id);
    modelAndView.addObject("person", people.get(id));
    return modelAndView;
  }

  @PostMapping("/edit")
  public String edit(int id, Person person) {
    people.set(id, person);
    return "redirect:/";
  }

  @PostMapping(path = "/delete")
  public String delete(@RequestParam int id) {
    people.remove(id);
    return "redirect:/";
  }


}
