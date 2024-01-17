package com.anwar.storesmicroservices.repository;

import com.anwar.storesmicroservices.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoresRepository extends JpaRepository<Store, Long> {
}
