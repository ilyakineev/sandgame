package ru.sandmangroup.sandgame.view.department;

import com.vaadin.flow.router.Route;
import io.jmix.core.LoadContext;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import ru.sandmangroup.sandgame.entity.Department;
import ru.sandmangroup.sandgame.repository.DepartmentRepository;
import ru.sandmangroup.sandgame.view.main.MainView;

import java.util.Collection;
import java.util.List;

import static io.jmix.core.repository.JmixDataRepositoryUtils.buildPageRequest;
import static io.jmix.core.repository.JmixDataRepositoryUtils.buildRepositoryContext;

@Route(value = "departments", layout = MainView.class)
@ViewController(id = "sdg_Department.list")
@ViewDescriptor(path = "department-list-view.xml")
@LookupComponent("departmentsDataGrid")
@DialogMode(width = "64em")
public class DepartmentListView extends StandardListView<Department> {

    @Autowired
    private DepartmentRepository repository;

    @Install(to = "departmentsDl", target = Target.DATA_LOADER)
    private List<Department> loadDelegate(LoadContext<Department> context) {
        return repository.findAll(buildPageRequest(context), buildRepositoryContext(context)).getContent();
    }

    @Install(to = "departmentsDataGrid.removeAction", subject = "delegate")
    private void departmentsDataGridRemoveDelegate(final Collection<Department> collection) {
        repository.deleteAll(collection);
    }
}