package practicaltask.riseapps.com.practicaltask.ui.menu;

import java.util.LinkedList;
import java.util.List;

import practicaltask.riseapps.com.practicaltask.core.App;
import practicaltask.riseapps.com.practicaltask.ui.base.BasePresenter;

public class MenuPresenter extends BasePresenter<MenuView> {
    public void fillRegionsData(final List<String> regionsData) {
        final List<String> regionsResultList = new LinkedList<>(regionsData);
        final String lastRegion = App.getInstance().getPreferences().getLastRegion();
        if (!lastRegion.isEmpty()) {
            if (regionsResultList.contains(lastRegion)) {
                regionsResultList.remove(lastRegion);
                regionsResultList.add(0, lastRegion);
            }
        }

        getView().fillMenuByData(regionsResultList);
    }
}
