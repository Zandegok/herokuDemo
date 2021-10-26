package com.example.herokutry.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/home", method = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})

public class HomeController
{
  @GetMapping(value = "/hello")
  public String hello()
          throws Exception
  {
    return "Hello";
  }

}
