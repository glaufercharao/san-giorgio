package com.gsamtechnology.sangiorgio.adapter.out.persistence.repositories;

import com.gsamtechnology.sangiorgio.adapter.out.persistence.entities.ChargeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ChargeRepository extends JpaRepository<ChargeEntity,String> {
}
