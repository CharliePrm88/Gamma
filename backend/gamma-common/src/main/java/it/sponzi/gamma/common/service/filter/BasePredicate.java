package it.sponzi.gamma.common.service.filter;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.types.dsl.StringPath;
import it.sponzi.gamma.common.dao.BaseDao;
import it.sponzi.gamma.common.service.filter.enumerated.SearchOperation;
import lombok.extern.slf4j.Slf4j;

import static org.apache.commons.lang3.StringUtils.isNumeric;

/**
 * PathBuilder<MyUser> entityPath = new PathBuilder<>(MyUser.class, "user");
 *
 * @param <T>
 */

@Slf4j
public class BasePredicate<T extends BaseDao> {
    private final SearchCriteria criteria;

    private final PathBuilder<T> entityPath;

    public BasePredicate(PathBuilder<T> entityPath, SearchCriteria criteria) {
        this.criteria = criteria;
        this.entityPath = entityPath;
    }

    public BooleanExpression getPredicate() {
        if (isNumeric(criteria.getValue())) {
            NumberPath<Integer> path = entityPath.getNumber(criteria.getKey(), Integer.class);
            int value = Integer.parseInt(criteria.getValue());
            switch (criteria.getOperation()) {
                case CONTAINS, DOES_NOT_CONTAIN, BEGINS_WITH, DOES_NOT_BEGIN_WITH, ENDS_WITH, DOES_NOT_END_WITH, NUL, NOT_NULL, ANY, ALL:
                    log.error(criteria.getOperation() + " NOT IMPLEMENTED");
                    break;
                case EQUAL:
                    return path.eq(value);
                case GREATER_THAN:
                    return path.gt(value);
                case LESS_THAN:
                    return path.lt(value);
                case NOT_EQUAL:
                    return path.ne(value);
                case GREATER_THAN_EQUAL:
                    return path.goe(value);
                case LESS_THAN_EQUAL:
                    return path.loe(value);
            }
        } else {
            StringPath path = entityPath.getString(criteria.getKey());
            if (criteria.getOperation().equals(SearchOperation.EQUAL)) {
                return path.containsIgnoreCase(criteria.getValue());
            }
        }
        return null;
    }

}
