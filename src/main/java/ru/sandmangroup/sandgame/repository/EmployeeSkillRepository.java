package ru.sandmangroup.sandgame.repository;

import io.jmix.core.repository.JmixDataRepository;
import io.jmix.core.repository.JmixDataRepositoryContext;
import io.jmix.flowui.component.grid.DataGrid;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import ru.sandmangroup.sandgame.entity.employee.EmployeeSkill;
import ru.sandmangroup.sandgame.entity.employee.ProfessionLevel;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeeSkillRepository extends JmixDataRepository<EmployeeSkill, UUID> {
    List<EmployeeSkill> findAllByProfessionLevels(ProfessionLevel professionLevelsDataGrid, PageRequest pageRequest, JmixDataRepositoryContext jmixDataRepositoryContext);
}