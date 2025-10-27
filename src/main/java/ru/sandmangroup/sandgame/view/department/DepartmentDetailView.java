package ru.sandmangroup.sandgame.view.department;

import com.vaadin.flow.router.Route;
import io.jmix.core.LoadContext;
import io.jmix.core.SaveContext;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import ru.sandmangroup.sandgame.entity.Department;
import ru.sandmangroup.sandgame.entity.employee.Employee;
import ru.sandmangroup.sandgame.repository.DepartmentRepository;
import ru.sandmangroup.sandgame.repository.EmployeeRepository;
import ru.sandmangroup.sandgame.view.main.MainView;

import java.util.List;
import java.util.Set;

import static io.jmix.core.repository.JmixDataRepositoryUtils.*;

@Route(value = "departments/:id", layout = MainView.class)
@ViewController(id = "sdg_Department.detail")
@ViewDescriptor(path = "department-detail-view.xml")
@EditedEntityContainer("departmentDc")
public class DepartmentDetailView extends StandardDetailView<Department> {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Install(target = Target.DATA_CONTEXT)
    private Set<Object> saveDelegate(SaveContext saveContext) {
        return Set.of(departmentRepository.save(getEditedEntity()));
    }

    @Install(to = "departmentDl", target = Target.DATA_LOADER)
    private Department loadDelegate(LoadContext<Department> context) {
        return departmentRepository.getById(extractEntityId(context), context.getFetchPlan());
    }

    @Install(to = "employeesDl", target = Target.DATA_LOADER)
    private List<Employee> employeesDlLoadDelegate(final LoadContext<Employee> loadContext) {
        return employeeRepository.findAllByDepartment(getEditedEntity(), buildPageRequest(loadContext), buildRepositoryContext(loadContext));
    }
}