package com.app.wildrift.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.wildrift.R;
import com.app.wildrift.model.ItemsList;
import com.app.wildrift.model.ParentItem;
import com.app.wildrift.presenter.ItemListAdapter;
import com.app.wildrift.presenter.ItemListSctuct;
import com.app.wildrift.presenter.MyData;
import com.app.wildrift.presenter.RuneListStruct;
import com.squareup.picasso.Picasso;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ItemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ItemFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private int itemId;

    private ImageView icon;
    private TextView itemName;
    private TextView itemStats;

    RecyclerView recyclerView;
    ItemListAdapter adapter;
    RuneListStruct runeListStruct;
    List<ParentItem> parentItems;


    public ItemFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ItemFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ItemFragment newInstance(String param1, String param2) {
        ItemFragment fragment = new ItemFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //bundle.putInt("runeId", runeListStruct.getId());
            itemId = getArguments().getInt("itemId");
           // mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_item, container, false);
        recyclerView = view.findViewById(R.id.rv_item_recipe);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        adapter = new ItemListAdapter();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        //;


        initUI(view);

        for(int i=0;i<MyData.itemsList.size();i++){
            ItemsList itemsList = MyData.itemsList.get(i);
            if(itemId == Integer.parseInt(itemsList.getId())){
                 //= itemsList;
                Picasso.get().load(itemsList.getItemDescription()).into(icon);
                String itemStatsS = itemsList.getItemStats();
                String itemNameS = itemsList.getItemName();
                parentItems = itemsList.getParentItems();
                itemName.setText(itemNameS);
                itemStats.setText(itemStatsS);

            }

        }
        createMenu();

        return view;
    }


   // private
    private Collection<ItemListSctuct> getItems(){
        ArrayList<ItemListSctuct> itemList = new ArrayList<>();

        for(int i=0;i<MyData.itemsList.size();i++){

        //    ItemsList itemsList = MyData.itemsList.get(i);
        //    int id = Integer.parseInt(itemsList.getId());
        //    if(id == itemId) {
        //        for (int j = 0; j < parentItems.size(); j++) {
        //            itemList.add(new ItemListSctuct(itemsList.getItemDescription(), itemsList.getItemName(), itemsList.getItemStats(), "", Integer.parseInt(itemsList.getId())));
//
        //        }
        //    }

            ItemsList itemsList = MyData.itemsList.get(i);
//
         for(int j=0;j<parentItems.size();j++){
             int itemParentId = Integer.parseInt(parentItems.get(j).getItem());
             if(Integer.parseInt(itemsList.getId()) == itemParentId){
                 itemList.add(new ItemListSctuct(itemsList.getItemDescription(),itemsList.getItemName(),itemsList.getItemStats(),"", Integer.parseInt(itemsList.getId())));
             }
         }
        }
     //
        return itemList;
    }

    private void createMenu(){

        Collection<ItemListSctuct> items = getItems();
        adapter.setItems(items);
    }


    private void initUI(View view){

        icon = view.findViewById(R.id.item_icon);
        itemName = view.findViewById(R.id.item_name);
        itemStats = view.findViewById(R.id.tv_item_description);

    }
}