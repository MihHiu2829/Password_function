package com.example.project47;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project47.databinding.M001ActmainBinding;

public class m001_mainAct extends AppCompatActivity implements View.OnClickListener {
    M001ActmainBinding binding ;
    private int count ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = M001ActmainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        count = 3 ; 
        binding.btXm.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
            String pw  = binding.edtPw.getText().toString() ;
            String pass = "12052003" ;
            if (pw.isEmpty())
            {
                Toast.makeText(this, "Vui lòng nhập mật khẩu", Toast.LENGTH_SHORT).show();
                return ;
            }
            if (view.getId() == R.id.bt_xm)
            {
                if(pw.compareTo(pass) == 0)
                {
                    Toast.makeText(this, "Mật khẩu bạn nhập đúng!", Toast.LENGTH_SHORT).show();
                }else {
                    count-- ;
                    if (count == 0 )
                    {
                        Toast.makeText(this, "Khoá!", Toast.LENGTH_SHORT).show();
                        return ;
                    }
                    Toast.makeText(this, "Ẩu rồi đó pa,ông còn !" + count, Toast.LENGTH_SHORT).show();

                }

            }
    }
}
