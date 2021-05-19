package zdfwuy.newproject.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import zdfwuy.newproject.R;

public class Mydialog_contract extends Dialog {
    private Button yes;//确定按钮
    private Button no;//取消按钮
    private TextView titleTV;//消息标题文本
    private TextView message;//消息提示文本
    private String titleStr;//从外界设置的title文本
    private String messageStr;//从外界设置的消息文本
    //确定文本和取消文本的显示的内容
    private String yesStr;

    public String getNoStr() {
        return noStr;
    }

    public void setNoStr(String noStr) {
        this.noStr = noStr;
    }

    public String getYesStr() {
        return yesStr;
    }

    public void setYesStr(String yesStr) {
        this.yesStr = yesStr;
    }

    private String noStr;
    private onNoOnclickListener noOnclickListener;//取消按钮被点击了的监听器
    private onYesOnclickListener yesOnclickListener;

    public String getPid() {
        return Pid;
    }

    public void setPid(String pid) {
        Pid = pid;
    }

    private String Pid,EditText_engineerprogram_production_str,Editext_pijianhao_str,Edit_investment_money_str,Edit_orginal_pijianhao_str,Edit_production_engineerTime_str,
            Edit_production_contractNum_str,Edit_production_startday_str,Edit_production_endday_str,Edit_production_signDate_str,Edit_production_performance_str;

    public void setEditext_pijianhao_str(String editext_pijianhao_str) {
        Editext_pijianhao_str = editext_pijianhao_str;
    }

    public void setEdit_investment_money_str(String edit_investment_money_str) {
        Edit_investment_money_str = edit_investment_money_str;
    }

    public void setEdit_orginal_pijianhao_str(String edit_orginal_pijianhao_str) {
        Edit_orginal_pijianhao_str = edit_orginal_pijianhao_str;
    }

    public void setEdit_production_engineerTime_str(String edit_production_engineerTime_str) {
        Edit_production_engineerTime_str = edit_production_engineerTime_str;
    }

    public void setEdit_production_contractNum_str(String edit_production_contractNum_str) {
        Edit_production_contractNum_str = edit_production_contractNum_str;
    }

    public void setEdit_production_startday_str(String edit_production_startday_str) {
        Edit_production_startday_str = edit_production_startday_str;
    }

    public void setEdit_production_endday_str(String edit_production_endday_str) {
        Edit_production_endday_str = edit_production_endday_str;
    }

    public void setEdit_production_signDate_str(String edit_production_signDate_str) {
        Edit_production_signDate_str = edit_production_signDate_str;
    }

    public void setEdit_production_performance_str(String edit_production_performance_str) {
        Edit_production_performance_str = edit_production_performance_str;
    }

    public void setEditText_engineerprogram_production_str(String editText_engineerprogram_production_str) {
        EditText_engineerprogram_production_str = editText_engineerprogram_production_str;
    }

    public String getEdit_production_performance_str() {
        return Edit_production_performance_str;
    }

    public String getEditText_engineerprogram_production_str() {
        return EditText_engineerprogram_production_str;
    }

    public String getEditext_pijianhao_str() {
        return Editext_pijianhao_str;
    }

    public String getEdit_investment_money_str() {
        return Edit_investment_money_str;
    }

    public String getEdit_orginal_pijianhao_str() {
        return Edit_orginal_pijianhao_str;
    }

    public String getEdit_production_engineerTime_str() {
        return Edit_production_engineerTime_str;
    }

    public String getEdit_production_contractNum_str() {
        return Edit_production_contractNum_str;
    }

    public String getEdit_production_startday_str() {
        return Edit_production_startday_str;
    }

    public String getEdit_production_endday_str() {
        return Edit_production_endday_str;
    }

    public String getEdit_production_signDate_str() {
        return Edit_production_signDate_str;
    }

    EditText EditText_engineerprogram_production,Editext_pijianhao,Edit_investment_money,Edit_orginal_pijianhao,Edit_production_engineerTime,
            Edit_production_contractNum,Edit_production_startday,Edit_production_endday,Edit_production_signDate,Edit_production_performance;



    public Mydialog_contract(@NonNull Context context,@StyleRes int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydialog_contract);

