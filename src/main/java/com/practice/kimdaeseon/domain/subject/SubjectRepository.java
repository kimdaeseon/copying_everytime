package com.practice.kimdaeseon.domain.subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    @Query("select p from Subject p where p.name = :name")
    Subject findSubjectByName(@Param("name") String name);
}
