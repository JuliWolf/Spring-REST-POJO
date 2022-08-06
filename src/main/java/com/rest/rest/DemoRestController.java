package com.rest.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class DemoRestController {

  // add code for the /hello endpoint
  @GetMapping("/hello")
  public String sayHello () {
    return "Hello World!";
  }
}
