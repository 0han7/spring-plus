package org.example.expert.domain.todo.repository;

import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface TodoRepository extends JpaRepository<Todo, Long>, TodoRepositoryCustom{
    @Query("SELECT t FROM Todo t "
            + "WHERE (:weather IS NULL OR t.weather = :weather) "
            + "AND (:startDate IS NULL OR :endDate IS NULL OR DATE(t.modifiedAt) BETWEEN :startDate AND :endDate)"
            + "ORDER BY t.modifiedAt DESC ")
    Page<Todo> findAllByOrderByModifiedAtWeatherORDate(
            @Param("weater") String weather,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            Pageable pageable
    );
}
