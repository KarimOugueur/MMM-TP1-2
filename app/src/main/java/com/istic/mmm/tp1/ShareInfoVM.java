package com.istic.mmm.tp1;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ShareInfoVM extends ViewModel {
    private final MutableLiveData<Client> data = new MutableLiveData<Client>();

    public void setdata(Client newdata) {
        data.setValue(newdata);
    }

    public LiveData<Client> getData() {
        return data;
    }
}