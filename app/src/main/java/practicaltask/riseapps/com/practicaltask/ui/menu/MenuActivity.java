package practicaltask.riseapps.com.practicaltask.ui.menu;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.Arrays;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import practicaltask.riseapps.com.practicaltask.R;
import practicaltask.riseapps.com.practicaltask.core.App;
import practicaltask.riseapps.com.practicaltask.ui.MainActivity;
import practicaltask.riseapps.com.practicaltask.ui.adapter.MenuAdapter;
import practicaltask.riseapps.com.practicaltask.ui.base.BaseActivity;
import practicaltask.riseapps.com.practicaltask.ui.callback.OnMenuItemClickListener;
import practicaltask.riseapps.com.practicaltask.ui.region_countries.RegionCountriesActivity;

public class MenuActivity extends BaseActivity implements MenuView, OnMenuItemClickListener {
    @BindView(R.id.rvMenu)
    RecyclerView rvMenu;

    private final MenuPresenter menuPresenter = new MenuPresenter();

    @Override
    protected int provideLayout() {
        return R.layout.activity_menu;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        menuPresenter.setView(this);
        ButterKnife.bind(this);
        menuPresenter.fillRegionsData(Arrays.asList(getResources().getStringArray(R.array.regionNames)));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        menuPresenter.setView(null);
    }

    @Override
    public void onMenuItemClicked(View v, String itemName) {
        App.getInstance().getPreferences().setLastRegion(itemName);
        moveToScreen(RegionCountriesActivity.class);
    }

    @Override
    public void fillMenuByData(@NonNull final List<String> menuData) {
        final RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        final RecyclerView.Adapter adapter = new MenuAdapter(menuData, this);
        rvMenu.setLayoutManager(linearLayoutManager);
        rvMenu.setAdapter(adapter);
    }
}
