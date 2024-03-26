package com.example.springwebapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class login {

    private isAuthenticatedService isAuthenticatedService ;//=  new isAuthenticatedService();
     public login(isAuthenticatedService isAuthenticatedService){
         super();
         this.isAuthenticatedService = isAuthenticatedService;
     }
    //modelmap is used to pass data from controller to view(jsp) :- /login?name=r
    //requestparam is used to pass anything from controller
//    public String gotoLoginPage(@RequestParam String name, ModelMap model) {
//        System.out.println("check this"+name);
//        model.put("name",name);
//        return "login";
//    }
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String gotoLoginPage(){
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String gotoWelcomePage(@RequestParam String UserId,
                                  @RequestParam String Pass,
                                  ModelMap model){
        if (isAuthenticatedService.isAuthenticated(UserId,Pass)) {
            model.put("UserId", UserId);
            model.put("Pass", Pass);
            return "welcom";
        }
        model.put("errorMsg","Invalid Credentials! Please try again with valid one");
        return "login";
    }
}

