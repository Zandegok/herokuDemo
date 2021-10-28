package com.example.herokutry.controllers;

import com.example.herokutry.models.entities.Character;
import com.example.herokutry.models.tables.TableCharacters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/home", method = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})

public class HomeController
{
  @Autowired
  TableCharacters tableCharacters;
  @GetMapping(value = "/hello")
  public String hello()
          throws Exception
  {
    return "Hello";
  }
  @GetMapping(value = "/getAll")
  public List<Character> getAll()
          throws Exception
  {
    return tableCharacters.findAll();
  }
}
