package ru.sandmangroup.sandgame.repository;

import io.jmix.core.repository.JmixDataRepository;
import io.jmix.core.repository.JmixDataRepositoryContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import ru.sandmangroup.sandgame.entity.employee.EmployeeProfession;
import ru.sandmangroup.sandgame.entity.employee.ProfessionLevel;

import java.net.ContentHandler;
import java.util.List;
import java.util.UUID;

@Repository
public interface ProfessionLevelRepository extends JmixDataRepository<ProfessionLevel, UUID> {
    List<ProfessionLevel> findAllByEmployeeProfession(EmployeeProfession editedEntity, PageRequest pageRequest, JmixDataRepositoryContext jmixDataRepositoryContext);
}