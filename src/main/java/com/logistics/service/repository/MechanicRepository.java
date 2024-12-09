package com.logistics.repository;

import com.logistics.entity.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MechanicRepository extends JpaRepository<Mechanic, Long> {
}
