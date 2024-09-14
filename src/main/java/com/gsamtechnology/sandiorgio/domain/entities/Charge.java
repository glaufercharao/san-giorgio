package com.gsamtechnology.sandiorgio.domain.entities;

import java.util.Objects;

public class Charge {
  private String codeCharge;
  private String amountCharge;

  public Charge() {
  }

  public Charge(String codeCharge, String amountCharge) {
    this.codeCharge = codeCharge;
    this.amountCharge = amountCharge;
  }

  public String getCodeCharge() {
    return codeCharge;
  }

  public void setCodeCharge(String codeCharge) {
    this.codeCharge = codeCharge;
  }

  public String getAmountCharge() {
    return amountCharge;
  }

  public void setAmountCharge(String amountCharge) {
    this.amountCharge = amountCharge;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Charge charge = (Charge) o;
    return Objects.equals(codeCharge, charge.codeCharge) && Objects.equals(amountCharge, charge.amountCharge);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codeCharge, amountCharge);
  }
}
