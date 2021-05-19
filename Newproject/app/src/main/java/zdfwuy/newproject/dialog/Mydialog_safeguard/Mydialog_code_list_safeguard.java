package zdfwuy.newproject.dialog.Mydialog_safeguard;

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

public class Mydialog_code_list_safeguard extends Dialog {
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

    EditText Editext_codeName,Edit_sqlSetence,Edit_topSelect,Edit_exportModel;

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

    public String getEdit_sqlSetence_str() {
        return Edit_sqlSetence_str;
    }

    public void setEdit_sqlSetence_str(String edit_sqlSetence_str) {
        Edit_sqlSetence_str = edit_sqlSetence_str;
    }

    public String getEdit_topSelect_str() {
        return Edit_topSelect_str;
    }

    public void setEdit_topSelect_str(String edit_topSelect_str) {
        Edit_topSelect_str = edit_topSelect_str;
    }

    public String getEdit_exportModel_str() {
        return Edit_exportModel_str;
    }

    public void setEdit_exportModel_str(String edit_exportModel_str) {
        Edit_exportModel_str = edit_exportModel_str;
    }

    private  String  pid, Editext_codeName_str,Edit_sqlSetence_str,Edit_topSelect_str,Edit_exportModel_str;
    public Mydialog_code_list_safeguard(@NonNull Context context,@StyleRes int theme) {
        super(context, theme);
    }

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydialog_code_list_safeguard);

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

        /* Editext_codeName,Edit_sqlSetence,Edit_topSelect,Edit_exportModel*/
        Editext_codeName= (EditText) findViewById(R.id.Editext_codeName);
        Edit_sqlSetence= (EditText) findViewById(R.id.Edit_sqlSetence);
        Edit_topSelect= (EditText) findViewById(R.id.Edit_topSelect);

        Edit_exportModel= (EditText) findViewById(R.id.Edit_exportModel);



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
        if(Edit_sqlSetence_str!=null){
            Edit_sqlSetence.setText(Edit_sqlSetence_str);
        }
 /*  Edit_isAbnormalIncome,Edit_isAbnormalMarginalProfit,Edit_isAbnormalMaterialCost; */
        if(Edit_topSelect_str!=null){
            Edit_topSelect.setText(Edit_topSelect_str);
        }

        if(Edit_exportModel_str!=null){
            Edit_exportModel.setText(Edit_exportModel_str);
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
        Edit_sqlSetence= (EditText) findViewById(R.id.Edit_sqlSetence);
        Edit_topSelect= (EditText) findViewById(R.id.Edit_topSelect);

        Edit_exportModel= (EditText) findViewById(R.id.Edit_exportModel);

        Editext_codeName.setEnabled(false);
        Edit_sqlSetence.setEnabled(false);
        Edit_topSelect.setEnabled(false);

        Edit_exportModel.setEnabled(false);

    }
    public void SetEditTextENeditable(){

        Editext_codeName.setEnabled(true);
        Edit_sqlSetence.setEnabled(true);
        Edit_topSelect.setEnabled(true);
        Edit_exportModel.setEnabled(true);

    }
}
