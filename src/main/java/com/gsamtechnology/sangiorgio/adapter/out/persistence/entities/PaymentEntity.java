package com.gsamtechnology.sangiorgio.adapter.out.persistence.entities;

import com.gsamtechnology.sangiorgio.domain.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_payment")
public class PaymentEntity implements Serializable {
  @Id
  private String codePayment;
  private BigDecimal amountPayment;
  @Enumerated(EnumType.STRING)
  private PaymentStatus status;

  public PaymentEntity() {
  }

  public PaymentEntity(String codePayment, BigDecimal amountPayment, PaymentStatus status) {
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
    PaymentEntity that = (PaymentEntity) o;
    return Objects.equals(codePayment, that.codePayment) && Objects.equals(amountPayment, that.amountPayment) && status == that.status;
  }

  @Override
  public int hashCode() {
    return Objects.hash(codePayment, amountPayment, status);
  }

  @Override
  public String toString() {
    return "PaymentEntity{" +
            "codePayment='" + codePayment + '\'' +
            ", amountPayment=" + amountPayment +
            ", status=" + status +
            '}';
  }
}
