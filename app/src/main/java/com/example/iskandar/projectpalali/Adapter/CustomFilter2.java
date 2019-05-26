package com.example.iskandar.projectpalali.Adapter;

import android.widget.Filter;

import java.util.ArrayList;

public class CustomFilter2 extends Filter {

    GridAdapterPeringatan adapter;
    ArrayList<Item> filterList;

    public CustomFilter2(GridAdapterPeringatan adapter, ArrayList<Item> filterList) {
        this.adapter = adapter;
        this.filterList = filterList;
    }

    //FILTERING OCURS
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results=new FilterResults();

        //CHECK CONSTRAINT VALIDITY
        if(constraint != null && constraint.length() > 0)
        {
            //CHANGE TO UPPER
            constraint=constraint.toString().toUpperCase();
            //STORE OUR FILTERED PLAYERS
            ArrayList<Item> filteredPlayers =new ArrayList<>();

            for (int i=0;i<filterList.size();i++)
            {
                //CHECK
                if(filterList.get(i).getName().toUpperCase().contains(constraint))
                {
                    //ADD PLAYER TO FILTERED PLAYERS
                    filteredPlayers.add(filterList.get(i));
                }
            }
            results.count=filteredPlayers.size();
            results.values=filteredPlayers;
        }else
        {
            results.count=filterList.size();
            results.values=filterList;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {

        adapter.mItems= (ArrayList<Item>) results.values;

        //REFRESH
        adapter.notifyDataSetChanged();
    }
}
