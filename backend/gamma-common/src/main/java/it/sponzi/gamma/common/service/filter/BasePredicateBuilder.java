package it.sponzi.gamma.common.service.filter;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.PathBuilder;
import it.sponzi.gamma.common.dao.BaseDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BasePredicateBuilder<T extends BaseDao> {
    private final List<SearchCriteria> params;

    public BasePredicateBuilder() {
        params = new ArrayList<>();
    }

    public BasePredicateBuilder<T> with(
            String key, String operation, String value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }

    public BooleanExpression build(PathBuilder<T> pathBuilder) {
        if (params.isEmpty()) {
            return null;
        }
        List<BooleanExpression> predicates = params.stream().map(param -> {
            BasePredicate<T> predicate = new BasePredicate<>(pathBuilder, param);
            return predicate.getPredicate();
        }).filter(Objects::nonNull).toList();
        BooleanExpression result = Expressions.asBoolean(true).isTrue();
        for (BooleanExpression predicate : predicates) {
            result = result.and(predicate);
        }
        return result;
    }


}
