package com.example.project47.view;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

public abstract class base_ACT <T extends ViewBinding,M extends ViewModel> extends AppCompatActivity implements View.OnClickListener {

    protected T binding ;
    protected M viewModel ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = initViewBinding();
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(getClassVM());
        initViews();
    }


    protected abstract Class<M> getClassVM();


    protected abstract void initViews();


    protected abstract T initViewBinding();

    @Override
    public final void onClick(View v) {
        // do nothing  ;
    }
}
