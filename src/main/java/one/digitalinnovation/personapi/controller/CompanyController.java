package one.digitalinnovation.personapi.controller;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.dto.request.CompanyDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.exception.CompanyNotFoundException;
import one.digitalinnovation.personapi.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CompanyController {

    private CompanyService companyService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createCompany(@RequestBody @Valid CompanyDTO companyDTO) {
        return companyService.createCompany(companyDTO);
    }

    @GetMapping
    public List<CompanyDTO> listAll() {
        return companyService.listAll();
    }

    @GetMapping("/{id}")
    public CompanyDTO findById(@PathVariable Long id) throws CompanyNotFoundException {
        return companyService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid CompanyDTO companyDTO) throws CompanyNotFoundException {
        return companyService.updateById(id, companyDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws CompanyNotFoundException {
        companyService.delete(id);
    }
}
