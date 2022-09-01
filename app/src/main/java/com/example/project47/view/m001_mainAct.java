package com.example.project47.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.example.project47.R;
import com.example.project47.databinding.M001ActmainBinding;
import com.example.project47.viewModel.m001_vm;

public class m001_mainAct extends base_ACT<M001ActmainBinding, m001_vm> {
    private int count = 3 ;
    @Override
    protected Class<m001_vm> getClassVM() {
        return m001_vm.class;
    }

    @Override
    protected void initViews() {
        viewModel.getKeyWord().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String ax) {
                Toast.makeText(m001_mainAct.this, ax, Toast.LENGTH_SHORT).show();
            }
        });
        binding.btXm.setOnClickListener(v -> gotoViewModel());
    }

    private void gotoViewModel() {
        String txt =  binding.edtPw.getText().toString() ;
        viewModel.gotoViewModel(txt);
    }


    @Override
    protected M001ActmainBinding initViewBinding() {
        return M001ActmainBinding.inflate(getLayoutInflater());
    }




}
