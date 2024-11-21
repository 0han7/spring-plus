package org.example.expert.domain.todo.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.expert.domain.todo.entity.QTodo;
import org.example.expert.domain.todo.entity.Todo;
import org.example.expert.domain.user.entity.QUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TodoRepositoryCustomImpl implements TodoRepositoryCustom {

    private final JPAQueryFactory queryFactory;


    @Override
    public Page<Todo> findAllByOrderByModifiedAtWeatherORDate(
            @Param("weater") String weather,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            Pageable pageable
    ) {
        QTodo todo = QTodo.todo;

        List<Todo> todos = queryFactory
                .select(todo)
                .where(todo.weather.eq(weather))
                .orderBy(todo.modifiedAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Optional<Long> totalOptional = Optional.ofNullable(queryFactory
                .select(todo.count())
                .from(todo)
                .fetchOne());

        long total = totalOptional.orElse(0L);

        return new PageImpl<>(todos, pageable, total);
    }

    @Override
    public Optional<Todo> findByIdWithUser(Long todoId) {
        QTodo todo = QTodo.todo;
        QUser user = QUser.user;

        Todo result = queryFactory
                .select(todo)
                .leftJoin(todo.user, user).fetchJoin()
                .where(todo.id.eq(todoId))
                .fetchOne();

        return Optional.ofNullable(result);
    }
}
