package com.saigon.development.application.apis.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demoController")
public class DemoController {

  @GetMapping("/getDemo")
  public String getDemo() {
    return "Get Demo";
  }

  @PostMapping("/postDemo")
  public String postDemo() {
    return "Post Demo";
  }

}
