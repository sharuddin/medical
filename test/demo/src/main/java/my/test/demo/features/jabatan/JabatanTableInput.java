package my.test.demo.features.jabatan;

import javax.validation.constraints.NotNull;

import lombok.Data;


/**
 * HospitalTableInput
 */
@Data
public class JabatanTableInput {
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