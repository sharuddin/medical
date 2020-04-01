package my.test.demo.features.pekerja;

import javax.validation.constraints.NotNull;

import lombok.Data;


/**
 * HospitalTableInput
 */
@Data
public class PekerjaTableInput {
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