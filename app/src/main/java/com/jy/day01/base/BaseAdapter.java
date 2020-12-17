package com.jy.day01.base;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public  abstract class BaseAdapter<D> extends RecyclerView.Adapter {
    List<D> mData;
    Context context;

    public BaseAdapter(List<D> mData, Context context) {
        this.mData = mData;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(getLayout(),parent,false);
        final VH vh = new VH(view);
        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(iListClick!=null){
                    iListClick.itemClick(vh.getLayoutPosition());
                }
            }
        });

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        bindData(mData.get(position),(VH)holder);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    protected abstract int getLayout();

    protected  abstract  void  bindData(D data,VH vh);

    //定义接口回调
    public interface  IListClick{
        void itemClick(int pos);
    }
    IListClick iListClick;

    public void setiListClick(IListClick iListClick) {
        this.iListClick = iListClick;
    }

    public class VH extends RecyclerView.ViewHolder{
        SparseArray views=new SparseArray();
        public VH(@NonNull View itemView) {
            super(itemView);
        }
        public  View getViewByid(int id){
            View view= (View) views.get(id);
            if(view==null){
                view=itemView.findViewById(id);
                views.append(id,view);
            }
            return view;
        }
    }
}
