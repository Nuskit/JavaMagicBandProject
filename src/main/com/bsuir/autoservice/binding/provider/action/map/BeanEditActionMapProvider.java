package main.com.bsuir.autoservice.binding.provider.action.map;

import com.google.inject.Inject;
import com.google.inject.Injector;
import main.com.bsuir.autoservice.command.bean.crud.EditBeanCommand;
import main.com.bsuir.autoservice.command.param.CrudPageInfo;
import main.com.bsuir.autoservice.command.bean.page.crud.GetBeanEditPageCommand;
import main.com.bsuir.autoservice.command.param.EditPageInfo;

public class BeanEditActionMapProvider extends ActionMapProvider {

    @Inject
    private BeanEditActionMapProvider(Injector injector){
        super(injector);
    }

    @Override
    protected void initMap(Injector injector){
        putAction("get", CrudPageInfo.class, injector.getInstance(GetBeanEditPageCommand.class));
        putAction("edit", EditPageInfo.class, injector.getInstance(EditBeanCommand.class));
    }
}