package practicaltask.riseapps.com.practicaltask.ui.menu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import practicaltask.riseapps.com.practicaltask.R;
import practicaltask.riseapps.com.practicaltask.ui.MainActivity;
import practicaltask.riseapps.com.practicaltask.ui.adapter.MenuAdapter;
import practicaltask.riseapps.com.practicaltask.ui.base.BaseActivity;

public class MenuActivity extends BaseActivity implements MenuView, View.OnClickListener {
    @BindView(R.id.rvMenu)
    RecyclerView rvMenu;

    private final MenuPresenter menuPresenter = new MenuPresenter();
    private final List<String> regionsData = new ArrayList<>();

    @Override
    protected int provideLayout() {
        return R.layout.activity_menu;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        menuPresenter.setView(this);
        ButterKnife.bind(this);
        fillRegionsData();
        initRecyclerView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        menuPresenter.setView(null);
    }

    @Override
    public void onClick(View v) {
        moveToScreen(MainActivity.class);
    }

    private void fillRegionsData() {
        regionsData.addAll(Arrays.asList(getResources().getStringArray(R.array.regionNames)));
    }

    private void initRecyclerView() {
        final RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        final RecyclerView.Adapter adapter = new MenuAdapter(regionsData, this);
        rvMenu.setLayoutManager(linearLayoutManager);
        rvMenu.setAdapter(adapter);
    }
}
