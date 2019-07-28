package com.muktadir.koadimservices.Modules.Home;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.muktadir.koadimservices.API.API_Interface;
import com.muktadir.koadimservices.API.RetrofitInstance;
import com.muktadir.koadimservices.APIDataModel.HomeData;
import com.muktadir.koadimservices.Modules.Adapters.HomeRecyclerView;
import com.muktadir.koadimservices.Modules.Home.DataModel.CategoryHome_Data;
import com.muktadir.koadimservices.Modules.Home.DataModel.ServiceHome_data;
import com.muktadir.koadimservices.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends Fragment{
   private RecyclerView recyclerView;
   private List<ServiceHome_data> ServiceHome;


    public Home() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View homeView = inflater.inflate(R.layout.home_content,container,false);
        recyclerView = homeView.findViewById(R.id.Home_content_recycler);
        boolean check = HomeContent_data(recyclerView);

        Log.i("Mydata","Text first: "+check);
        return homeView;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




//        Log.i("Mydata","Array Size of home first : "+HomeContent.size());
//        HomeContent2 = new ArrayList<>();
//        HomeContent2.add(new CategoryHome_Data(12,"mmm"));

//
//        ServiceHome = new ArrayList<>();
//        ServiceHome.add(new ServiceHome_data(12,"Clean","https://my.staging.kaodim.com/attachments/99bf6bfa332abeba21c6674e4eb8bdf96960d96c/store/fill/280/200/1bce5c68e43010add6e2776f543ca06169c35ffd5885c1995c9d07eaee88/image.jpeg"));
//        ServiceHome.add(new ServiceHome_data(23,"Services Laundry (Curtains)","https://my.staging.kaodim.com/attachments/99bf6bfa332abeba21c6674e4eb8bdf96960d96c/store/fill/280/200/1bce5c68e43010add6e2776f543ca06169c35ffd5885c1995c9d07eaee88/image.jpeg"));
//        ServiceHome.add(new ServiceHome_data(23,"Services Laundry 2","https://my.staging.kaodim.com/attachments/99bf6bfa332abeba21c6674e4eb8bdf96960d96c/store/fill/280/200/1bce5c68e43010add6e2776f543ca06169c35ffd5885c1995c9d07eaee88/image.jpeg"));
//        ServiceHome.add(new ServiceHome_data(23,"Services Laundry 1","https://my.staging.kaodim.com/attachments/99bf6bfa332abeba21c6674e4eb8bdf96960d96c/store/fill/280/200/1bce5c68e43010add6e2776f543ca06169c35ffd5885c1995c9d07eaee88/image.jpeg"));
//        ServiceHome.add(new ServiceHome_data(23,"Services Laundry 3","https://my.staging.kaodim.com/attachments/99bf6bfa332abeba21c6674e4eb8bdf96960d96c/store/fill/280/200/1bce5c68e43010add6e2776f543ca06169c35ffd5885c1995c9d07eaee88/image.jpeg"));
//
//
//        Homecontent = new ArrayList<>();
//        Homecontent.add(new CategoryHome_Data(2,"Okay1",ServiceHome));

//        ServiceHome = new ArrayList<>();
//        ServiceHome.add(new ServiceHome_data(12,"Clean","https://my.staging.kaodim.com/attachments/99bf6bfa332abeba21c6674e4eb8bdf96960d96c/store/fill/280/200/1bce5c68e43010add6e2776f543ca06169c35ffd5885c1995c9d07eaee88/image.jpeg"));
//        ServiceHome.add(new ServiceHome_data(23,"Services Laundry (Curtains)","https://my.staging.kaodim.com/attachments/99bf6bfa332abeba21c6674e4eb8bdf96960d96c/store/fill/280/200/1bce5c68e43010add6e2776f543ca06169c35ffd5885c1995c9d07eaee88/image.jpeg"));
//        ServiceHome.add(new ServiceHome_data(23,"Services Laundry 1","https://my.staging.kaodim.com/attachments/99bf6bfa332abeba21c6674e4eb8bdf96960d96c/store/fill/280/200/1bce5c68e43010add6e2776f543ca06169c35ffd5885c1995c9d07eaee88/image.jpeg"));
//        ServiceHome.add(new ServiceHome_data(23,"Services Laundry 1","https://my.staging.kaodim.com/attachments/99bf6bfa332abeba21c6674e4eb8bdf96960d96c/store/fill/280/200/1bce5c68e43010add6e2776f543ca06169c35ffd5885c1995c9d07eaee88/image.jpeg"));
//
//        Homecontent = new ArrayList<>();
//        Homecontent.add(new CategoryHome_Data(3,"Okay",ServiceHome));
//
//
//        ServiceHome = new ArrayList<>();
//        ServiceHome.add(new ServiceHome_data(12,"Clean","https://my.staging.kaodim.com/attachments/99bf6bfa332abeba21c6674e4eb8bdf96960d96c/store/fill/280/200/1bce5c68e43010add6e2776f543ca06169c35ffd5885c1995c9d07eaee88/image.jpeg"));
//        ServiceHome.add(new ServiceHome_data(23,"Services Laundryww (Curtains)","https://my.staging.kaodim.com/attachments/99bf6bfa332abeba21c6674e4eb8bdf96960d96c/store/fill/280/200/1bce5c68e43010add6e2776f543ca06169c35ffd5885c1995c9d07eaee88/image.jpeg"));
//        ServiceHome.add(new ServiceHome_data(23,"Services Laundryww","https://my.staging.kaodim.com/attachments/99bf6bfa332abeba21c6674e4eb8bdf96960d96c/store/fill/280/200/1bce5c68e43010add6e2776f543ca06169c35ffd5885c1995c9d07eaee88/image.jpeg"));
//
//        Homecontent.add(new CategoryHome_Data(2,"Okay1",ServiceHome));




        Log.i("Mydata","Text Last: ");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }
    boolean HomeContent_data(final RecyclerView recyclerView){
       final List<CategoryHome_Data> HomeContent = new ArrayList<>();
        //Data Access begin Here
        API_Interface dataservice = RetrofitInstance.getRetrofitInstance_Home().create(API_Interface.class);
        Call<List<HomeData>> call = dataservice.HomeContent();
        call.enqueue(new Callback<List<HomeData>>() {
            @Override
            public void onResponse(Call<List<HomeData>> call, Response<List<HomeData>> response) {
                Log.i("Mydata",""+response.body());
                List<HomeData> homeData = response.body();
                ServiceHome= new ArrayList<>();
                int DataSize=0;
                for (int i = 0;i<homeData.size();i++){
                    String images;
                    Log.i("Mydata","Category "+homeData.get(i).getId()+" Name "+homeData.get(i).getName());
                    DataSize=i;
                    for (int l =0;l<homeData.get(i).getService_types().size();l++){


                        Log.i("Mydata","Services "+homeData.get(DataSize).getService_types().get(l).getServiceName());
                        HomeData.ImageThumb CheckLink =homeData.get(DataSize).getService_types().get(l).getImage_thumb_url();
                        if(CheckLink == null){
                            images="No";

                        }
                        else
                        {
                            images=homeData.get(DataSize).getService_types().get(l).getImage_thumb_url().getMd();
                            Log.i("Mydata","Image link : "+images);

                        }
                        ServiceHome.add(new ServiceHome_data(homeData.get(DataSize).getService_types().get(l).getId(),homeData.get(DataSize).getService_types().get(l).getServiceName(),images));
                    }
                    Log.i("Mydata","Service Array before : "+ServiceHome.size());
                    HomeContent.add(new CategoryHome_Data(homeData.get(i).getId(),homeData.get(i).getName(),ServiceHome));
                    ServiceHome= new ArrayList<>();
                    Log.i("Mydata","Service Array after : "+ServiceHome.size());
                }
                Log.i("Mydata","Array Size of home : "+HomeContent.size());

                //  Log.i("Mydata","Array Size of home onCreate : "+this.HomeContent.size());
                HomeRecyclerView adapter = new HomeRecyclerView(getContext(),HomeContent);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setAdapter(adapter);

                Log.i("Mydata","Array Size of home : "+HomeContent.get(16).getServiceHome().size());
            }


            @Override
            public void onFailure(Call<List<HomeData>> call, Throwable t) {
                Toast.makeText(getContext(),"Sorry Fail to data"+t.toString(),Toast.LENGTH_LONG).show();
                Log.i("Mydata",""+t.toString());
            }
        });
        // Log.i("Mydata","Array Size of home Last : "+HomeContent.size());
        Log.i("Mydata","TextLast"+HomeContent.size());
        return true;
    }


}
