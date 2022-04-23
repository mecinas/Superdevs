package com.warehouse.superdevs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index1(){
        return "Start";
    }

    @GetMapping("/new")
    public ResponseEntity index2(){
        return new ResponseEntity(HttpStatus.OK);
    }
}
