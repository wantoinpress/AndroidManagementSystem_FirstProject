package zdfwuy.newproject.dialog;

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

import java.math.BigDecimal;

import zdfwuy.newproject.R;

public class Mydialog_cost extends Dialog {
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

    EditText Editext_engineerName,Edit_numOfItem,Edit_engineerIncome,Edit_engineerTime,Edit_settlementPreparationAmount,Edit_notReportedReview,
            Edit_reportConstructionUnit,Edit_reportBudgetDepartment,Edit_reportAudit,Edit_pendingAccountAfterAudit;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getEditext_engineerName_str() {
        return Editext_engineerName_str;
    }

    public void setEditext_engineerName_str(String editext_engineerName_str) {
        Editext_engineerName_str = editext_engineerName_str;
    }

    public String getEdit_numOfItem_str() {
        return Edit_numOfItem_str;
    }

    public void setEdit_numOfItem_str(String edit_numOfItem_str) {
        Edit_numOfItem_str = edit_numOfItem_str;
    }

    public BigDecimal getEdit_engineerIncome_str() {
        return Edit_engineerIncome_str;
    }

    public void setEdit_engineerIncome_str(BigDecimal edit_engineerIncome_str) {
        Edit_engineerIncome_str = edit_engineerIncome_str;
    }

    public String getEdit_engineerTime_str() {
        return Edit_engineerTime_str;
    }

    public void setEdit_engineerTime_str(String edit_engineerTime_str) {
        Edit_engineerTime_str = edit_engineerTime_str;
    }

    public String getEdit_settlementPreparationAmount_str() {
        return Edit_settlementPreparationAmount_str;
    }

    public void setEdit_settlementPreparationAmount_str(String edit_settlementPreparationAmount_str) {
        Edit_settlementPreparationAmount_str = edit_settlementPreparationAmount_str;
    }

    public String getEdit_notReportedReview_str() {
        return Edit_notReportedReview_str;
    }

    public void setEdit_notReportedReview_str(String edit_notReportedReview_str) {
        Edit_notReportedReview_str = edit_notReportedReview_str;
    }

    public String getEdit_reportConstructionUnit_str() {
        return Edit_reportConstructionUnit_str;
    }

    public void setEdit_reportConstructionUnit_str(String edit_reportConstructionUnit_str) {
        Edit_reportConstructionUnit_str = edit_reportConstructionUnit_str;
    }

    public String getEdit_reportBudgetDepartment_str() {
        return Edit_reportBudgetDepartment_str;
    }

    public void setEdit_reportBudgetDepartment_str(String edit_reportBudgetDepartment_str) {
        Edit_reportBudgetDepartment_str = edit_reportBudgetDepartment_str;
    }

    public String getEdit_reportAudit_str() {
        return Edit_reportAudit_str;
    }

    public void setEdit_reportAudit_str(String edit_reportAudit_str) {
        Edit_reportAudit_str = edit_reportAudit_str;
    }

    public String getEdit_pendingAccountAfterAudit_str() {
        return Edit_pendingAccountAfterAudit_str;
    }

    public void setEdit_pendingAccountAfterAudit_str(String edit_pendingAccountAfterAudit_str) {
        Edit_pendingAccountAfterAudit_str = edit_pendingAccountAfterAudit_str;
    }

    private String  pid;
    private String Editext_engineerName_str;
    private String Edit_numOfItem_str;
    private BigDecimal Edit_engineerIncome_str;
    private String Edit_engineerTime_str;
    private String Edit_settlementPreparationAmount_str;
    private String Edit_notReportedReview_str;
    private String Edit_reportConstructionUnit_str;
    private String Edit_reportBudgetDepartment_str;
    private String Edit_reportAudit_str;
    private String Edit_pendingAccountAfterAudit_str;
    public Mydialog_cost(@NonNull Context context,@StyleRes int theme) {
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
        setContentView(R.layout.activity_mydialog_cost);
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

     /* Editext_engineerName_str,Edit_numOfItem_str,Edit_engineerIncome_str,Edit_engineerTime_str,Edit_settlementPreparationAmount_str,Edit_notReportedReview_str,
            Edit_reportConstructionUnit_str,Edit_reportBudgetDepartment_str,Edit_reportAudit_str,Edit_pendingAccountAfterAudit_str; */
        Editext_engineerName= (EditText) findViewById(R.id.Editext_engineerName);
        Edit_numOfItem= (EditText) findViewById(R.id.Edit_numOfItem);
        Edit_engineerIncome= (EditText) findViewById(R.id.Edit_engineerIncome);
        Edit_engineerTime= (EditText) findViewById(R.id.Edit_engineerTime);
        Edit_settlementPreparationAmount= (EditText) findViewById(R.id.Edit_settlementPreparationAmount);
        Edit_notReportedReview= (EditText) findViewById(R.id.Edit_notReportedReview);
        Edit_reportConstructionUnit= (EditText) findViewById(R.id.Edit_reportConstructionUnit);
        Edit_reportBudgetDepartment= (EditText) findViewById(R.id.Edit_reportBudgetDepartment);

        Edit_reportAudit= (EditText) findViewById(R.id.Edit_reportAudit);
        Edit_pendingAccountAfterAudit= (EditText) findViewById(R.id.Edit_pendingAccountAfterAudit);


    }

