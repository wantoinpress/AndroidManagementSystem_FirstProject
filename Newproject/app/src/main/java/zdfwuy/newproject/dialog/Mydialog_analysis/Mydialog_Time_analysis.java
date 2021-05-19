package zdfwuy.newproject.dialog.Mydialog_analysis;

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

public class Mydialog_Time_analysis extends Dialog{

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

    EditText EditText_engeenirName,Editext_pijianhao,Edit_engineerTime,Edit_contractNum,Edit_workUnit,
            Edit_isPostContract,Edit_isAbnormalSubcontractDate,Edit_isSettlementLaggingBehind;

    private String pid;

    public String getEdit_isSettlementLaggingBehind_str() {
        return Edit_isSettlementLaggingBehind_str;
    }

    public void setEdit_isSettlementLaggingBehind_str(String edit_isSettlementLaggingBehind_str) {
        Edit_isSettlementLaggingBehind_str = edit_isSettlementLaggingBehind_str;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getEditText_engeenirName_str() {
        return EditText_engeenirName_str;
    }

    public void setEditText_engeenirName_str(String editText_engeenirName_str) {
        EditText_engeenirName_str = editText_engeenirName_str;
    }

    public String getEditext_pijianhao_str() {
        return Editext_pijianhao_str;
    }

    public void setEditext_pijianhao_str(String editext_pijianhao_str) {
        Editext_pijianhao_str = editext_pijianhao_str;
    }

    public String getEdit_engineerTime_str() {
        return Edit_engineerTime_str;
    }

    public void setEdit_engineerTime_str(String edit_engineerTime_str) {
        Edit_engineerTime_str = edit_engineerTime_str;
    }

    public String getEdit_contractNum_str() {
        return Edit_contractNum_str;
    }

    public void setEdit_contractNum_str(String edit_contractNum_str) {
        Edit_contractNum_str = edit_contractNum_str;
    }

    public String getEdit_workUnit_str() {
        return Edit_workUnit_str;
    }

    public void setEdit_workUnit_str(String edit_workUnit_str) {
        Edit_workUnit_str = edit_workUnit_str;
    }

    public String getEdit_isPostContract_str() {
        return Edit_isPostContract_str;
    }

    public void setEdit_isPostContract_str(String edit_isPostContract_str) {
        Edit_isPostContract_str = edit_isPostContract_str;
    }

    public String getEdit_isAbnormalSubcontractDate_str() {
        return Edit_isAbnormalSubcontractDate_str;
    }

    public void setEdit_isAbnormalSubcontractDate_str(String edit_isAbnormalSubcontractDate_str) {
        Edit_isAbnormalSubcontractDate_str = edit_isAbnormalSubcontractDate_str;
    }

    private String EditText_engeenirName_str;
    private String Editext_pijianhao_str;
    private String Edit_engineerTime_str;
    private String Edit_contractNum_str;
    private String Edit_workUnit_str;
    private String Edit_isPostContract_str;
    private String Edit_isAbnormalSubcontractDate_str;
    private String Edit_isSettlementLaggingBehind_str;
    public Mydialog_Time_analysis(@NonNull Context context,@StyleRes int theme) {
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
        setContentView(R.layout.activity_mydialog__time_analysis);
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

     /*  EditText_engeenirName,Editext_pijianhao,Edit_engineerTime,Edit_contractNum,Edit_workUnit,
            Edit_isPostContract,Edit_isAbnormalSubcontractDate,Edit_isSettlementLaggingBehind;  */
        EditText_engeenirName= (EditText) findViewById(R.id.EditText_engeenirName);
        Editext_pijianhao= (EditText) findViewById(R.id.Editext_pijianhao);
        Edit_engineerTime= (EditText) findViewById(R.id.Edit_engineerTime);
        Edit_contractNum= (EditText) findViewById(R.id.Edit_contractNum);
//        workUnit= (EditText) findViewById(R.id.Spinner_workCompany_dialog);
        Edit_workUnit= (EditText) findViewById(R.id.Edit_workUnit);
        Edit_isPostContract= (EditText) findViewById(R.id.Edit_isPostContract);
        Edit_isAbnormalSubcontractDate= (EditText) findViewById(R.id.Edit_isAbnormalSubcontractDate);
        Edit_isSettlementLaggingBehind= (EditText) findViewById(R.id.Edit_isSettlementLaggingBehind);

    }

    private void initData() {
        //如果用户自定了title和message

        if (titleStr != null) {
            titleTV.setText(titleStr);
        }
        if (messageStr != null) {
            message.setText(messageStr);
        }


        /* String EditText_engeenirName_str,Editext_pijianhao_str,Edit_engineerTime_str,Edit_contractNum_str,Edit_workUnit_str,
            Edit_isPostContract_str,Edit_isAbnormalSubcontractDate_str,Edit_isSettlementLaggingBehind_str;*/
        if(EditText_engeenirName_str!=null){
            EditText_engeenirName.setText(EditText_engeenirName_str);
        }
        if (Editext_pijianhao_str!=null){
            Editext_pijianhao.setText(Editext_pijianhao_str);
        }
        if(Edit_engineerTime_str!=null){
            Edit_engineerTime.setText(Edit_engineerTime_str);
        }
//        if (workUnitstr!=null){
//            workUnit.setText(workUnitstr);
//        }
        if(Edit_contractNum_str!=null){
            Edit_contractNum.setText(Edit_contractNum_str);
        }
        if(Edit_workUnit_str!=null){
            Edit_workUnit.setText(Edit_workUnit_str);
        }
        if (Edit_isPostContract_str!=null){
            Edit_isPostContract.setText(Edit_isPostContract_str);
        }
        if(Edit_isAbnormalSubcontractDate_str!=null){
            Edit_isAbnormalSubcontractDate.setText(Edit_isAbnormalSubcontractDate_str);
        }
        if(Edit_isSettlementLaggingBehind_str!=null){
            Edit_isSettlementLaggingBehind.setText(Edit_isSettlementLaggingBehind_str);
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

        /*EditText_engeenirName,Editext_pijianhao,Edit_engineerTime,Edit_contractNum,Edit_workUnit,
            Edit_isPostContract,,Edit_isSettlementLaggingBehind;*/
        EditText_engeenirName.setEnabled(false);
        Editext_pijianhao.setEnabled(false);
        Edit_engineerTime.setEnabled(false);
        Edit_contractNum.setEnabled(false);
        Edit_workUnit.setEnabled(false);
        Edit_isPostContract.setEnabled(false);
        Edit_isAbnormalSubcontractDate.setEnabled(false);
        Edit_isSettlementLaggingBehind.setEnabled(false);

    }
}