        initview();
        initData();
        INITclick();
        SetEditTextnotENeditable();
    }
    /*接口*/
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

    public void INITclick(){
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(yesOnclickListener!=null){
                    yesOnclickListener.onYesOnclick();
                }
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(noOnclickListener!=null){
                    noOnclickListener.onNoOnclick();
                }
            }
        });
    }

    private void initData() {
        //如果用户自定了title和message

        if (titleStr != null) {
            titleTV.setText(titleStr);
        }
        if (messageStr != null) {
            message.setText(messageStr);
        }


        /* EditText_engineerprogram_production_str,Editext_pijianhao_str,Edit_investment_money_str,Edit_orginal_pijianhao_str,Edit_production_engineerTime_str,
            Edit_production_contractNum_str,Edit_production_startday_str,Edit_production_endday_str,Edit_production_signDate_str,Edit_production_performance_str;
*/
        if(EditText_engineerprogram_production_str!=null){
            EditText_engineerprogram_production.setText(EditText_engineerprogram_production_str);
        }
        if (Editext_pijianhao_str!=null){
            Editext_pijianhao.setText(Editext_pijianhao_str);
        }
        if(Edit_investment_money_str!=null){
            Edit_investment_money.setText(Edit_investment_money_str);
        }
//        if (workUnitstr!=null){
//            workUnit.setText(workUnitstr);
//        }
        if(Edit_production_engineerTime_str!=null){
            Edit_production_engineerTime.setText(Edit_production_engineerTime_str);
        }
        if(Edit_production_contractNum_str!=null){
            Edit_production_contractNum.setText(Edit_production_contractNum_str);
        }
        if (Edit_production_startday_str!=null){
            Edit_production_startday.setText(Edit_production_startday_str);
        }
        if(Edit_production_endday_str!=null){
            Edit_production_endday.setText(Edit_production_endday_str);
        }
        if(Edit_production_signDate_str!=null){
            Edit_production_signDate.setText(Edit_production_signDate_str);
        }

        if(Edit_production_performance_str!=null){
            Edit_production_performance.setText(Edit_production_performance_str);
        }
        //如果设置按钮文字
        if (yesStr != null) {
            yes.setText(yesStr);
        }
        if (noStr != null) {
            no.setText(noStr);
        }
    }

    public void setMessageStr(String messageStr) {
        this.messageStr = messageStr;
    }

    public void setMessage(TextView message) {
        this.message = message;
    }

    /*EditText_engineerprogram_production,Editext_pijianhao,Edit_investment_money,Edit_orginal_pijianhao,Edit_production_engineerTime,
            Edit_production_contractNum,Edit_production_startday,Edit_production_endday,Edit_production_signDate,Edit_production_performance;
*/
    public void SetEditTextnotENeditable(){
        EditText_engineerprogram_production.setEnabled(false);
        Editext_pijianhao.setEnabled(false);
        Edit_investment_money.setEnabled(false);
        Edit_production_engineerTime.setEnabled(false);
        Edit_production_contractNum.setEnabled(false);
        Edit_production_startday.setEnabled(false);
        Edit_production_endday.setEnabled(false);
        Edit_production_signDate.setEnabled(false);
        Edit_production_performance.setEnabled(false);
    }
    public void SetEditTextENeditable(){

        EditText_engineerprogram_production= (EditText) findViewById(R.id.EditText_engineerprogram_production);
        Editext_pijianhao= (EditText) findViewById(R.id.Editext_pijianhao);
        Edit_investment_money= (EditText) findViewById(R.id.Edit_investment_money);

//        workUnit= (EditText) findViewById(R.id.Spinner_workCompany_dialog);
        Edit_production_contractNum= (EditText) findViewById(R.id.Edit_production_contractNum);
        Edit_production_startday= (EditText) findViewById(R.id.Edit_production_startday);
        Edit_production_endday= (EditText) findViewById(R.id.Edit_production_endday);
        Edit_production_signDate= (EditText) findViewById(R.id.Edit_production_signDate);
        Edit_production_performance= (EditText) findViewById(R.id.Edit_production_performance);

        EditText_engineerprogram_production.setEnabled(true);
        Editext_pijianhao.setEnabled(true);
        Edit_investment_money.setEnabled(true);
        Edit_production_contractNum.setEnabled(true);
        Edit_production_startday.setEnabled(true);
        Edit_production_endday.setEnabled(true);
        Edit_production_signDate.setEnabled(true);
        Edit_production_performance.setEnabled(true);
    }

    public void  initview(){
        yes= (Button) findViewById(R.id.yes_production);
        no= (Button) findViewById(R.id.no_produtions);
        titleTV= (TextView) findViewById(R.id.title_production);
        message= (TextView) findViewById(R.id.Text_engeenirName_production);

     /*   EditText_engineerprogram_production,Editext_pijianhao,Edit_investment_money,Edit_orginal_pijianhao,Edit_production_engineerTime,
                Edit_production_contractNum,Edit_production_startday,Edit_production_endday,Edit_production_signDate,Edit_production_performance;
     */
        EditText_engineerprogram_production= (EditText) findViewById(R.id.EditText_engineerprogram_production);
        Editext_pijianhao= (EditText) findViewById(R.id.Editext_pijianhao);
        Edit_investment_money= (EditText) findViewById(R.id.Edit_investment_money);
        Edit_production_engineerTime= (EditText) findViewById(R.id.Edit_production_engineerTime);
//        workUnit= (EditText) findViewById(R.id.Spinner_workCompany_dialog);
        Edit_production_contractNum= (EditText) findViewById(R.id.Edit_production_contractNum);
        Edit_production_startday= (EditText) findViewById(R.id.Edit_production_startday);
        Edit_production_endday= (EditText) findViewById(R.id.Edit_production_endday);
        Edit_production_signDate= (EditText) findViewById(R.id.Edit_production_signDate);
        Edit_production_performance= (EditText) findViewById(R.id.Edit_production_performance);
    }
}