    private void initData() {
        //如果用户自定了title和message

        if (titleStr != null) {
            titleTV.setText(titleStr);
        }
        if (messageStr != null) {
            message.setText(messageStr);
        }


      /*Editext_engineerName_str,Edit_numOfItem_str,Edit_engineerIncome_str,Edit_engineerTime_str,Edit_settlementPreparationAmount_str,Edit_notReportedReview_str,
            Edit_reportConstructionUnit_str,Edit_reportBudgetDepartment_str,Edit_reportAudit_str,Edit_pendingAccountAfterAudit_str; r*/
        if(Editext_engineerName_str!=null){
            Editext_engineerName.setText(Editext_engineerName_str);
        }
        if (Edit_numOfItem_str!=null){
            Edit_numOfItem.setText(Edit_numOfItem_str);
        }
        if(Edit_engineerIncome_str!=null){
            Edit_engineerIncome.setText(Edit_engineerIncome_str.toString());
        }
        if(Edit_engineerTime_str!=null){
            Edit_engineerTime.setText(Edit_engineerTime_str);
        }
        if (Edit_settlementPreparationAmount_str!=null){
            Edit_settlementPreparationAmount.setText(Edit_settlementPreparationAmount_str);
        }
        if(Edit_notReportedReview_str!=null){
            Edit_notReportedReview.setText(Edit_notReportedReview_str);
        }
        if(Edit_reportBudgetDepartment_str!=null){
            Edit_reportBudgetDepartment.setText(Edit_reportBudgetDepartment_str);
        }
        if (Edit_reportAudit_str!=null){
            Edit_reportAudit.setText(Edit_reportAudit_str);
        }
        if(Edit_pendingAccountAfterAudit_str!=null){
            Edit_pendingAccountAfterAudit.setText(Edit_pendingAccountAfterAudit_str);
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

        /*Editext_engineerName,Edit_numOfItem,Edit_engineerIncome,Edit_engineerTime,Edit_settlementPreparationAmount,Edit_notReportedReview,
            Edit_reportConstructionUnit,Edit_reportBudgetDepartment,Edit_reportAudit,Edit_pendingAccountAfterAudit;*/

        Editext_engineerName.setEnabled(false);
        Edit_numOfItem.setEnabled(false);
        Edit_engineerIncome.setEnabled(false);
        Edit_engineerTime.setEnabled(false);
        Edit_settlementPreparationAmount.setEnabled(false);
        Edit_notReportedReview.setEnabled(false);
        Edit_reportConstructionUnit.setEnabled(false);
        Edit_reportBudgetDepartment.setEnabled(false);
        Edit_reportAudit.setEnabled(false);
        Edit_pendingAccountAfterAudit.setEnabled(false);


    }
    public void SetEditTextENeditable(){
        Editext_engineerName.setEnabled(true);
        Edit_numOfItem.setEnabled(true);
        Edit_engineerIncome.setEnabled(true);
        Edit_engineerTime.setEnabled(true);
        Edit_settlementPreparationAmount.setEnabled(true);
        Edit_notReportedReview.setEnabled(true);
        Edit_reportConstructionUnit.setEnabled(true);
        Edit_reportBudgetDepartment.setEnabled(true);
        Edit_reportAudit.setEnabled(true);
        Edit_pendingAccountAfterAudit.setEnabled(true);
    }
}
