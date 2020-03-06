package com.databaserelationship.dbrelationonetomany.repository;

import com.databaserelationship.dbrelationonetomany.resources.entity.InternDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternDetailsRepository extends JpaRepository<InternDetails, Long> {
}
