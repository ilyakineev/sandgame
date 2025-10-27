package ru.sandmangroup.sandgame.repository;

import io.jmix.core.FetchPlan;
import io.jmix.core.repository.JmixDataRepository;
import io.jmix.core.repository.JmixDataRepositoryContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import ru.sandmangroup.sandgame.entity.Department;
import ru.sandmangroup.sandgame.entity.employee.Employee;
import ru.sandmangroup.sandgame.entity.employee.EmployeeSkill;
import ru.sandmangroup.sandgame.entity.employee.ProfessionLevel;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JmixDataRepository<Employee, UUID> {
    List<Employee> findAllByDepartment(Department editedEntity, PageRequest pageRequest, JmixDataRepositoryContext jmixDataRepositoryContext);
}