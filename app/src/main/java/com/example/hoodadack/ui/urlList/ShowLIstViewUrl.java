package com.example.hoodadack.ui.urlList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.widget.ListView;

import com.example.hoodadack.R;

public class ShowLIstViewUrl extends Fragment {
    private ListView listView;



    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_show_listview_urllist, container, false);

        // 리스트뷰 생성
        listView = root.findViewById(R.id.url_list);

        // AdapterForInsertUrl 객체 생성
        AdapterForInsertUrl adapterForInsertUrl = new AdapterForInsertUrl();

        // AdapterForInsertUrl내의 addItem 호출
        adapterForInsertUrl.addItem();

        listView.setAdapter(adapterForInsertUrl);

//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//
//            }
//        });
        return root;
    }
}
