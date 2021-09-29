package com.example.bluerayapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.bluerayapp.R;
import com.example.bluerayapp.Adapters.ShoppingAdapter;
import com.example.bluerayapp.model.ShoppingArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ShoppingFragment extends Fragment {


    RecyclerView recyclerView;
    ShoppingAdapter adapter;
    ArrayList<ShoppingArray>list;
    RecyclerView.LayoutManager lm;

    public ShoppingFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_shopping, container, false);
        recyclerView=view.findViewById(R.id.rv);

        lm=new GridLayoutManager(getActivity(),1);
        recyclerView.setLayoutManager(lm);
        list=new ArrayList<>();


       getInformation();

        return view;
    }
    void getInformation(){
        StringRequest stringRequest=new StringRequest(Request.Method.GET, "http://esh7anly.br-ws.com/web/app/esh7anly/get-category", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array=new JSONArray(response);
                    for (int i=0;i<response.length();i++){
                        JSONObject jsonObject=array.getJSONObject(i);
                        list.add(new ShoppingArray(jsonObject.getString("field_category_image"),jsonObject.getString("name")));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                adapter=new ShoppingAdapter(getActivity(),list);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "error", Toast.LENGTH_SHORT).show();
            }
        }){

        };
        RequestQueue requestQueue= Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }
}