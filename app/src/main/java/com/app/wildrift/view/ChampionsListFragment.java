package com.app.wildrift.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import com.app.wildrift.R;
import com.app.wildrift.model.Champion;
import com.app.wildrift.presenter.ChampionsListAdapter;
import com.app.wildrift.presenter.ChampionsListSctruct;
import com.app.wildrift.presenter.MyData;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChampionsListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChampionsListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerView;
    ChampionsListAdapter championsListAdapter;
    Collection<ChampionsListSctruct> championsListSctructs;

    public ChampionsListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChampionsListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChampionsListFragment newInstance(String param1, String param2) {
        ChampionsListFragment fragment = new ChampionsListFragment();
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
        View inflate = inflater.inflate(R.layout.fragment_champions_list, container, false);
        recyclerView = inflate.findViewById(R.id.rv_champList);
      //  LinearLayoutManager linearLayout = new LinearLayoutManager(inflate.getContext());
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(inflate.getContext(), 3);
       // mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);
        championsListAdapter = new ChampionsListAdapter();
        recyclerView.setAdapter(championsListAdapter);

        createList();


        return inflate;
    }



    private void createList() {
        championsListSctructs = getMenu();
        championsListAdapter.setItems(championsListSctructs);
    }

    private Collection<ChampionsListSctruct> getMenu() {

        ArrayList<ChampionsListSctruct> list = new ArrayList<ChampionsListSctruct>();

        for(int i=0;i< MyData.championList.size();i++){

            Champion champion = MyData.championList.get(i);
            String championName = champion.getChampionName();
            String championIcon = champion.getChampionIcon();
            int id = Integer.parseInt(champion.getId());
            list.add(new ChampionsListSctruct(championIcon,championName,id,champion.getLocalization()));
        }

        list.size();
        return list;
    }


}