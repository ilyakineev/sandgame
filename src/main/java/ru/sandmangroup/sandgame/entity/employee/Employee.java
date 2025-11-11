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
import ru.sandmangroup.sandgame.entity.Department;
import ru.sandmangroup.sandgame.entity.User;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "SDG_EMPLOYEE", indexes = {
        @Index(name = "IDX_SDG_EMPLOYEE_DEPARTMENT", columnList = "DEPARTMENT_ID"),
        @Index(name = "IDX_SDG_EMPLOYEE_USER", columnList = "USER_ID")
})
@Entity(name = "sdg_Employee")
@Setter
@Getter
public class Employee {
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

    @InstanceName
    @Column(name = "FIRST_NAME", nullable = false)
    @NotNull
    private String firstName;

    @JoinColumn(name = "USER_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(name = "MIDDLE_NAME")
    private String middleName;

    @Column(name = "LAST_NAME", nullable = false)
    @NotNull
    private String lastName;

    @JoinColumn(name = "DEPARTMENT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;

    @JoinTable(name = "SDG_EMPLOYEE_EMPLOYEE_PROFESSION_LINK",
            joinColumns = @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "EMPLOYEE_PROFESSION_ID", referencedColumnName = "ID"))
    @ManyToMany
    private List<EmployeeProfession> employeeProfession;

    @JoinColumn(name = "EMPLOYEE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    @OneToMany(mappedBy = "employee")
    private List<Employee> parentEmployee;

    @Column(name = "RATING")
    private Integer rating;

}