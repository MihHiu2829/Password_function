package com.example.project47.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class m001_vm extends ViewModel {
    public  int count =  3 ;
    private Thread th ;
    private MutableLiveData<String> keyWord = new MutableLiveData<>() ;
    public MutableLiveData<String> getKeyWord() {
        return keyWord;
    }

    public void gotoViewModel(String txt) {
        String password = "12052003" ;
        String rs ;
        if(txt.equals(password))
        {
            rs = "Đúng mật khẩu." ;
        }else{
            if(count == 0)
            {   rs ="Hết lượt, vui lòng chờ 30s" ;
                if(th == null || !th.isAlive())
                {
                    th = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(30000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                                return ;
                            }
                            count = 3 ;
                        }
                    });
                    th.start();
                }
            }else
            {
                count-- ;
                rs = "Sai,bạn còn "+ count +" lượt" ;
            }
        }
                    keyWord.postValue(rs);

    }
}
