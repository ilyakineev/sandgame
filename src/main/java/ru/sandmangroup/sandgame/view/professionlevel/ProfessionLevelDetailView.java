package ru.sandmangroup.sandgame.view.professionlevel;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;
import ru.sandmangroup.sandgame.entity.employee.ProfessionLevel;
import ru.sandmangroup.sandgame.view.main.MainView;

@Route(value = "profession-levels/:id", layout = MainView.class)
@ViewController(id = "sdg_ProfessionLevel.detail")
@ViewDescriptor(path = "profession-level-detail-view.xml")
@EditedEntityContainer("professionLevelDc")
public class ProfessionLevelDetailView extends StandardDetailView<ProfessionLevel> {
}