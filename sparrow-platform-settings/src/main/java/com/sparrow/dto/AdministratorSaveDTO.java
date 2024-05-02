package com.sparrow.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdministratorSaveDTO {


private Long fkInstituteId;
private List<Long> deleteHeadOfInstitute;
private List<Long> deleteHeadOfDepartment;
private List<DepartmentHeadDTO> departmentHeadDTO;
private List<HeadInstituteDTO> headInstituteDTO;
}
