package com.example.hoodadack.ui.videoList;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hoodadack.R;

import java.util.ArrayList;

public class AdapterForShowVideo extends BaseAdapter {

    ArrayList<VideoListDataItems> arrayList = new ArrayList<>();

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_custom_listview_show_video, parent, false);
        }

        ImageView thumneil = convertView.findViewById(R.id.thumneil);
        TextView mainTitle = convertView.findViewById(R.id.mainTitle);
        TextView subTitle = convertView.findViewById(R.id.subTitle);
        ImageView icon = convertView.findViewById(R.id.icon);

        VideoListDataItems videoListDataItems = (VideoListDataItems) getItem(position);

        thumneil.setImageDrawable(videoListDataItems.getThumneil());
        mainTitle.setText(videoListDataItems.getMainTitle());
        subTitle.setText(videoListDataItems.getSubTitle());
        icon.setImageDrawable(videoListDataItems.getIcon());

        return convertView;
    }

    public void addItem(Drawable thumneil, String mainTitle, String subTitle, Drawable icon) {
        VideoListDataItems videoListDataItems = new VideoListDataItems();

        videoListDataItems.setThumneil(thumneil);
        videoListDataItems.setMainTitle(mainTitle);
        videoListDataItems.setSubTitle(subTitle);
        videoListDataItems.setIcon(icon);

        arrayList.add(videoListDataItems);
    }
}
