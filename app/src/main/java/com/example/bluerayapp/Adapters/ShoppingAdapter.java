package com.example.bluerayapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bluerayapp.R;
import com.example.bluerayapp.model.ShoppingArray;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.RVholder> {
    Context context;
    ArrayList <ShoppingArray> list;

    public ShoppingAdapter(Context context, ArrayList<ShoppingArray> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RVholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.rv_design,parent,false);
        return new RVholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVholder holder, int position) {
        ShoppingArray array=list.get(position);
        holder.onBind(array);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RVholder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public RVholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            textView=itemView.findViewById(R.id.textView);
        }
        void  onBind(ShoppingArray array) {
            
            Picasso.with(context).load("http://esh7anly.br-ws.com/"+array.getImage()).into(imageView);
            textView.setText(array.getText());
        }
    }

}
