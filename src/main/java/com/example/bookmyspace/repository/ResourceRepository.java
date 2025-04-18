package com.example.bookmyspace.repository;

import com.example.bookmyspace.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {

    @Query("""
        SELECT r FROM Resource r
        WHERE r.floor.id = :floorId
          AND r.floor.building.id = :buildingId
          AND r.id NOT IN (
              SELECT b.resource.id FROM Booking b
              WHERE b.startTime < :endTime AND b.endTime > :startTime
          )
    """)
    List<Resource> findAvailableResources(
            @Param("startTime") LocalDateTime startTime,
            @Param("endTime") LocalDateTime endTime,
            @Param("buildingId") Long buildingId,
            @Param("floorId") Long floorId
    );
}

