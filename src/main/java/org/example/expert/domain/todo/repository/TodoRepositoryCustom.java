package org.example.expert.domain.todo.repository;

import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TodoRepositoryCustom {

    Page<Todo> findAllByOrderByModifiedAtDesc(Specification<Todo> spec, Pageable pageable);

    Optional<Todo> findByIdWithUser(@Param("todoId") Long todoId);
}
