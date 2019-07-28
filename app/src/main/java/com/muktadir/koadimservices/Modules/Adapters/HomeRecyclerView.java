package com.muktadir.koadimservices.Modules.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.muktadir.koadimservices.Modules.Home.DataModel.CategoryHome_Data;
import com.muktadir.koadimservices.R;
import java.util.List;

public class HomeRecyclerView extends RecyclerView.Adapter<HomeRecyclerView.MyViewHolder>{

    private Context Mcon;
    private List<CategoryHome_Data> MyData;

    public HomeRecyclerView(Context mcon, List<CategoryHome_Data> myData) {
        Mcon = mcon;
        MyData = myData;

    }

    @NonNull
    @Override
    public HomeRecyclerView.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myhome= LayoutInflater.from(Mcon).inflate(R.layout.home_services,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(myhome);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeRecyclerView.MyViewHolder holder, int position) {
        holder.Category.setText(MyData.get(position).getName());

        //setting up service data
        RecyclerView RecylcerMy=  holder.ServiceRecycler;
        Service_HomeRecyclerView servicehome = new Service_HomeRecyclerView(Mcon,MyData.get(position).getServiceHome());
        RecylcerMy.setLayoutManager(new LinearLayoutManager(Mcon));
        RecylcerMy.setAdapter(servicehome);

    }

    @Override
    public int getItemCount() {
        return MyData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
           private TextView Category;
           private CardView MyCatLayout;
           private RecyclerView ServiceRecycler;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Category = itemView.findViewById(R.id.Category_itemName);
            MyCatLayout=itemView.findViewById(R.id.Home_category_itemCard);
            ServiceRecycler = itemView.findViewById(R.id.Home_Service);
        }
    }
}
