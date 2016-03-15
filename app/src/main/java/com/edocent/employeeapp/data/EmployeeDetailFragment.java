package com.edocent.employeeapp.data;


import android.app.Fragment;
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

        return inflater.inflate(R.layout.fragment_employee_detail, container, false);
    }

    public void setEmployeeIndex(long employeeIndex) {
        this.employeeIndex = employeeIndex;
    }

    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putLong("employeeIndex", employeeIndex);
    }
}
