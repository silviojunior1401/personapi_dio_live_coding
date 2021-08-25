package one.digitalinnovation.personapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO {

    private Long id;

    @NotEmpty
    @Size(min = 5, max = 200)
    private String companyName;

    @NotEmpty
    @Size(min = 5, max = 200)
    private String tradingName;

    @NotEmpty
    @CNPJ
    private String cnpj;

}
