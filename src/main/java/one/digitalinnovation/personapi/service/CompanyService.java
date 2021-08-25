package one.digitalinnovation.personapi.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.dto.request.CompanyDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Company;
import one.digitalinnovation.personapi.entity.Company;
import one.digitalinnovation.personapi.exception.CompanyNotFoundException;
import one.digitalinnovation.personapi.mapper.CompanyMapper;
import one.digitalinnovation.personapi.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CompanyService {

    private CompanyRepository companyRepository;

    private final CompanyMapper companyMapper = CompanyMapper.INSTANCE;

    public MessageResponseDTO createCompany(CompanyDTO companyDTO) {
        Company companyToSave = companyMapper.toModel(companyDTO);

        Company savedCompany = companyRepository.save(companyToSave);
        return createMessageResponse(savedCompany.getId(), "Created company with ID ");
    }

    public List<CompanyDTO> listAll() {
        List<Company> allCompany = companyRepository.findAll();
        return allCompany.stream()
                .map(companyMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CompanyDTO findById(Long id) throws CompanyNotFoundException {
        Company company = verifyIfExists(id);

        return companyMapper.toDTO(company);
    }

    public void delete(Long id) throws CompanyNotFoundException {
        verifyIfExists(id);
        companyRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, CompanyDTO companyDTO) throws CompanyNotFoundException {
        verifyIfExists(id);

        Company companyToUpdate = companyMapper.toModel(companyDTO);

        Company updatedCompany = companyRepository.save(companyToUpdate);
        return createMessageResponse(id, "Updated company with ID ");
    }

    private Company verifyIfExists(Long id) throws CompanyNotFoundException {
        return companyRepository.findById(id)
                .orElseThrow(() -> new CompanyNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
