package my.test.demo.features.ladang;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * DetailTableInput
 */
@Data 
public class LadangTableInput {
    @NotNull
    private int pageNumber;
    @NotNull
    private int pageSize;
    @NotNull
    private String sortColumn;
    @NotNull
    private String sortDirection;
    @NotNull
    private String searchInput;
}