package zdfwuy.newproject.dialog.Mydialog_to_Notice;

import android.app.Activity;
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

public class Mydialog_Notice_to_manage extends Dialog {
    private Button yes;//确定按钮
    private Button no;//取消按钮
    private TextView titleTV;//消息标题文本
    private TextView message;//消息提示文本
    private String titleStr;//从外界设置的title文本
    private String messageStr;//从外界设置的消息文本

    public String getYesStr() {
        return yesStr;
    }

    public void setYesStr(String yesStr) {
        this.yesStr = yesStr;
    }

    public String getNoStr() {
        return noStr;
    }

    public void setNoStr(String noStr) {
        this.noStr = noStr;
    }

    //确定文本和取消文本的显示的内容
    private String yesStr;
    private String noStr;
    private onNoOnclickListener noOnclickListener;//取消按钮被点击了的监听器
    private onYesOnclickListener yesOnclickListener;



    EditText Editext_title,Edit_isSeen,Edit_isTop,Edit_visibleRange,Edit_releaseTime,Edit_releasePeople,Edit_readTime,Edit_bulletinContent;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getEditext_title_str() {
        return Editext_title_str;
    }

    public void setEditext_title_str(String editext_title_str) {
        Editext_title_str = editext_title_str;
    }

    public String getEdit_isSeen_str() {
        return Edit_isSeen_str;
    }

    public void setEdit_isSeen_str(String edit_isSeen_str) {
        Edit_isSeen_str = edit_isSeen_str;
    }

    public String getEdit_isTop_str() {
        return Edit_isTop_str;
    }

    public void setEdit_isTop_str(String edit_isTop_str) {
        Edit_isTop_str = edit_isTop_str;
    }

    public String getEdit_visibleRange_str() {
        return Edit_visibleRange_str;
    }

    public void setEdit_visibleRange_str(String edit_visibleRange_str) {
        Edit_visibleRange_str = edit_visibleRange_str;
    }

    public String getEdit_releaseTime_str() {
        return Edit_releaseTime_str;
    }

    public void setEdit_releaseTime_str(String edit_releaseTime_str) {
        Edit_releaseTime_str = edit_releaseTime_str;
    }

    public String getEdit_releasePeople_str() {
        return Edit_releasePeople_str;
    }

    public void setEdit_releasePeople_str(String edit_releasePeople_str) {
        Edit_releasePeople_str = edit_releasePeople_str;
    }

    public String getEdit_readTime_str() {
        return Edit_readTime_str;
    }

    public void setEdit_readTime_str(String edit_readTime_str) {
        Edit_readTime_str = edit_readTime_str;
    }

    public String getEdit_bulletinContent_str() {
        return Edit_bulletinContent_str;
    }

    public void setEdit_bulletinContent_str(String edit_bulletinContent_str) {
        Edit_bulletinContent_str = edit_bulletinContent_str;
    }

    private  String pid, Editext_title_str,Edit_isSeen_str,Edit_isTop_str,Edit_visibleRange_str,Edit_releaseTime_str,Edit_releasePeople_str,Edit_readTime_str,Edit_bulletinContent_str;
    public Mydialog_Notice_to_manage(@NonNull Context context,@StyleRes int theme) {
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
        setContentView(R.layout.activity_mydialog__notice_to_manage);
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

     /* Editext_title,Edit_isSeen,Edit_isTop,Edit_visibleRange,Edit_releaseTime,Edit_releasePeople,Edit_readTime,Edit_bulletinContent;*/
        Editext_title= (EditText) findViewById(R.id.Editext_title);
        Edit_isSeen= (EditText) findViewById(R.id.Edit_isSeen);
        Edit_isTop= (EditText) findViewById(R.id.Edit_isTop);

        Edit_visibleRange= (EditText) findViewById(R.id.Edit_visibleRange);
        Edit_releaseTime= (EditText) findViewById(R.id.Edit_releaseTime);
        Edit_releasePeople= (EditText) findViewById(R.id.Edit_releasePeople);

        Edit_readTime= (EditText) findViewById(R.id.Edit_readTime);
        Edit_bulletinContent= (EditText) findViewById(R.id.Edit_bulletinContent);



    }

    private void initData() {
        //如果用户自定了title和message

        if (titleStr != null) {
            titleTV.setText(titleStr);
        }
        if (messageStr != null) {
            message.setText(messageStr);
        }


      /*Editext_title,Edit_isSeen,Edit_isTop,Edit_visibleRange,Edit_releaseTime,Edit_releasePeople,Edit_readTime,Edit_bulletinContent;*/
        if (Editext_title_str !=null){
            Editext_title.setText(Editext_title_str);
        }
        if(Edit_isSeen_str!=null){
            Edit_isSeen.setText(Edit_isSeen_str);
        }
 /*  Edit_isAbnormalIncome,Edit_isAbnormalMarginalProfit,Edit_isAbnormalMaterialCost; */
        if(Edit_isTop_str!=null){
            Edit_isTop.setText(Edit_isTop_str);
        }


        if (Edit_visibleRange_str!=null){
            Edit_visibleRange.setText(Edit_visibleRange_str);
        }
        if(Edit_releaseTime_str!=null){
            Edit_releaseTime.setText(Edit_releaseTime_str);
        }
 /*  Edit_isAbnormalIncome,Edit_isAbnormalMarginalProfit,Edit_isAbnormalMaterialCost; */
        if(Edit_releasePeople_str!=null){
            Edit_releasePeople.setText(Edit_releasePeople_str);
        }

        if (Edit_readTime_str!=null){
            Edit_readTime.setText(Edit_readTime_str);
        }
        if(Edit_bulletinContent_str!=null){
            Edit_bulletinContent.setText(Edit_bulletinContent_str);
        }
 /*  Edit_isAbnormalIncome,Edit_isAbnormalMarginalProfit,Edit_isAbnormalMaterialCost; */

        //如果设置按钮文字
        if (yesStr != null) {
            yes.setText(yesStr);
        }
        if (noStr != null) {
            no.setText(noStr);
        }
    }
    public void SetEditTextnotENeditable(){

        /*Editext_title,Edit_isSeen,Edit_isTop,Edit_visibleRange,Edit_releaseTime,Edit_releasePeople,Edit_readTime,Edit_bulletinContent;*/


        Editext_title.setEnabled(false);
        Edit_isSeen.setEnabled(false);
        Edit_isTop.setEnabled(false);
        Edit_visibleRange.setEnabled(false);
        Edit_releaseTime.setEnabled(false);
        Edit_releasePeople.setEnabled(false);
        Edit_readTime.setEnabled(false);
        Edit_bulletinContent.setEnabled(false);


    }
    public void SetEditTextENeditable(){

        Editext_title.setEnabled(true);
        Edit_isSeen.setEnabled(true);
        Edit_isTop.setEnabled(true);
        Edit_visibleRange.setEnabled(true);
        Edit_releaseTime.setEnabled(true);
        Edit_releasePeople.setEnabled(true);
        Edit_readTime.setEnabled(true);
        Edit_bulletinContent.setEnabled(true);

    }

}
