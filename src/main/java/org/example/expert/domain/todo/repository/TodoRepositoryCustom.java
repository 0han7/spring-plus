package org.example.expert.domain.todo.repository;

import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;

public interface TodoRepositoryCustom {

    Page<Todo> findAllByOrderByModifiedAtWeatherORDate(
            @Param("weater") String weather,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            Pageable pageable
    );

    Optional<Todo> findByIdWithUser(@Param("todoId") Long todoId);
}
