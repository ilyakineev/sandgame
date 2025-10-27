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

@JmixEntity
@Table(name = "SDG_EMPLOYEE_PROFESSION", indexes = {
        @Index(name = "IDX_SDG_EMPLOYEE_PROFESSION_EMPLOYEE", columnList = "EMPLOYEE_ID")
})
@Entity(name = "sdg_EmployeeProfession")
@Getter
@Setter
public class EmployeeProfession {
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

    @NotNull(message = "{msg://ru.sandmangroup.sandgame.entity.employee/EmployeeProfession.name.validation.NotNull}")
    @InstanceName
    @Column(name = "NAME")
    private String name;

    @JoinColumn(name = "EMPLOYEE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    @OneToMany(mappedBy = "employeeProfession")
    private List<ProfessionLevel> professionLevels;

    @JoinTable(name = "SDG_EMPLOYEE_EMPLOYEE_PROFESSION_LINK",
            joinColumns = @JoinColumn(name = "EMPLOYEE_PROFESSION_ID"),
            inverseJoinColumns = @JoinColumn(name = "EMPLOYEE_ID"))
    @ManyToMany
    private List<Employee> employees;

}