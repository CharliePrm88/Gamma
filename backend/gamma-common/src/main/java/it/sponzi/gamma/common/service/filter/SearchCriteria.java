package it.sponzi.gamma.common.service.filter;

import it.sponzi.gamma.common.service.filter.enumerated.SearchOperation;
import lombok.Data;

@Data
public class SearchCriteria {

    public SearchCriteria(String key, String operation, String value) {
        this.key = key;
        this.operation = SearchOperation.getSimpleOperation(operation);
        this.value = value;
    }

    private String key;
    private SearchOperation operation;
    private String value;
}
