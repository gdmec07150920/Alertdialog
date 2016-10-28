package com.example.administrator.alertdialog;

import android.content.DialogInterface;
import android.net.Uri;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    private AlertDialog dialog;
    private AlertDialog.Builder builder;
    private TextView tView;
    /*private GoogleApiClient clent;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tView=(TextView)this.findViewById(R.id.textView1);
        Button btn1 = (Button) findViewById(R.id.button1);
        Button btn2 = (Button) findViewById(R.id.button2);
        Button btn3 = (Button) findViewById(R.id.button3);
        Button btn4 = (Button) findViewById(R.id.button4);
        Button btn5 = (Button) findViewById(R.id.button5);
        Button btn6 = (Button) findViewById(R.id.button6);
        Button btn7 = (Button) findViewById(R.id.button7);
        //创建按键监听器
        View.OnClickListener listener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button1:
                        dialog1();
                        break;
                    case R.id.button2:
                        dialog2();
                        break;
                    case R.id.button3:
                        dialog3();
                        break;
                    case R.id.button4:
                        dialog4();
                        break;
                    case R.id.button5:
                        dialog5();
                        break;
                    case R.id.button6:
                        dialog6();
                        break;
                    case R.id.button7:
                        dialog7();
                        break;
                }
            }
        };
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        btn5.setOnClickListener(listener);
        btn6.setOnClickListener(listener);
        btn7.setOnClickListener(listener);
    }

    private void dialog1() {
       /* Toast.makeText(this,"显示dialog1",Toast.LENGTH_SHORT).show();*/
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("两个按钮");
        dialog.setMessage("确定退出吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_alert);
        DialogInterface.OnClickListener lis1 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == DialogInterface.BUTTON_POSITIVE) {//按下确定
                    dialog.dismiss();
                    MainActivity.this.finish();
                } else if (which == DialogInterface.BUTTON_NEGATIVE) {
                    dialog.dismiss();
                }
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", lis1);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", lis1);
        dialog.show();
    }

    private void dialog2() {
      /*  Toast.makeText(this,"显示dialog2",Toast.LENGTH_SHORT).show();*/
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("调查");
        dialog.setMessage("你平时忙吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        //创建按键监听器
        DialogInterface.OnClickListener listenter = new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "";
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        str = "平时很忙！";
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        str = "平时一般！";
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        str = "平时很轻松！！";
                        break;
                }
                tView.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "忙碌", listenter);
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL, "一般", listenter);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "不忙", listenter);
        dialog.show();
    }

    private void dialog3() {
        /*Toast.makeText(this,"显示dialog3",Toast.LENGTH_SHORT).show();*/
      /*  dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("请输入");
        dialog.setMessage("你平时忙吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        final EditText tEdit = new EditText(this);
        dialog.setView(tEdit);*/


          AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("请输入");
        builder.setMessage("你平时忙吗？");
        builder.setIcon(android.R.drawable.ic_dialog_info);
        final EditText tEdit = new EditText(this);
        builder.setView(tEdit);
        dialog = builder.create();


        //创建监听器
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                tView.setText("输入的是" + tEdit.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", listener);
        dialog.show();
    }

    private void dialog4() {
       /* Toast.makeText(this,"显示dialog4",Toast.LENGTH_SHORT).show();*/
        final String item[] = new String[]{"北京", "上海", "广州"};
        final boolean bSelect[] = new boolean[item.length];
        DialogInterface.OnMultiChoiceClickListener mListener = new DialogInterface.OnMultiChoiceClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                bSelect[which] = isChecked;
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(item, null, mListener);
        dialog = builder.create();
        dialog.setTitle("复选框");
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选择了：";
                for (int i = 0; i < bSelect.length; i++) {
                    if (bSelect[i]) {
                        str = str + "\n" + item[i];
                    }
                }
                tView.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", listener);
        dialog.show();
    }

    private void dialog5() {
       /* Toast.makeText(this, "显示dialog5", Toast.LENGTH_SHORT).show();*/
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnClickListener sListenter=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                bSelect[which]=true;
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(item,-1,sListenter);
        dialog = builder.create();
        dialog.setTitle("单选框");
        DialogInterface.OnClickListener listenter=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了：";
                for (int i=0;i<bSelect.length;i++){
                    if (bSelect[i]){
                        str=str+"\n"+item[i];
                    }
                }
                tView.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listenter);
        dialog.show();
    }

    private void dialog6() {
        /*Toast.makeText(this, "显示dialog6", Toast.LENGTH_SHORT).show();*/
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnClickListener sListenter=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了："+item[which];
                tView.setText(str);
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setItems(item,sListenter);
        dialog=builder.create();
        dialog.setTitle("列表框");
        DialogInterface.OnClickListener listenter=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listenter);
        dialog.show();
    }
     EditText tEdit;
    public void dialog7() {
       /* Toast.makeText(this, "显示dialog7", Toast.LENGTH_SHORT).show();*/
        LayoutInflater inflater=getLayoutInflater();
        View layout=inflater.inflate(R.layout.layout,null);
        tEdit= (EditText) layout.findViewById(R.id.et);

        builder=new AlertDialog.Builder(this);
        builder.setTitle("自定义布局");
        builder.setView(layout);
        dialog=builder.create();

        /*dialog=new AlertDialog.Builder(this).create();*/
       DialogInterface.OnClickListener listenter =new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.this.tView.setText("输入的是"+MainActivity.this.tEdit.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listenter);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listenter);
        dialog.show();
    }

}


