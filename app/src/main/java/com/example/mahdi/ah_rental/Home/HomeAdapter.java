package com.example.mahdi.ah_rental.Home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mahdi.ah_rental.R;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    private Context context;
    private List<Home> HomeList;


    public HomeAdapter(Context context, List<Home> homeList) {
        this.context = context;
        HomeList = homeList;
    }



    @NonNull

    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =  inflater.inflate(R.layout.home_cardview_item,null);
        HomeViewHolder holder = new HomeViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        Home home = HomeList.get(position);
        holder.price.setText(home.getPrice());
        holder.proparty.setText(home.getProparty());
        holder.bathroom.setText(home.getBathroom());
        holder.capacity.setText(home.getCapacity());
        holder.address.setText(home.getAddress());
        holder.date.setText(home.getDate());

    }

    @Override
    public int getItemCount() {
        return HomeList.size();
    }

    class HomeViewHolder extends RecyclerView.ViewHolder{
        ImageView image ;
        TextView  price, proparty, bathroom, capacity, address, date;
        public HomeViewHolder(View itemView) {
            super(itemView);
            price = itemView.findViewById(R.id.tv_price_home_card);
            proparty = itemView.findViewById(R.id.tv_proparty_home_card);
            bathroom = itemView.findViewById(R.id.tv_bathroom_home_card);
            capacity = itemView.findViewById(R.id.tv_capacity_home_card);
            address = itemView.findViewById(R.id.tv_address_home_card);
            date = itemView.findViewById(R.id.tv_date_home_card);
        }
    }


}
