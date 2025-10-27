package ru.sandmangroup.sandgame.entity.employee;

import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@JmixEntity
@Table(name = "SDG_PROFESSION_LEVEL", indexes = {
        @Index(name = "IDX_SDG_PROFESSION_LEVEL_EMPLOYEE_PROFESSION", columnList = "EMPLOYEE_PROFESSION_ID")
})
@Entity(name = "sdg_ProfessionLevel")
public class ProfessionLevel {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "VERSION", nullable = false)
    @Version
    private Integer version;

    @CreatedBy
    @Column(name = "CREATED_BY")
    private String createdBy;

    @CreatedDate
    @Column(name = "CREATED_DATE")
    private OffsetDateTime createdDate;

    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE")
    private OffsetDateTime lastModifiedDate;

    @DeletedBy
    @Column(name = "DELETED_BY")
    private String deletedBy;

    @DeletedDate
    @Column(name = "DELETED_DATE")
    private OffsetDateTime deletedDate;

    @NotNull(message = "{msg://ru.sandmangroup.sandgame.entity.employee/ProfessionLevel.name.validation.NotNull}")
    @InstanceName
    @Column(name = "NAME")
    private String name;

    @Column(name = "LEVEL_")
    private Short level;

    @JoinColumn(name = "EMPLOYEE_PROFESSION_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private EmployeeProfession employeeProfession;

    @JoinTable(name = "SDG_PROFESSION_LEVEL_EMPLOYEE_SKILL_LINK",
            joinColumns = @JoinColumn(name = "PROFESSION_LEVEL_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "EMPLOYEE_SKILL_ID", referencedColumnName = "ID"))
    @ManyToMany
    private List<EmployeeSkill> employeeSkills;

}