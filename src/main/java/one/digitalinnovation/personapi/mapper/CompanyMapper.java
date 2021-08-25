package one.digitalinnovation.personapi.mapper;

import one.digitalinnovation.personapi.dto.request.CompanyDTO;
import one.digitalinnovation.personapi.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CompanyMapper {

    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    Company toModel(CompanyDTO companyDTO);

    CompanyDTO toDTO(Company company);
}
