package com.app.wildrift.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.wildrift.R;
import com.app.wildrift.model.Champion;
import com.app.wildrift.model.RunesList;
import com.app.wildrift.presenter.ChampionsListSctruct;
import com.app.wildrift.presenter.MyData;
import com.app.wildrift.presenter.RuneListAdapter;
import com.app.wildrift.presenter.RuneListStruct;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RunesListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RunesListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    RecyclerView recyclerView;
    RuneListAdapter adapter;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RunesListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RunesListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RunesListFragment newInstance(String param1, String param2) {
        RunesListFragment fragment = new RunesListFragment();
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
        View inflate = inflater.inflate(R.layout.fragment_runes_list, container, false);
        recyclerView = inflate.findViewById(R.id.rv_runes_list_fragment);
        adapter = new RuneListAdapter();
        //  LinearLayoutManager linearLayout = new LinearLayoutManager(inflate.getContext());
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(inflate.getContext(), 3);
        // mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);

        createListRunes();

        return  inflate;
    }


    private void createListRunes() {

        Collection<RuneListStruct> runeListStructs = getMenu();
        adapter.setItems(runeListStructs);

    }


    private Collection<RuneListStruct> getMenu(){

        ArrayList<RuneListStruct> list = new ArrayList<RuneListStruct>();

        for(int i = 0; i< MyData.runesList.size(); i++){

            RunesList runesList = MyData.runesList.get(i);
            String runeName = runesList.getRuneName();
            String runeIcon = runesList.getRuneIcon();
            int id = Integer.parseInt(runesList.getId());
            list.add(new RuneListStruct(runeName,runeIcon,id));
   //         list.add(new ChampionsListSctruct(championIcon,championName,id,champion.getLocalization()));
        }




        return list;
    }
}