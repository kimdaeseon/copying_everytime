package com.practice.kimdaeseon.domain.scheduleData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScheduleDataRepository extends JpaRepository<ScheduleData, Long> {
    @Query("select p.subjectName from ScheduleData p where p.scheduleName = :name")
    List<String> getSubjectUseUserName(@Param("name") String scheduleName);
}
