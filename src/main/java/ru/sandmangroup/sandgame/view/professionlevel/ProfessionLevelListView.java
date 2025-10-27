package ru.sandmangroup.sandgame.view.professionlevel;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;
import ru.sandmangroup.sandgame.entity.employee.ProfessionLevel;
import ru.sandmangroup.sandgame.view.main.MainView;


@Route(value = "profession-levels", layout = MainView.class)
@ViewController(id = "sdg_ProfessionLevel.list")
@ViewDescriptor(path = "profession-level-list-view.xml")
@LookupComponent("professionLevelsDataGrid")
@DialogMode(width = "64em")
public class ProfessionLevelListView extends StandardListView<ProfessionLevel> {
}