package com.example.administrator.newsdemo2;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


/**
 * Created by Administrator on 2017/5/18 0018.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{
    ImageView cell_img;
    TextView  cell_content;
    private List<News.ResultBean.DataBean> mNewsList;
    private OnClickEvent mEvent;

    public NewsAdapter(List<News.ResultBean.DataBean> newsList,OnClickEvent mEvent) {
        this.mEvent=mEvent;
        mNewsList=newsList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View newsView;

        //itemView位Recyclerview子项的最外层布局
        public ViewHolder(View itemView) {
            super(itemView);
            newsView=itemView;
            cell_img= (ImageView) itemView.findViewById(R.id.cell_img);
            cell_content= (TextView) itemView.findViewById(R.id.cell_content);
        }
    }

    //用于创建viewholder对象
    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cell_activity,parent,false);

        final ViewHolder holder=new ViewHolder(view);
        holder.newsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position= holder.getAdapterPosition();
                News.ResultBean.DataBean news = mNewsList.get(position);
                String url = news.getUrl();
                mEvent.goToDetail(url);
            }
        });
        return holder;
        }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        News.ResultBean.DataBean news = mNewsList.get(position);
        cell_content.setText(news.getTitle());
        Glide.with(cell_img.getContext())
                .load(news.getThumbnail_pic_s())
                .into(cell_img);
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    public void changData(List<News.ResultBean.DataBean> newsList) {
        mNewsList = newsList;
        notifyDataSetChanged();
    }
}
