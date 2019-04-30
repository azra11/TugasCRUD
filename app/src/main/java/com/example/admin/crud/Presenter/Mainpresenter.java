package com.example.admin.crud.Presenter;

import com.example.admin.crud.Model.Create.Create.CreateResponse;
import com.example.admin.crud.Model.Create.GetModel.GetResponse;
import com.example.admin.crud.Remote.BaseAPP;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class Mainpresenter implements MainInterface{
    private MainView mainView;

    public Mainpresenter(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void getAllItems() {
        BaseAPP.service.getAllItems().enqueue(new Callback<GetResponse>() {
            @Override
            public void onResponse(Call<GetResponse> call, Response<GetResponse> response) {
                if (response.isSuccessful())
                    mainView.getSucces(response.body());
                else
                    mainView.onError(response.message());
            }

            @Override
            public void onFailure(Call<GetResponse> call, Throwable t) {
                mainView.onFailure(t.getMessage());
            }
        });
    }

    @Override
    public void updateItems(String id, String name, String description) {
        BaseAPP.service.updateDataItems(id,name,description).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful())
                    mainView.setToast(response.message());
                else
                    mainView.onError(response.message());
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                mainView.onFailure(t.getMessage());
            }
        });
    }

    @Override
    public void deleteItems(String id) {
        BaseAPP.service.deleteDataItems(id).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful())
                    mainView.setToast(response.message());
                else
                    mainView.onError(response.message());
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                mainView.onFailure(t.getMessage());
            }
        });
    }

    @Override
    public void createItems(String name, String description) {
        BaseAPP.service.createItems(name,description).enqueue(new Callback<CreateResponse>() {
            @Override
            public void onResponse(Call<CreateResponse> call, Response<CreateResponse> response) {
                if (response.isSuccessful())
                    mainView.setToast(response.message());
                else
                    mainView.onError(response.message());
            }

            @Override
            public void onFailure(Call<CreateResponse> call, Throwable t) {
                mainView.onFailure(t.getMessage());
            }
        });
    }
}