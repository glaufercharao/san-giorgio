package com.gsamtechnology.sangiorgio.domain.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Charge {
  private String codeSeller;
  private List<Payment> payments = new ArrayList<>();

  public Charge() {
  }

  public Charge(String codeSeller, List<Payment> payments) {
    this.codeSeller = codeSeller;
    this.payments = payments;
  }

  public String getCodeSeller() {
    return codeSeller;
  }

  public void setCodeSeller(String codeSeller) {
    this.codeSeller = codeSeller;
  }

  public List<Payment> getPayments() {
    return payments;
  }

  public void setPayments(List<Payment> payments) {
    this.payments = payments;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Charge charge = (Charge) o;
    return Objects.equals(codeSeller, charge.codeSeller) && Objects.equals(payments, charge.payments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codeSeller, payments);
  }
}
