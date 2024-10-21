package com.example.fragmentsederhana;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentKedua extends Fragment {

    private ImageView imgDisplay;
    private TextView tvCarName;
    private TextView tvCarDetails;
    private SharedViewModel sharedViewModel;
    private Button btnBack;

    public FragmentKedua() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kedua, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Deskripsi");
        imgDisplay = view.findViewById(R.id.img_display);
        tvCarName = view.findViewById(R.id.tv_produk_name);
        btnBack = view.findViewById(R.id.btn_back);;
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        sharedViewModel.getImageId().observe(getViewLifecycleOwner(), imageId -> {
            if (imageId != null) {
                imgDisplay.setImageResource(imageId);
            }
        });
        sharedViewModel.getprodukName().observe(getViewLifecycleOwner(), carName -> {
            if (carName != null) {
                tvCarName.setText(carName);
            }
        });
        btnBack.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager().popBackStack(); // Kembali ke FragmentPertama
        });

        return view;
    }
}

