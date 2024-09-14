package com.gsamtechnology.sandiorgio.domain.entities;

import java.util.Objects;

public class Seller {
  private String code;
  private String name;

  public Seller() {
  }

  public Seller(String code, String name) {
    this.code = code;
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Seller seller = (Seller) o;
    return Objects.equals(code, seller.code) && Objects.equals(name, seller.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, name);
  }
}
