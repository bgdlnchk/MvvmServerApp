package com.bogdanlonchuk.mvvmserverapp.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.bogdanlonchuk.mvvmserverapp.R;
import com.bogdanlonchuk.mvvmserverapp.databinding.ActivityFlowersBinding;
import com.bogdanlonchuk.mvvmserverapp.network.FlowersResponse;
import com.bogdanlonchuk.mvvmserverapp.network.Call;

public class FlowersActivity extends AppCompatActivity {

    private ActivityFlowersBinding binding;
    private Call call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowers);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_flowers);
        binding.flowersRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        call = new Call(this, new Call.Delegate() {
            @Override
            public void onSuccess(FlowersResponse flowersResponse) {
                binding.flowersRecyclerView.setAdapter(new FlowersAdapter(flowersResponse.listFlowers));
            }

            @Override
            public void onFailure(Object t) {
                Toast.makeText(getApplicationContext(), "Error = "+t.toString(), Toast.LENGTH_LONG).show();
            }
        });
        call.execute();

    }
}
