package com.gsamtechnology.sangiorgio.adapter.out.persistence.repositories;

import com.gsamtechnology.sangiorgio.adapter.out.persistence.entities.ChargeEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ChargeRepository extends JpaRepository<ChargeEntity,String> {
  @EntityGraph(attributePaths = "payments")
  @Query("SELECT DISTINCT c FROM ChargeEntity c JOIN c.payments p WHERE c.codeSeller = :codeSeller AND p.codePayment IN (:payments)")
  Optional<ChargeEntity> getPayment(@Param("codeSeller") String codeSeller, @Param("payments") List<String> payments);
}
