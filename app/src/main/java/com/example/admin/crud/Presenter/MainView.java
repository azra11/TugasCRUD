package com.example.admin.crud.Presenter;

import com.example.admin.crud.Model.Create.GetModel.GetResponse;

public interface MainView {
    void getSucces(GetResponse list);
    void setToast(String message);
    void onError(String errorMessage);
    void onFailure(String failureMessage);
}