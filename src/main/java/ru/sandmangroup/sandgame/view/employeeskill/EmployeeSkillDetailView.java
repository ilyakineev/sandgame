package ru.sandmangroup.sandgame.view.employeeskill;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import ru.sandmangroup.sandgame.entity.employee.EmployeeSkill;
import ru.sandmangroup.sandgame.view.main.MainView;

@Route(value = "employee-skills/:id", layout = MainView.class)
@ViewController(id = "sdg_EmployeeSkill.detail")
@ViewDescriptor(path = "employee-skill-detail-view.xml")
@EditedEntityContainer("employeeSkillDc")
public class EmployeeSkillDetailView extends StandardDetailView<EmployeeSkill> {
}