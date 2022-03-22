package org.library.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/items")
public class ItemController {

  @GetMapping("/all")
  public String getTestData() {
    return "allItems";
  }
}
