package com.jolly.androiddagger.UI;

import android.app.ProgressDialog;
import android.content.Context;

import com.jolly.androiddagger.R;



public class CustomProgressDialog {
    private ProgressDialog progressDialog;
    private Context context;
    public CustomProgressDialog(Context context){
        this.context=context;
        getProgressDialog();
    }
    private void getProgressDialog(){
        if(progressDialog==null) {
            progressDialog = new ProgressDialog(context, R.style.MyTheme);
        }
        //return progressDialog;
    }

    public void showDialog(){
        progressDialog.setProgressStyle(android.R.style.Widget_ProgressBar_Large);
        progressDialog.setCancelable(false);

        progressDialog.show();
       /* progressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        progressDialog.setIndeterminate(true);
        progressDialog.getWindow().setGravity(Gravity.CENTER);
        progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        progressDialog.setContentView(R.layout.progressbar_layout);*/
    }

    public void cancelDialog(){
        if(progressDialog!=null&&progressDialog.isShowing()){
            progressDialog.cancel();
        }
    }
}
