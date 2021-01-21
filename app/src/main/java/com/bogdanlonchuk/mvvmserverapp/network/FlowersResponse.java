package com.bogdanlonchuk.mvvmserverapp.network;

import com.google.gson.annotations.SerializedName;
import java.util.List;

import com.bogdanlonchuk.mvvmserverapp.model.Flowers;

public class FlowersResponse {
    @SerializedName("result")
    public List<Flowers> listFlowers;
}
