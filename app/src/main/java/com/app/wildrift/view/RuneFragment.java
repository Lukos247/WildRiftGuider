package com.app.wildrift.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.wildrift.R;
import com.app.wildrift.presenter.MyData;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RuneFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RuneFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private int id;
    private ImageView icon;
    private TextView name;
    private TextView description;

  //  private String mParam2;

    public RuneFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RuneFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RuneFragment newInstance(String param1, String param2) {
        RuneFragment fragment = new RuneFragment();
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
            id = getArguments().getInt("runeId");
          //  mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rune, container, false);
        initGUI(view);

        return view;
    }

    private void initGUI(View view){

        icon = view.findViewById(R.id.image_rune_icon);
        name = view.findViewById(R.id.tv_rune_name);
        description = view.findViewById(R.id.tv_rune_description);

        for(int i = 0;i<= MyData.runesList.size()-1;i++){
            if(Integer.parseInt(MyData.runesList.get(i).getId()) == id){
                String runeIcon = MyData.runesList.get(i).getRuneIcon();
                String runeName = MyData.runesList.get(i).getRuneName();
                String runeDescription = MyData.runesList.get(i).getRuneDescription();

                name.setText(runeName);
                description.setText(runeDescription);

                Picasso.get().load(runeIcon).into(icon);
            }

        }

    }

}