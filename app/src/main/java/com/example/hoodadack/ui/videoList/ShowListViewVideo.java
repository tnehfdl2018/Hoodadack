package com.example.hoodadack.ui.videoList;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;

import com.example.hoodadack.R;

public class ShowListViewVideo extends Fragment {
    private ListView listView;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_show_listview_videolist, container, false);

        // 리스트뷰 생성
        listView = root.findViewById(R.id.videoList);

        // AdapterForShowVideo 객체 생성
        AdapterForShowVideo adapterForShowVideo = new AdapterForShowVideo();

        // AdapterFroShowVideo 내의 addItem 호출
        adapterForShowVideo.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_launcher_foreground), "mainTitle : 메인타이틀", "subTitle : 서브타이틀", ContextCompat.getDrawable(getActivity(), R.drawable.ic_launcher_foreground));

        listView.setAdapter(adapterForShowVideo);

        return root;
    }
}
