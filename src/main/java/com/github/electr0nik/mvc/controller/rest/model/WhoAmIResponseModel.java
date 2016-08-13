package com.github.electr0nik.mvc.controller.rest.model;

/**
 * @author nik
 * @since 1.0.0-SNAPSHOT
 */
public class WhoAmIResponseModel {
  private final String name;
  private final String version;


  public WhoAmIResponseModel(String name, String version) {
    this.name = name;
    this.version = version;
  }

  public String getName() {
    return name;
  }

  public String getVersion() {
    return version;
  }
}
