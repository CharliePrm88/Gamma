package it.sponzi.gamma.common.service.filter;

import it.sponzi.gamma.common.dao.BaseDao;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

public class QueryService<T extends BaseDao> {

    public QueryService(){}

    public Example<T> getCriteriaBySearchCriteria(T dao, SearchCriteria criteria){
        return switch (criteria.getOperation()){
            case CONTAINS -> {
                ExampleMatcher exampleObjectMatcher = ExampleMatcher.matching()
                        .withMatcher(criteria.getKey(), ExampleMatcher.GenericPropertyMatchers.contains());
                yield Example.of(dao,exampleObjectMatcher);
            }
            case EQUAL -> Example.of(dao, ExampleMatcher.matching().withIgnoreCase(criteria.getValue()));
            case BEGINS_WITH -> {
                ExampleMatcher exampleObjectMatcher = ExampleMatcher.matching()
                        .withMatcher(criteria.getKey(), ExampleMatcher.GenericPropertyMatchers.startsWith());
                yield Example.of(dao,exampleObjectMatcher);
            }
            case ENDS_WITH -> {
                ExampleMatcher exampleObjectMatcher = ExampleMatcher.matching()
                        .withMatcher(criteria.getKey(), ExampleMatcher.GenericPropertyMatchers.endsWith());
                yield Example.of(dao,exampleObjectMatcher);
            }
            case ANY -> Example.of(dao, ExampleMatcher.matchingAny().withIgnoreCase());
            case ALL -> Example.of(dao, ExampleMatcher.matching().withIgnoreCase());
            default -> throw new IllegalStateException("Not implemented value: " + criteria.getOperation());
        };
    }

}
