package com.github.electr0nik.mvc.controller;

import com.github.electr0nik.repository.ProcessRepository;
import com.github.electr0nik.repository.jpa.entity.ProcessEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Optional;

/**
 * No Layer separation yet
 *
 * @author nik
 * @since 1.0.0-SNAPSHOT
 */
@Controller
public class ProcessListController {

  private final ProcessRepository repository;


  @Autowired
  public ProcessListController(final ProcessRepository repository) {
    this.repository = repository;
  }

  @RequestMapping(value = "/{user}", method = RequestMethod.GET)
  public String getProcessListByUser(final Model model,
      @PathVariable final String user) {
    model.addAttribute("processList", Optional.ofNullable(repository.findByUser(user)).orElse(new ArrayList<>()));
    return "views/index";
  }

  @RequestMapping(value = "/{user}", method = RequestMethod.POST)
  public String addToProcessList(@PathVariable final String user,
      final ProcessEntity processEntity) {
    processEntity.setUser(user);
    repository.save(processEntity);
    return "redirect:/{user}";
  }
}
