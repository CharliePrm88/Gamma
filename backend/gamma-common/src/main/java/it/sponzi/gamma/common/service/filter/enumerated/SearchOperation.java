package it.sponzi.gamma.common.service.filter.enumerated;

import it.sponzi.gamma.common.exception.EnumNotFoundException;

public enum SearchOperation {

    CONTAINS, DOES_NOT_CONTAIN, EQUAL, NOT_EQUAL, BEGINS_WITH,
    DOES_NOT_BEGIN_WITH, ENDS_WITH, DOES_NOT_END_WITH,
    NUL, NOT_NULL, GREATER_THAN, GREATER_THAN_EQUAL, LESS_THAN,
    LESS_THAN_EQUAL, ANY, ALL;
    public static final String[] SIMPLE_OPERATION_SET = {
            "cn", "nc", "eq", "ne", "bw", "bn", "ew",
            "en", "nu", "nn", "gt", "ge", "lt", "le" };

    public static SearchOperation getDataOption(final String
                                                        dataOption){
        return switch (dataOption) {
            case "all" -> ALL;
            case "any" -> ANY;
            default -> null;
        };
    }

    public static SearchOperation getSimpleOperation(
            final String input) {
        return switch (input) {
            case "cn" -> CONTAINS;
            case "nc" -> DOES_NOT_CONTAIN;
            case "=" -> EQUAL;
            case "!=" -> NOT_EQUAL;
            case "_bw_" -> BEGINS_WITH;
            case "_bn_" -> DOES_NOT_BEGIN_WITH;
            case "_ew_" -> ENDS_WITH;
            case "_en_" -> DOES_NOT_END_WITH;
            case "_nu_" -> NUL;
            case "_nn_" -> NOT_NULL;
            case ">" -> GREATER_THAN;
            case ">=" -> GREATER_THAN_EQUAL;
            case "<" -> LESS_THAN;
            case "<=" -> LESS_THAN_EQUAL;
            default -> throw new EnumNotFoundException(input);
        };
    }
}