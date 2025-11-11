package ru.sandmangroup.sandgame.view.employeecard;


import com.vaadin.flow.router.Route;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.flowui.model.InstanceLoader;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import ru.sandmangroup.sandgame.entity.User;
import ru.sandmangroup.sandgame.entity.employee.Employee;
import ru.sandmangroup.sandgame.view.main.MainView;

@Route(value = "Employee-card", layout = MainView.class)
@ViewController(id = "sdg_EmployeeCard")
@ViewDescriptor(path = "Employee-card.xml")
public class EmployeeCard extends StandardView {
    @Autowired
    private CurrentAuthentication currentAuthentication;
    @ViewComponent
    private InstanceLoader<Employee> employeeDl;

    @Subscribe
    public void onBeforeShow(final BeforeShowEvent event) {
        final User user = (User) currentAuthentication.getUser();
        employeeDl.setParameter("user", user);
        employeeDl.load();
    }
}