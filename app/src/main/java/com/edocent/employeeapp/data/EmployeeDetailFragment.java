package com.edocent.employeeapp.data;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edocent.employeeapp.R;

public class EmployeeDetailFragment extends Fragment {

    long employeeIndex;

    public EmployeeDetailFragment() { }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if(savedInstanceState != null){
            employeeIndex = savedInstanceState.getLong("employeeIndex");
        }

        //Handle the Child Fragment. For demo purpose I haven't created a new Fragment
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        EmployeeListFragment elf = new EmployeeListFragment();
        ft.replace(R.id.employeeAddressFragmentId, elf);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.addToBackStack(null);
        ft.commit();
        //End

        return inflater.inflate(R.layout.fragment_employee_detail, container, false);
    }

    public void setEmployeeIndex(long employeeIndex) {
        this.employeeIndex = employeeIndex;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putLong("employeeIndex", employeeIndex);
    }
}
