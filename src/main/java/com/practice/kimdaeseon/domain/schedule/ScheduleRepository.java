package com.practice.kimdaeseon.domain.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long>{
    @Query("SELECT p FROM Schedule p ORDER BY p.id DESC")
    List<Schedule> findAll();
}
