package com.example.user.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by user on 2017-05-31.
 */

public class CreateActivity extends Activity {

    Activity act = this;
    GridView appviewer;
    private List<ResolveInfo> apps;
    private PackageManager pm;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(Intent.ACTION_MAIN,null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);

        pm = getPackageManager();
        apps = pm.queryIntentActivities(intent,0);

        setContentView(R.layout.create_group);

        appviewer = (GridView)findViewById(R.id.appview);
        appviewer.setAdapter(new gridAdapter());
    }

    public class gridAdapter extends BaseAdapter {
        LayoutInflater inflater;

        public gridAdapter(){
            inflater = (LayoutInflater) act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        public final int getCount() {
            return apps.size();
        }
        public final Object getItem(int position){
            return apps.get(position);
        }
        public final long getItemId(int position) {
            return position;
        }
        public View getView(int position, View convertView, ViewGroup parent){
            if(convertView == null){
                convertView = inflater.inflate(R.layout.items,parent,false);
            }
            final ResolveInfo info = apps.get(position);
            ImageView imageView = (ImageView)convertView.findViewById(R.id.apps);
            TextView textView = (TextView)convertView.findViewById(R.id.appsname);
            imageView.setImageDrawable(info.activityInfo.loadIcon(getPackageManager()));
            textView.setText(info.activityInfo.loadLabel(pm).toString());

            Log.v("[program]",info.activityInfo.packageName+","+info.activityInfo.name);

            return convertView;
        }
    }
}

