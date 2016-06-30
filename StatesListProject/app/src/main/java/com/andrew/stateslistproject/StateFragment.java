package com.andrew.stateslistproject;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class StateFragment extends Fragment {


    public StateFragment() {
        // Required empty public constructor
    }


  //  @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.state_fragment_layout, container, false);
//        String [] states  = {"Alabama",
//                "Alaska",
//                "Arizona",
//                "Arkansas",
//                "California",
//                "Colorado",
//                "Connecticut",
//                "Delaware",
//                "Florida",
//                "Georgia",
//                "Hawaii",
//                "Idaho",
//                "Illinois",
//                "Indiana",
//                "Iowa",
//                "Kansas",
//                "Kentucky",
//                "Louisiana",
//                "Maine",
//                "Maryland",
//                "Massachusetts",
//                "Michigan",
//                "Minnesota",
//                "Mississippi",
//                "Missouri",
//                "Montana",
//                "Nebraska",
//                "Nevada",
//                "New Hampshire",
//                "New Jersey",
//                "New Mexico",
//                "New York",
//                "North Carolina",
//                "North Dakota",
//                "Ohio",
//                "Oklahoma",
//                "Oregon",
//                "Pennsylvania",
//                "Rhode Island",
//                "South Carolina",
//                "South Dakota",
//                "Tennessee",
//                "Texas",
//                "Utah",
//                "Vermont",
//                "Virginia",
//                "Washington",
//                "West Virginia",
//                "Wisconsin",
//                "Wyoming"
//        };
//        List<String> stateList = new ArrayList<String>(Arrays.asList(states));
//        ArrayAdapter<String> stateAdapter = new ArrayAdapter<String>(StateFragment.this, R.layout.activity_main, R.id.textView, stateList);
//
//        ListView lv = (ListView) v.findViewById(R.id.listView);
//        lv.setAdapter(stateAdapter);
//
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            public void onItemClick(AdapterView<?> parent, View view, int pos, long id){
//                if (pos == 38){
//                    map();
//                }
//            }
//        });
        return v;
    }
//    protected void map() {
//        final Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setData(Uri.parse("geo:0,0?q=Providence+Rhode+Island"));
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }
//    }
}
