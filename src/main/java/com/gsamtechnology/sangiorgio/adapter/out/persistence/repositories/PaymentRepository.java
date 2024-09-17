package com.gsamtechnology.sangiorgio.adapter.out.persistence.repositories;

import com.gsamtechnology.sangiorgio.adapter.out.persistence.entities.ChargeEntity;
import com.gsamtechnology.sangiorgio.adapter.out.persistence.entities.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity,String> {
}
