package org.example.expert.domain.todo.service;

import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class TodoSpecifications {

    public static Specification<Todo> hasWeather(String weather) {
        return (root, query, criteriaBuilder) ->
                weather == null ? null : criteriaBuilder.equal(root.get("weather"), weather);
    }

    public static Specification<Todo> modifiedAfter(String startDate) {
        return (root, query, criteriaBuilder) -> {
            if (startDate == null) return null;
            LocalDate date = LocalDate.parse(startDate);
            return criteriaBuilder.greaterThanOrEqualTo(root.get("modifiedDate"), date.atStartOfDay());
        };
    }

    public static Specification<Todo> modifiedBefore(String endDate) {
        return (root, query, criteriaBuilder) -> {
            if (endDate == null) return null;
            LocalDate date = LocalDate.parse(endDate);
            return criteriaBuilder.lessThanOrEqualTo(root.get("modifiedDate"), date.atTime(23, 59, 59));
        };
    }
}

