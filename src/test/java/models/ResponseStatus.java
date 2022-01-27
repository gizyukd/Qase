package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseStatus {
    boolean status;
    String errorMessage;
    Result result;
    int cases;
    //ErrorFields errorFields;
}
