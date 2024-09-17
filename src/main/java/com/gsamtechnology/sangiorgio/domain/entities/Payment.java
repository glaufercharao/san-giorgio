package com.gsamtechnology.sangiorgio.domain.entities;

import com.gsamtechnology.sangiorgio.adapter.out.persistence.entities.ChargeEntity;
import com.gsamtechnology.sangiorgio.domain.enums.PaymentStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

public class Payment {
  private String codePayment;
  private BigDecimal amountPayment;
  @Enumerated(EnumType.STRING)
  private PaymentStatus status;

  public Payment() {
  }

  public Payment(String codePayment, BigDecimal amountPayment, PaymentStatus status) {
    this.codePayment = codePayment;
    this.amountPayment = amountPayment;
    this.status = status;
  }

  public String getCodePayment() {
    return codePayment;
  }

  public void setCodePayment(String codePayment) {
    this.codePayment = codePayment;
  }

  public BigDecimal getAmountPayment() {
    return amountPayment;
  }

  public void setAmountPayment(BigDecimal amountPayment) {
    this.amountPayment = amountPayment;
  }

  public PaymentStatus getStatus() {
    return status;
  }

  public void setStatus(PaymentStatus status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Payment payment = (Payment) o;
    return Objects.equals(codePayment, payment.codePayment) && Objects.equals(amountPayment, payment.amountPayment) && status == payment.status;
  }

  @Override
  public int hashCode() {
    return Objects.hash(codePayment, amountPayment, status);
  }

  @Override
  public String toString() {
    return "Payment{" +
            "codePayment='" + codePayment + '\'' +
            ", amountPayment=" + amountPayment +
            ", status=" + status +
            '}';
  }
}
