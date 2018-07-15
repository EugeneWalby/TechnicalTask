package practicaltask.riseapps.com.practicaltask.ui.menu;

import java.util.List;

import practicaltask.riseapps.com.practicaltask.ui.base.BaseView;

public interface MenuView extends BaseView {
    void fillMenuByData(final List<String> menuData);
}
