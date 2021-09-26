package com.istic.mmm.tp1;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class ClientViewModel extends BaseObservable {
    private Client model;
    @Bindable
    public String getName() {
        return this.model.getName();
    }

    public void setName(String nom) {
        this.model.setName(nom);;
        //BR.name is automatically generated
        notifyPropertyChanged(BR.name);
    }
}

