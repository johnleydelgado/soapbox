package com.robert.soapbox.View;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.robert.soapbox.Adapter.post_adapter;
import com.robert.soapbox.Model.postData;
import com.robert.soapbox.R;
import com.roger.catloadinglibrary.CatLoadingView;

import org.json.JSONObject;

import java.util.ArrayList;

import eu.amirs.JSON;

public class ContentQue extends Fragment {


    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<postData> data;
    public static View.OnClickListener myOnClickListener;
    public static int numberDrawable;
    CatLoadingView mView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_contentque, parent, false);
        //Loading Start
        mView = new CatLoadingView();
        mView.setCancelable(false);
        mView.show(getFragmentManager(), "showLoading");

        recyclerView = rootView.findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        APICalls();
        return rootView;
    }

    private void APICalls(){
        data = new ArrayList<postData>();


       // String memberTitle = getIntent().getStringExtra("membershipTitle");

        AndroidNetworking.get("https://bethub.pro/wp-json/bethubpro/v1/posts/category/target-racing")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        mView.dismiss();
                        JSON json = new JSON(response);
                        JSON post = json.key("posts");


                        for (int i = 0; i < post.count(); i++) {
                            JSON parseData = post.index(i);
                            String title = parseData.key("post_title").stringValue();
                            String content = parseData.key("post_content").stringValue();
                            String date = parseData.key("post_date").stringValue();
                            String status = parseData.key("post_status").stringValue();
                            String color;

                            if(status.equals("publish")) {
	                            color = "#008000";
                            }else{
                                color = "#FF0000";
                            }

                            Log.d("tag1","title is :"+status);
                            data.add(new postData(content,"",title,status,date,"",color));
                        }

                        adapter = new post_adapter(data);
                        recyclerView.setAdapter(adapter);


                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });

    }


    private static class MyOnClickListener implements View.OnClickListener {

        private final Context context;

        private MyOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {

        }

    }

}
