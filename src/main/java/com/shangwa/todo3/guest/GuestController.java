package com.shangwa.todo3.guest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuestController {
    
    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }
}
