package ru.sandmangroup.sandgame.repository;

import io.jmix.core.repository.JmixDataRepository;
import org.springframework.stereotype.Repository;
import ru.sandmangroup.sandgame.entity.Department;

import java.util.UUID;

@Repository
public interface DepartmentRepository extends JmixDataRepository<Department, UUID> {
}