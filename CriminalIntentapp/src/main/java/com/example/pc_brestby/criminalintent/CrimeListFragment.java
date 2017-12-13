package com.example.pc_brestby.criminalintent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CrimeListFragment extends Fragment {

   // private RecyclerView mCrimeRecyclerViev;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_crime_list,container,false);
      //  mCrimeRecyclerViev = (RecyclerView)view.findViewById(R.id.crime_recycler_view);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
