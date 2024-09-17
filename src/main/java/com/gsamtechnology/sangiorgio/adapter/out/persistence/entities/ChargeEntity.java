package com.gsamtechnology.sangiorgio.adapter.out.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tb_charge")
public class ChargeEntity implements Serializable {
  @Id
  private String codeSeller;
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "code_seller", referencedColumnName = "codeSeller")
  private List<PaymentEntity> payments = new ArrayList<>();

  public ChargeEntity() {
  }

  public ChargeEntity(String codeSeller, List<PaymentEntity> payments) {
    this.codeSeller = codeSeller;
    this.payments = payments;
  }

  public String getCodeSeller() {
    return codeSeller;
  }

  public void setCodeSeller(String codeSeller) {
    this.codeSeller = codeSeller;
  }

  public List<PaymentEntity> getPayments() {
    return payments;
  }

  public void setPayments(List<PaymentEntity> payments) {
    this.payments = payments;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ChargeEntity that = (ChargeEntity) o;
    return Objects.equals(codeSeller, that.codeSeller) && Objects.equals(payments, that.payments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codeSeller, payments);
  }

  @Override
  public String toString() {
    return "ChargeEntity{" +
            "codeSeller='" + codeSeller + '\'' +
            ", payments=" + payments +
            '}';
  }
}
