package ma.lbv.api.commonparent.exceptions.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class ValidationResponse {

    private String object;

    private String field;

    private Object rejectedValue;

    private String message;

    public ValidationResponse(String object, String message) {
        this.object = object;
        this.message = message;
    }
}
