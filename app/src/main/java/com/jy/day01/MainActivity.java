package com.jy.day01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jy.day01.base.BaseActivity;
import com.jy.day01.interfaces.list.IList;
import com.jy.day01.model.bean.Bean;
import com.jy.day01.persenter.ListPersenter;
import com.jy.day01.ui.adapter.ListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<ListPersenter> implements IList.View {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.btn_ok)
    Button btnOk;
    private ArrayList<Bean.DataBean> list;
    private ListAdapter listAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        list = new ArrayList<>();

        recycler.setLayoutManager(new LinearLayoutManager(this));
        listAdapter = new ListAdapter(list, this);
        recycler.setAdapter(listAdapter);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).isSelect() != list.get(i).isLv()) {
                        Toast.makeText(MainActivity.this,  list.get(i).getName(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    protected ListPersenter createPersenter() {
        return new ListPersenter(this);
    }

    @Override
    protected void initData() {
        presenter.getlist();
    }

    @Override
    public void getlist(Bean bean) {
        List<Bean.DataBean> data = bean.getData();
        list.addAll(data);
        for (int i = 0; i < data.size(); i++) {
            list.get(i).setLv(list.get(i).isSelect());
        }
        listAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}