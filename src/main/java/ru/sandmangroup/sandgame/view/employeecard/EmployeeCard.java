package ru.sandmangroup.sandgame.view.employeecard;


import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.StandardView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import ru.sandmangroup.sandgame.view.main.MainView;

@Route(value = "Employee-card", layout = MainView.class)
@ViewController(id = "sdg_EmployeeCard")
@ViewDescriptor(path = "Employee-card.xml")
public class EmployeeCard extends StandardView {
}