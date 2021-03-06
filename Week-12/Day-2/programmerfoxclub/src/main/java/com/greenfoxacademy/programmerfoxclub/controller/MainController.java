package com.greenfoxacademy.programmerfoxclub.controller;

import com.greenfoxacademy.programmerfoxclub.models.*;
import com.greenfoxacademy.programmerfoxclub.services.ServiceButterfly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {
    ServiceButterfly serviceButterfly;
    ListOfButterflies listOfButterflies;
    

    @Autowired
    public MainController() {
        this.serviceButterfly = new ServiceButterfly();
        this.listOfButterflies = serviceButterfly.createList();

    }


    @GetMapping("/")
    public String getIndex(@RequestParam(value = "name", required = false) String name, Model model) {
        Butterfly actual;
        if (name == null) {
            return "login";
        } else {

            actual = serviceButterfly.getButterflyByName(name);

            model.addAttribute("name", actual.getName());
            model.addAttribute("food", actual.getFood());
            model.addAttribute("drink", actual.getDrink());
            model.addAttribute("tricks", actual.getTricks());
            model.addAttribute("tricknumber", actual.getTricksNumber());

        }
        return "index";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/submitname")
    public String postLogin(@ModelAttribute(value = "name") String name) {
        Butterfly oneInstance;
        oneInstance = serviceButterfly.createButterfly(name);
        serviceButterfly.addToList(oneInstance);
        return "redirect:/?name=" + name;

    }
    @GetMapping("/nutritionstore")
    public String getNutritionStore(@RequestParam( value = "name", required = false) String name, Model model) {
        if (name == null) {
            return "login";
        } else {
            model.addAttribute("name", name);
            Food foodlist = new Food();
            model.addAttribute("foods", foodlist.getFoods());
            Drink drinklist = new Drink();
            model.addAttribute("drinks", drinklist.getDrinks());
        }

        return "nutritionstore";
    }

    @PostMapping("/nutritionstorepost")
    public String getFoodAndDrink( @ModelAttribute(value = "name") String name,
                                   @ModelAttribute(value = "food") String food,
                                   @ModelAttribute(value = "drink") String drink) {

        Butterfly actual = serviceButterfly.getButterflyByName(name);
        actual.setFood(food);
        actual.setDrink(drink);

        return "redirect:/?name=" + name;
    }

    @GetMapping("/trickcenter")
    public String getTrickCenter(@RequestParam( value = "name", required = false) String name, Model model) {
        if (name == null) {
            return "login";
        } else {
            model.addAttribute("name", name);
            Butterfly actual = serviceButterfly.getButterflyByName(name);
            List<String> actualTrickList = actual.addOnlyTheUknowTricks();
            if (actualTrickList.isEmpty()) {
                return "notricks";
            } else {
                model.addAttribute("tricks", actualTrickList);
            }

            return "trickcenter";
        }
    }

    @PostMapping("/tricklearn")
    public String learnTricks( @ModelAttribute(value = "name") String name,
                               @ModelAttribute(value = "trick") String trick){

        Butterfly actual = serviceButterfly.getButterflyByName(name);
        actual.addTrick(trick);

        return "redirect:/?name=" + name;
    }



}
