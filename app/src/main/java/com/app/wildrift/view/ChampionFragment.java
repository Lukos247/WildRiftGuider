package com.app.wildrift.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.wildrift.R;
import com.app.wildrift.model.Ability;
import com.app.wildrift.model.ChampionRecommendedItemsById;
import com.app.wildrift.model.ChampionRecommendedRunesById;
import com.app.wildrift.model.ItemsList;
import com.app.wildrift.model.RunesList;
import com.app.wildrift.presenter.AbilityAdapter;
import com.app.wildrift.presenter.ChampionsListSctruct;
import com.app.wildrift.presenter.ItemListAdapter;
import com.app.wildrift.presenter.ItemListSctuct;
import com.app.wildrift.presenter.MyData;
import com.app.wildrift.presenter.RuneListAdapter;
import com.app.wildrift.presenter.RuneListStruct;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
    private RecyclerView rvAbilities;

    private RuneListAdapter runeListAdapter;
    private AbilityAdapter abilityAdapter;
    private ItemListAdapter itemListAdapter;

    private Collection<RuneListStruct> runeListStructs;
    List<ChampionRecommendedRunesById> championRecommendedRunesById;
    List<ChampionRecommendedItemsById> championRecommendedItemsById;
    List<Ability> abilities;
    Collection<ItemListSctuct> itemList;

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
                    championRecommendedRunesById = MyData.championList.get(i).getChampionRecommendedRunesById();
                    abilities = MyData.championList.get(i).getAbilities();
                    championRecommendedItemsById = MyData.championList.get(i).getChampionRecommendedItemsById();
                    championName.setText(MyData.championList.get(i).getChampionName());
                    championDescription.setText(MyData.championList.get(i).getChampionShortDescription());
                    championType.setText(MyData.championList.get(i).getChampionType());
                }

            }

        }


        createListRunes();
        createMenuAbilities();
        createItems();


        return view;
    }

    private void initGUI(View view) {

        imageViewIcon = view.findViewById(R.id.image_view_champion_icon);
        championName = view.findViewById(R.id.tv_champion_name);
        championDescription = view.findViewById(R.id.tv_champion_description);
        championType = view.findViewById(R.id.tv_champion_type);

        rvItems = view.findViewById(R.id.rv_items_list);
        rvRunes = view.findViewById(R.id.rv_runes_list);
        rvAbilities = view.findViewById(R.id.rv_items_ability);

        LinearLayoutManager linearLayout = new LinearLayoutManager(view.getContext());
        LinearLayoutManager linearLayoutItem = new LinearLayoutManager(view.getContext());
        LinearLayoutManager linearLayoutAbility = new LinearLayoutManager(view.getContext());
        linearLayout.setOrientation(RecyclerView.HORIZONTAL);
        linearLayoutItem.setOrientation(RecyclerView.HORIZONTAL);
        linearLayoutAbility.setOrientation(RecyclerView.VERTICAL);


        runeListAdapter = new RuneListAdapter();
        abilityAdapter = new AbilityAdapter();
        itemListAdapter = new ItemListAdapter();


        rvRunes.setLayoutManager(linearLayout);
        rvItems.setLayoutManager(linearLayoutItem);
        rvAbilities.setLayoutManager(linearLayoutAbility);

        rvRunes.setAdapter(runeListAdapter);
        rvItems.setAdapter(itemListAdapter);
        rvAbilities.setAdapter(abilityAdapter);


    }

    private void createListRunes() {

        runeListStructs = getMenu();
        runeListAdapter.setItems(runeListStructs);

    }

    private void createMenuAbilities(){
        abilities = getAbilityMenu();
        abilityAdapter.setItems(abilities);

    }

    private void createItems(){

        itemList = getItemsMenu();
        itemListAdapter.setItems(itemList);

    }

    private Collection<ItemListSctuct> getItemsMenu() {
        ArrayList<ItemListSctuct> list = new ArrayList<>();
        for(int i=0;i<MyData.itemsList.size();i++){
            ItemsList itemsList = MyData.itemsList.get(i);
            if(itemsList.getId().equals(championRecommendedItemsById.get(0).getItemOne()) ||
                    itemsList.getId().equals(championRecommendedItemsById.get(0).getItemTwo()) ||
                    itemsList.getId().equals(championRecommendedItemsById.get(0).getItemThree()) ||
                    itemsList.getId().equals(championRecommendedItemsById.get(0).getItemFour()) ||
                    itemsList.getId().equals(championRecommendedItemsById.get(0).getItemFive()) ||
                    itemsList.getId().equals(championRecommendedItemsById.get(0).getItemSix()) ||
                    itemsList.getId().equals(championRecommendedItemsById.get(0).getItemWard()))
            {
                    list.add(new ItemListSctuct(itemsList.getItemDescription(),itemsList.getItemName(),itemsList.getItemStats(),"", Integer.parseInt(itemsList.getId())));

            }

        }


        return list;
    }

    private List<Ability> getAbilityMenu() {
        ArrayList<Ability> list = new ArrayList<>();

        for(int i=0;i<abilities.size();i++){
            list.add(new Ability(abilities.get(i).getAbilityName(),abilities.get(i).getAbilityDescription(),abilities.get(i).getAbilityIcon()));
        }



        return list;
    }




    private Collection<RuneListStruct> getMenu() {
        ArrayList<RuneListStruct> list = new ArrayList<>();

        for(int i=0;i<MyData.runesList.size();i++){
            if(MyData.runesList.get(i).getId().equals(championRecommendedRunesById.get(0).getRuneOne()) ||
                    MyData.runesList.get(i).getId().equals(championRecommendedRunesById.get(0).getRuneTwo()) ||
                    MyData.runesList.get(i).getId().equals(championRecommendedRunesById.get(0).getRuneThree()) ||
                    MyData.runesList.get(i).getId().equals(championRecommendedRunesById.get(0).getRuneFour())) {
                list.add(new RuneListStruct(MyData.runesList.get(i).getRuneName(),MyData.runesList.get(i).getRuneIcon(),MyData.runesList.get(i).getId()));

            }

        }
      //  for(MyData.)
        return list;
    }
}