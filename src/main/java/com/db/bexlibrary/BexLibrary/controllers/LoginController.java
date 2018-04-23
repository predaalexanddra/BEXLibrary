package com.db.bexlibrary.BexLibrary.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController extends DefaultController {

    @RequestMapping(value = "/login", method = {RequestMethod.POST,RequestMethod.GET})
    public String getLogin() {
        //model.addAttribute("isLoggedIn", isLoggedIn());
        //super.setTemplate(model, "index.html");
        return "dashboard";

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHomePage(Model model) {
        model.addAttribute("isLoggedIn", isLoggedIn());

        if (isLoggedIn() == true && super.getCurrentUser().getAuthorities().stream().anyMatch(o -> o.getAuthority().equals("ROLE_ADMIN"))) {
            super.setTemplate(model, "dashboard.html");
        } else {
            super.setTemplate(model, "index.html");
        }
        return "index2";
    }


}
