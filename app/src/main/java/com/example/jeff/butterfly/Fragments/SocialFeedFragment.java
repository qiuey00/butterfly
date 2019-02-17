package com.example.jeff.butterfly.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.jeff.butterfly.Helpers.DbHelper;
import com.example.jeff.butterfly.R;
import com.example.jeff.butterfly.RecyclerViewAdapter;

public class SocialFeedFragment extends Fragment {

	private DbHelper db;
	private AppCompatActivity activity;
    private View view;
    private RecyclerView feed;

    @Override
	public void onCreate(Bundle savedInstanceState) {
        Log.e("----------------------------","ONCREATE");
        super.onCreate(savedInstanceState);
        db = new DbHelper(this.getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e("----------------------------","ONCREATEVIEW");
        return inflater.inflate(R.layout.socialpage, container, false);
    }
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        view = getView();
        activity = (AppCompatActivity) getActivity();
        initRecyclerView();
    }

    private void initRecyclerView(){
    	Log.e("----------------------------","-------------------------------------");
        feed = view.findViewById(R.id.socialFeed);
        feed.removeAllViews();
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(activity,db.getSocialPosts());
        feed.setAdapter(adapter);
        feed.setLayoutManager(new LinearLayoutManager(activity));
    }
}