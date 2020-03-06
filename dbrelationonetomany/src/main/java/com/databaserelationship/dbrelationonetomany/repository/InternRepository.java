package com.databaserelationship.dbrelationonetomany.repository;

import com.databaserelationship.dbrelationonetomany.resources.entity.Interns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InternRepository extends JpaRepository<Interns, Long> {

    @Query(value = "SELECT * FROM interns i WHERE i.first_name LIKE %?1% OR i.last_name LIKE %?1%", nativeQuery = true)
    List<Interns> findByName(String name);
}
