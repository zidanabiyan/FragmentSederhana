package com.example.fragmentsederhana;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
public class FragmentPertama extends Fragment {

    private Button btnSend;
    private SharedViewModel sharedViewModel;

    public FragmentPertama() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pertama, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Home");
        btnSend = view.findViewById(R.id.btn_send);

        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        btnSend.setOnClickListener(v -> {
            int imageResourceId = R.drawable.contohpoto;
            String carName = "IPHONE 15 ";;


            sharedViewModel.setCarData(imageResourceId, carName);


            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, new FragmentKedua());
            transaction.addToBackStack(null);
            transaction.commit();
        });

        return view;
    }
}

