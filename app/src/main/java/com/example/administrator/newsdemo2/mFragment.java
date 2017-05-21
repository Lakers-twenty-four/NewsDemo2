package com.example.administrator.newsdemo2;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/5/18 0018.
 */

public class mFragment extends Fragment implements OnClickEvent {
    private static final int MSG_GET_NEWS = 1001;
    private int newsType;
    private RecyclerView rv;
    private NewsAdapter newsAdapter;
    private android.os.Handler mHandler;
    private List<News.ResultBean.DataBean> mNewsList = new ArrayList<>();
    private String urltop = "http://v.juhe.cn/toutiao/index?type=top&key=986fc7792de4983a911e9b36d37a4c41";
    private String urlshehui = "http://v.juhe.cn/toutiao/index?type=shehui&key=986fc7792de4983a911e9b36d37a4c41";
    private String urlguonei = "http://v.juhe.cn/toutiao/index?type=guonei&key=986fc7792de4983a911e9b36d37a4c41";
    private String urlyule = "http://v.juhe.cn/toutiao/index?type=yule&key=986fc7792de4983a911e9b36d37a4c41";
    private String urltiyu = "http://v.juhe.cn/toutiao/index?type=tiyu&key=986fc7792de4983a911e9b36d37a4c41";
    private String urljunshi = "http://v.juhe.cn/toutiao/index?type=junshi&key=986fc7792de4983a911e9b36d37a4c41";
    private String urlkeji = "http://v.juhe.cn/toutiao/index?type=keji&key=986fc7792de4983a911e9b36d37a4c41";
    private String urlcaijing = "http://v.juhe.cn/toutiao/index?type=caijing&key=986fc7792de4983a911e9b36d37a4c41";
    private String urlshishang = "http://v.juhe.cn/toutiao/index?type=shishang&key=986fc7792de4983a911e9b36d37a4c41";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newsType = getArguments().getInt("NEWTYPE");
        initHandler();
        getNewsFromJuhe();

    }

    private void initHandler() {
        mHandler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if(msg.what == MSG_GET_NEWS){
                    newsAdapter.changData(mNewsList);
                    return  true;
                }
                return false;
            }
        });

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_activity, container, false);
        rv = (RecyclerView) view.findViewById(R.id.rv);
        newsAdapter = new NewsAdapter(mNewsList,this);
        rv.setAdapter(newsAdapter);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    //用聚合数据接口拿数据
    public void getNewsFromJuhe() {
        //创建okHttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
        //创建一个Request
        Request request;
        switch (newsType) {
            case 1:
                request = new Request.Builder().url(urltop).build();
                break;
            case 2:
                request = new Request.Builder().url(urlshehui).build();
                break;
            case 3:
                request = new Request.Builder().url(urlguonei).build();
                break;
            case 4:
                request = new Request.Builder().url(urlyule).build();
                break;
            case 5:
                request = new Request.Builder().url(urltiyu).build();
                break;
            case 6:
                request = new Request.Builder().url(urljunshi).build();
                break;
            case 7:
                request = new Request.Builder().url(urlkeji).build();
                break;
            case 8:
                request = new Request.Builder().url(urlcaijing).build();
                break;
            case 9:
                request = new Request.Builder().url(urlshishang).build();
                break;
            default:
                request = new Request.Builder().url(urltop).build();
                break;
        }
            //new call
            Call call = mOkHttpClient.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    Gson mgson = new Gson();
                    News news = mgson.fromJson(response.body().string(), News.class);
                    mNewsList = news.getResult().getData();
                    mHandler.sendEmptyMessage(MSG_GET_NEWS);
                }
            });
        }

    @Override
    public void goToDetail(String url) {
        Intent intent = new Intent(mFragment.this.getContext(),DetailActivity.class);
        intent.putExtra("url",url);
        startActivity(intent);
    }
}
