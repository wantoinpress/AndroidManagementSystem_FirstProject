package zdfwuy.newproject.dialog.Mydialog_management;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import zdfwuy.newproject.R;

public class Mydialog_Whether_or_not extends Dialog {
    private Button yes;//确定按钮
    private Button no;//取消按钮
    private TextView titleTV;//消息标题文本
    private TextView message;//消息提示文本
    private String titleStr;//从外界设置的title文本
    private String messageStr;//从外界设置的消息文本
    //确定文本和取消文本的显示的内容
    private String yesStr;
    private String noStr;
    private onNoOnclickListener noOnclickListener;//取消按钮被点击了的监听器
    private onYesOnclickListener yesOnclickListener;

    EditText Editext_codeName,Edit_remarks,Edit_isUsed;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getEditext_codeName_str() {
        return Editext_codeName_str;
    }

    public void setEditext_codeName_str(String editext_codeName_str) {
        Editext_codeName_str = editext_codeName_str;
    }

    public String getEdit_remarks_str() {
        return Edit_remarks_str;
    }

    public void setEdit_remarks_str(String edit_remarks_str) {
        Edit_remarks_str = edit_remarks_str;
    }

    public String getEdit_isUsed_str() {
        return Edit_isUsed_str;
    }

    public void setEdit_isUsed_str(String edit_isUsed_str) {
        Edit_isUsed_str = edit_isUsed_str;
    }

    private  String pid,Editext_codeName_str,Edit_remarks_str,Edit_isUsed_str;

    public interface onNoOnclickListener{
        public void onNoOnclick();
    }
    public interface onYesOnclickListener{
        public void onYesOnclick();
    }

    public void setYesOnclickListener(String yesStr,onYesOnclickListener onYesOnclickListener1){
        if(yesStr!=null){
            this.yesStr=yesStr;
        }
        this.yesOnclickListener=onYesOnclickListener1;
    }

    public void setNoOnclickListener(String noStr,onNoOnclickListener onNoOnclickListener1){
        if(noStr!=null){
            this.noStr=noStr;
        }
        this.noOnclickListener=onNoOnclickListener1;
    }
    public Mydialog_Whether_or_not(@NonNull Context context,@StyleRes int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydialog__whether_or_not);

        initview();
        initData();

        INITclick();
        SetEditTextnotENeditable();
    }

    public void INITclick(){
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (yesOnclickListener != null) {
                    yesOnclickListener.onYesOnclick();
                }
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (noOnclickListener != null) {
                    noOnclickListener.onNoOnclick();
                }
            }
        });
    }

    public void  initview(){
        yes= (Button) findViewById(R.id.yes_production);
        no= (Button) findViewById(R.id.no_produtions);
        titleTV= (TextView) findViewById(R.id.title_production);
        message= (TextView) findViewById(R.id.Text_engeenirName_production);

     /* EditText_rankNum,Editext_constructionName,Edit_remarks,Edit_isUsed */
        /*EditText_rankNum= (EditText) findViewById(R.id.EditText_rankNum);*/
        Editext_codeName= (EditText) findViewById(R.id.Editext_codeName);
        Edit_remarks= (EditText) findViewById(R.id.Edit_remarks);
        Edit_isUsed= (EditText) findViewById(R.id.Edit_isUsed);


    }

    private void initData() {
        //如果用户自定了title和message

        if (titleStr != null) {
            titleTV.setText(titleStr);
        }
        if (messageStr != null) {
            message.setText(messageStr);
        }


      /*EditText_rankNum_str,Editext_constructionName_str,Edit_remarks_str,Edit_isUsed_str*/
       /* if(EditText_rankNum_str!=null){
            EditText_rankNum.setText(EditText_rankNum_str);
        }*/
        if (Editext_codeName_str!=null){
            Editext_codeName.setText(Editext_codeName_str);
        }
        if(Edit_remarks_str!=null){
            Edit_remarks.setText(Edit_remarks_str);
        }
 /*  Edit_isAbnormalIncome,Edit_isAbnormalMarginalProfit,Edit_isAbnormalMaterialCost; */
        if(Edit_isUsed_str!=null){
            Edit_isUsed.setText(Edit_isUsed_str);
        }

        //如果设置按钮文字
        if (yesStr != null) {
            yes.setText(yesStr);
        }
        if (noStr != null) {
            no.setText(noStr);
        }
    }
    public void SetEditTextnotENeditable(){


        Editext_codeName= (EditText) findViewById(R.id.Editext_codeName);
        Edit_remarks= (EditText) findViewById(R.id.Edit_remarks);
        Edit_isUsed= (EditText) findViewById(R.id.Edit_isUsed);

        Editext_codeName.setEnabled(false);
        Edit_remarks.setEnabled(false);
        Edit_isUsed.setEnabled(false);

    }
    public void SetEditTextENeditable(){

        Editext_codeName.setEnabled(true);
        Edit_remarks.setEnabled(true);
        Edit_isUsed.setEnabled(true);
    }
}
