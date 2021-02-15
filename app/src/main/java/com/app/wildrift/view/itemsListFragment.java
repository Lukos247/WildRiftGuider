package com.app.wildrift.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.wildrift.R;
import com.app.wildrift.model.ItemsList;
import com.app.wildrift.presenter.ItemListAdapter;
import com.app.wildrift.presenter.ItemListSctuct;
import com.app.wildrift.presenter.MyData;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link itemsListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class itemsListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerView;
    ItemListAdapter adapter;

    public itemsListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment itemsListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static itemsListFragment newInstance(String param1, String param2) {
        itemsListFragment fragment = new itemsListFragment();
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
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_items_list, container, false);
        recyclerView = view.findViewById(R.id.rv_items);
        adapter = new ItemListAdapter();
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(view.getContext(), 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        createMenu();

    //    adapter.setItems();
        return view;
    }


    private void createMenu(){

        Collection<ItemListSctuct> items = getItems();
        adapter.setItems(items);
    }

    private Collection<ItemListSctuct> getItems() {
        ArrayList<ItemListSctuct> itemList = new ArrayList<>();

        for(int i = 0; i< MyData.itemsList.size(); i++){
            ItemsList itemsList = MyData.itemsList.get(i);
            itemList.add(new ItemListSctuct(itemsList.getItemDescription(),itemsList.getItemName(),itemsList.getItemStats(),"", Integer.parseInt(itemsList.getId())));
        }


        //
        return itemList;
    }


}