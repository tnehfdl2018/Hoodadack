package com.example.hoodadack.ui.urlList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.hoodadack.R;

import java.util.ArrayList;

public class AdapterForInsertUrl extends BaseAdapter {
    private ImageButton addBtn;
    private ImageButton removeBtn;
    // 리스트뷰 데이터를 담을 arrayList생성
    ArrayList<UrlDataItems> arrayList = new ArrayList<>();
    private int indexCount = 1;

    @Override
    public int getCount() { // arrayList크키를 리턴
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) { // 현재위치의 arrayList담긴 데이터를 리턴
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Context context = parent.getContext();

        if (convertView == null) { // 뷰가 있는지 확인 없다면 inflater로 생성한다.
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_custom_listview_add_url, parent, false);
        }

        // 이미지버튼 생성
        addBtn = convertView.findViewById(R.id.addUrl);
        removeBtn = convertView.findViewById(R.id.removeUrl);

        if (arrayList.size() == 1) {
            addBtn.setVisibility(View.VISIBLE);
            removeBtn.setVisibility(View.INVISIBLE);
        }

        // 추가 버튼 클릭시 리스트 항목 추가
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AdapterForInsertUrl adapterForInsertUrl = new AdapterForInsertUrl();
                UrlDataItems urlDataItems = new UrlDataItems();

                arrayList.add(indexCount, urlDataItems); // 새로운 데이터를 가진 항목을 리스트에 추가

                indexCount++;

                adapterForInsertUrl.notifyDataSetChanged();
            }
        });

        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UrlDataItems urlDataItems = new UrlDataItems();
                if (arrayList.size() > 1) {
                    Log.i("지이이이이워", String.valueOf(v.getId()));
                    arrayList.remove(urlDataItems);
                } else {
                    Log.i("지이이이이워", String.valueOf(v.getId()));
                }
            }
        });
        return convertView;
    }


    // 리스트뷰내에 항목을 추가하기 위해 리스트에 항목을 추가한다.
    public void addItem() {
        UrlDataItems urlDataItems = new UrlDataItems();

        arrayList.add(0, urlDataItems);

    }
}
