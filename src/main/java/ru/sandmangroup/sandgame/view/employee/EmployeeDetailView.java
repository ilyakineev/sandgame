package ru.sandmangroup.sandgame.view.employee;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;
import ru.sandmangroup.sandgame.entity.employee.Employee;
import ru.sandmangroup.sandgame.view.main.MainView;

@Route(value = "employees/:id", layout = MainView.class)
@ViewController(id = "sdg_Employee.detail")
@ViewDescriptor(path = "employee-detail-view.xml")
@EditedEntityContainer("employeeDc")
public class EmployeeDetailView extends StandardDetailView<Employee> {
}