package ru.sandmangroup.sandgame.view.employeeprofession;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;
import ru.sandmangroup.sandgame.entity.employee.EmployeeProfession;
import ru.sandmangroup.sandgame.view.main.MainView;


@Route(value = "employee-professions", layout = MainView.class)
@ViewController(id = "sdg_EmployeeProfession.list")
@ViewDescriptor(path = "employee-profession-list-view.xml")
@LookupComponent("employeeProfessionsDataGrid")
@DialogMode(width = "64em")
public class EmployeeProfessionListView extends StandardListView<EmployeeProfession> {
}