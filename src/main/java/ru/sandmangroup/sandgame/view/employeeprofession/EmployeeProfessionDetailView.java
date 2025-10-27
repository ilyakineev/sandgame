package ru.sandmangroup.sandgame.view.employeeprofession;

import com.vaadin.flow.data.selection.SelectionEvent;
import com.vaadin.flow.router.Route;
import io.jmix.core.LoadContext;
import io.jmix.flowui.component.grid.DataGrid;
import io.jmix.flowui.model.CollectionLoader;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import ru.sandmangroup.sandgame.entity.employee.EmployeeProfession;
import ru.sandmangroup.sandgame.entity.employee.EmployeeSkill;
import ru.sandmangroup.sandgame.entity.employee.ProfessionLevel;
import ru.sandmangroup.sandgame.repository.EmployeeSkillRepository;
import ru.sandmangroup.sandgame.view.main.MainView;

import java.util.List;

import static io.jmix.core.repository.JmixDataRepositoryUtils.buildPageRequest;
import static io.jmix.core.repository.JmixDataRepositoryUtils.buildRepositoryContext;

@Route(value = "employee-professions/:id", layout = MainView.class)
@ViewController(id = "sdg_EmployeeProfession.detail")
@ViewDescriptor(path = "employee-profession-detail-view.xml")
@EditedEntityContainer("employeeProfessionDc")
public class EmployeeProfessionDetailView extends StandardDetailView<EmployeeProfession> {
    @ViewComponent
    private DataGrid<ProfessionLevel> professionLevelsDataGrid;
    @Autowired
    private EmployeeSkillRepository employeeSkillRepository;
    @ViewComponent
    private CollectionLoader<EmployeeSkill> employeeSkillsDl;

    @Install(to = "employeeSkillsDl", target = Target.DATA_LOADER)
    private List<EmployeeSkill> employeeSkillsDlLoadDelegate(final LoadContext<EmployeeSkill> loadContext) {
        ProfessionLevel singleSelectedItem = professionLevelsDataGrid.getSingleSelectedItem();
        return employeeSkillRepository.findAllByProfessionLevels(singleSelectedItem, buildPageRequest(loadContext), buildRepositoryContext(loadContext));
    }

    @Subscribe("professionLevelsDataGrid")
    public void onProfessionLevelsDataGridSelection(final SelectionEvent<DataGrid<ProfessionLevel>, ProfessionLevel> event) {
        employeeSkillsDl.load();
    }
}