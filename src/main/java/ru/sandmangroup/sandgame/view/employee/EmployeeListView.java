package ru.sandmangroup.sandgame.view.employee;

import com.vaadin.flow.router.Route;
import io.jmix.core.LoadContext;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import ru.sandmangroup.sandgame.entity.employee.Employee;
import ru.sandmangroup.sandgame.repository.EmployeeRepository;
import ru.sandmangroup.sandgame.view.main.MainView;

import java.util.Collection;
import java.util.List;

import static io.jmix.core.repository.JmixDataRepositoryUtils.buildPageRequest;
import static io.jmix.core.repository.JmixDataRepositoryUtils.buildRepositoryContext;

@Route(value = "employees", layout = MainView.class)
@ViewController(id = "sdg_Employee.list")
@ViewDescriptor(path = "employee-list-view.xml")
@LookupComponent("employeesDataGrid")
@DialogMode(width = "64em")
public class EmployeeListView extends StandardListView<Employee> {

    @Autowired
    private EmployeeRepository repository;

    @Install(to = "employeesDl", target = Target.DATA_LOADER)
    private List<Employee> loadDelegate(LoadContext<Employee> context) {
        return repository.findAll(buildPageRequest(context), buildRepositoryContext(context)).getContent();
    }

    @Install(to = "employeesDataGrid.removeAction", subject = "delegate")
    private void employeesDataGridRemoveDelegate(final Collection<Employee> collection) {
        repository.deleteAll(collection);
    }
}