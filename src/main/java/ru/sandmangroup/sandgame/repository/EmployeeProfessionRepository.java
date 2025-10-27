package ru.sandmangroup.sandgame.repository;

import io.jmix.core.repository.JmixDataRepository;
import org.springframework.stereotype.Repository;
import ru.sandmangroup.sandgame.entity.employee.Employee;
import ru.sandmangroup.sandgame.entity.employee.EmployeeProfession;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeeProfessionRepository extends JmixDataRepository<EmployeeProfession, UUID> {
 List<EmployeeProfession> findAllByEmployee(Employee editedEntity);
}