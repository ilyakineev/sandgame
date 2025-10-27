package ru.sandmangroup.sandgame.view.employeeskill;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;
import ru.sandmangroup.sandgame.entity.employee.EmployeeSkill;
import ru.sandmangroup.sandgame.view.main.MainView;


@Route(value = "employee-skills", layout = MainView.class)
@ViewController(id = "sdg_EmployeeSkill.list")
@ViewDescriptor(path = "employee-skill-list-view.xml")
@LookupComponent("employeeSkillsDataGrid")
@DialogMode(width = "64em")
public class EmployeeSkillListView extends StandardListView<EmployeeSkill> {
}