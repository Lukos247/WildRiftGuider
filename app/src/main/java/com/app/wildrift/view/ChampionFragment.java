package com.app.wildrift.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.app.wildrift.R;
import com.app.wildrift.presenter.MyData;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChampionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChampionFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private int id;
    private String localization;
    private ImageView imageViewIcon;
    private TextView championName;
    private TextView championDescription;
    private TextView championType;


    private RecyclerView rvItems;
    private RecyclerView rvRunes;


    public ChampionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChampionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChampionFragment newInstance(String param1, String param2) {
        ChampionFragment fragment = new ChampionFragment();
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
            id = getArguments().getInt("championId");
            localization = getArguments().getString("localization");
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_champion, container, false);
        initGUI(view);


        for (int i = 0; i < MyData.championList.size(); i++) {

            if (id == Integer.parseInt(MyData.championList.get(i).getId())) {
                if (localization.equals(MyData.championList.get(i).getLocalization())) {

                    Picasso.get().load(MyData.championList.get(i).getChampionIcon()).into(imageViewIcon);

                    championName.setText(MyData.championList.get(i).getChampionName());
                    championDescription.setText(MyData.championList.get(i).getChampionShortDescription());
                    championType.setText(MyData.championList.get(i).getChampionType());


                }

            }

        }

        return view;
    }

    private void initGUI(View view) {

        imageViewIcon = view.findViewById(R.id.image_view_champion_icon);
        championName = view.findViewById(R.id.tv_champion_name);
        championDescription = view.findViewById(R.id.tv_champion_description);
        championType = view.findViewById(R.id.tv_champion_type);

        rvItems = view.findViewById(R.id.rv_items_list);
        rvRunes = view.findViewById(R.id.rv_runes_list);
    }
}