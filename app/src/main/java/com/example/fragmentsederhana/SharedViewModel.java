package com.example.fragmentsederhana;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {

    private final MutableLiveData<Integer> imageId = new MutableLiveData<>();
    private final MutableLiveData<String> produkName = new MutableLiveData<>();


    public void setCarData(int imageId, String produkName) {
        this.imageId.setValue(imageId);
        this.produkName.setValue(produkName);

    }

    public LiveData<Integer> getImageId() {
        return imageId;
    }

    public LiveData<String> getprodukName() {
        return produkName;
    }


}
