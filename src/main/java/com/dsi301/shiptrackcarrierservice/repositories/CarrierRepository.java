package com.dsi301.shiptrackcarrierservice.repositories;

import com.dsi301.shiptrackcarrierservice.entities.Carrier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrierRepository extends JpaRepository<Carrier,Integer> {
}
