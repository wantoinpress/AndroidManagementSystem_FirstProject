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

import zdfwuy.newproject.R;

public class Mydialog_budget extends Dialog {

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

    public String getEditText_engineerprogram_production_str() {
        return EditText_engineerprogram_production_str;
    }

    public String getEditext_pijianhao_str() {
        return Editext_pijianhao_str;
    }

    public String getEdit_budgetMoney_money_str() {
        return Edit_budgetMoney_money_str;
    }

    public String getEdit_laborCost_str() {
        return Edit_laborCost_str;
    }

    public String getEdit_consumptioncost_str() {
        return Edit_consumptioncost_str;
    }

    public String getEdit_mechanicsCost_str() {
        return Edit_mechanicsCost_str;
    }

    public String getEdit_takeCost_str() {
        return Edit_takeCost_str;
    }

    public String getEdit_finalBudget_str() {
        return Edit_finalBudget_str;
    }

    public String getEdit_bmaterialCost_str() {
        return Edit_bmaterialCost_str;
    }

    public String getEdit_amaterialCost_str() {
        return Edit_amaterialCost_str;
    }

    public void setEditText_engineerprogram_production_str(String editText_engineerprogram_production_str) {
        EditText_engineerprogram_production_str = editText_engineerprogram_production_str;
    }

    public void setEditext_pijianhao_str(String editext_pijianhao_str) {
        Editext_pijianhao_str = editext_pijianhao_str;
    }

    public void setEdit_budgetMoney_money_str(String edit_budgetMoney_money_str) {
        Edit_budgetMoney_money_str = edit_budgetMoney_money_str;
    }

    public void setEdit_laborCost_str(String edit_laborCost_str) {
        Edit_laborCost_str = edit_laborCost_str;
    }

    public void setEdit_consumptioncost_str(String edit_consumptioncost_str) {
        Edit_consumptioncost_str = edit_consumptioncost_str;
    }

    public void setEdit_mechanicsCost_str(String edit_mechanicsCost_str) {
        Edit_mechanicsCost_str = edit_mechanicsCost_str;
    }

    public void setEdit_takeCost_str(String edit_takeCost_str) {
        Edit_takeCost_str = edit_takeCost_str;
    }

    public void setEdit_finalBudget_str(String edit_finalBudget_str) {
        Edit_finalBudget_str = edit_finalBudget_str;
    }

    public void setEdit_bmaterialCost_str(String edit_bmaterialCost_str) {
        Edit_bmaterialCost_str = edit_bmaterialCost_str;
    }

    public void setEdit_amaterialCost_str(String edit_amaterialCost_str) {
        Edit_amaterialCost_str = edit_amaterialCost_str;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    private String pid,EditText_engineerprogram_production_str,Editext_pijianhao_str,Edit_budgetMoney_money_str,
            Edit_laborCost_str,Edit_consumptioncost_str,Edit_mechanicsCost_str,Edit_takeCost_str,
    Edit_finalBudget_str,Edit_bmaterialCost_str,Edit_amaterialCost_str;

    EditText EditText_engineerprogram_production,Editext_pijianhao,Edit_budgetMoney_money,
            Edit_laborCost,Edit_consumptioncost,Edit_mechanicsCost,Edit_takeCost,
            Edit_finalBudget,Edit_bmaterialCost,Edit_amaterialCost;

    public Mydialog_budget(@NonNull Context context,@StyleRes int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydialog_budget);

        InitView();
        initData();
        initonclick();
        SetEditTextnotENeditable();
    }

    public void SetEditTextnotENeditable(){

        EditText_engineerprogram_production.setEnabled(false);
        Editext_pijianhao.setEnabled(false);
        Edit_budgetMoney_money.setEnabled(false);

        Edit_laborCost.setEnabled(false);
        Edit_consumptioncost.setEnabled(false);
        Edit_mechanicsCost.setEnabled(false);
        Edit_takeCost.setEnabled(false);
        Edit_finalBudget.setEnabled(false);
        Edit_bmaterialCost.setEnabled(false);
        Edit_amaterialCost.setEnabled(false);

    }
    public void SetEditTextENeditable(){

        EditText_engineerprogram_production= (EditText) findViewById(R.id.EditText_engineerprogram_production);
        Editext_pijianhao= (EditText) findViewById(R.id.Editext_pijianhao);
        Edit_budgetMoney_money= (EditText) findViewById(R.id.Edit_budgetMoney_money);
        Edit_laborCost= (EditText) findViewById(R.id.Edit_laborCost);
//        workUnit= (EditText) findViewById(R.id.Spinner_workCompany_dialog);
        Edit_consumptioncost= (EditText) findViewById(R.id.Edit_consumptioncost);
        Edit_mechanicsCost= (EditText) findViewById(R.id.Edit_mechanicsCost);
        Edit_takeCost= (EditText) findViewById(R.id.Edit_takeCost);
        Edit_finalBudget= (EditText) findViewById(R.id.Edit_finalBudget);
        Edit_bmaterialCost= (EditText) findViewById(R.id.Edit_bmaterialCost);
        Edit_amaterialCost= (EditText) findViewById(R.id.Edit_amaterialCost);

        EditText_engineerprogram_production.setEnabled(true);
        Editext_pijianhao.setEnabled(true);
        Edit_budgetMoney_money.setEnabled(true);
        Edit_laborCost.setEnabled(true);
        Edit_consumptioncost.setEnabled(true);
        Edit_mechanicsCost.setEnabled(true);
        Edit_takeCost.setEnabled(true);
        Edit_finalBudget.setEnabled(true);
        Edit_bmaterialCost.setEnabled(true);
        Edit_amaterialCost.setEnabled(true);
    }

    private void initData() {
        //如果用户自定了title和message

        /*  private String engineerNamestr,startDatestr,numOfItemstr,workUnitstr,endDatestr,planEndperiodstr,
        engineerMainMessagestr,thisWeekCompleteProcessstr,
            engineerTotalProcessstr,restProcessstr,nextWeekPlanstr,signPerformencestr,HREquipmentstr,fillingDatestr;
*/
        if (titleStr != null) {
            titleTV.setText(titleStr);
        }
        if (messageStr != null) {
            message.setText(messageStr);
        }

        /*String EditText_engineerprogram_production_str,Editext_pijianhao_str,Edit_budgetMoney_money_str,
            Edit_laborCost_str,Edit_consumptioncost_str,Edit_mechanicsCost_str,Edit_takeCost_str,
    Edit_finalBudget_str,Edit_bmaterialCost_str,Edit_amaterialCost_str;*/
        if(EditText_engineerprogram_production_str!=null){
            EditText_engineerprogram_production.setText(EditText_engineerprogram_production_str);
        }
        if (Editext_pijianhao_str!=null){
            Editext_pijianhao.setText(Editext_pijianhao_str);
        }
        if(Edit_budgetMoney_money_str!=null){
            Edit_budgetMoney_money.setText(Edit_budgetMoney_money_str);
        }
//        if (workUnitstr!=null){
//            workUnit.setText(workUnitstr);
//        }
        if(Edit_laborCost_str!=null){
            Edit_laborCost.setText(Edit_laborCost_str);
        }
        if(Edit_consumptioncost_str!=null){
            Edit_consumptioncost.setText(Edit_consumptioncost_str);
        }
        if(Edit_mechanicsCost_str!=null){
            Edit_mechanicsCost.setText(Edit_mechanicsCost_str);
        }
        if (Edit_takeCost_str!=null){
            Edit_takeCost.setText(Edit_takeCost_str);
        }
        if(Edit_finalBudget_str!=null){
            Edit_finalBudget.setText(Edit_finalBudget_str);
        }
        if(Edit_bmaterialCost_str!=null){
            Edit_bmaterialCost.setText(Edit_bmaterialCost_str);
        }

        if(Edit_amaterialCost_str!=null){
            Edit_amaterialCost.setText(Edit_amaterialCost_str);
        }

        //如果设置按钮文字
        if (yesStr != null) {
            yes.setText(yesStr);
        }
        if (noStr != null) {
            no.setText(noStr);
        }
    }

    private void initonclick() {
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (yesOnclickListener!=null){
                    yesOnclickListener.yesonclick();
                }
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(noOnclickListener!=null){
                    noOnclickListener.noonclick();
                }
            }
        });
    }

    private void InitView() {
        yes= (Button) findViewById(R.id.yes_production);
        no= (Button) findViewById(R.id.no_produtions);
        titleTV= (TextView) findViewById(R.id.title_production);
        message= (TextView) findViewById(R.id.Text_engeenirName_production);

        /*EditText_engineerprogram_production,Editext_pijianhao,Edit_budgetMoney_money,
            Edit_laborCost,Edit_consumptioncost,Edit_mechanicsCost,Edit_takeCost,
            Edit_finalBudget,Edit_bmaterialCost,Edit_amaterialCost;
      */
        EditText_engineerprogram_production= (EditText) findViewById(R.id.EditText_engineerprogram_production);
        Editext_pijianhao= (EditText) findViewById(R.id.Editext_pijianhao);
        Edit_budgetMoney_money= (EditText) findViewById(R.id.Edit_budgetMoney_money);
        Edit_laborCost= (EditText) findViewById(R.id.Edit_laborCost);
//        workUnit= (EditText) findViewById(R.id.Spinner_workCompany_dialog);
        Edit_consumptioncost= (EditText) findViewById(R.id.Edit_consumptioncost);
        Edit_mechanicsCost= (EditText) findViewById(R.id.Edit_mechanicsCost);
        Edit_takeCost= (EditText) findViewById(R.id.Edit_takeCost);
        Edit_finalBudget= (EditText) findViewById(R.id.Edit_finalBudget);
        Edit_bmaterialCost= (EditText) findViewById(R.id.Edit_bmaterialCost);
        Edit_amaterialCost= (EditText) findViewById(R.id.Edit_amaterialCost);

    }

    public  interface  onYesOnclickListener {
        public void yesonclick();
    }
    public  interface  onNoOnclickListener  {
        public void noonclick();
    }
    public void setYesOnclickListener(String res,onYesOnclickListener onYesOnclickListener1)
    {
        if(res!=null){
            this.yesStr=res;
        }
        this.yesOnclickListener=onYesOnclickListener1;
    }
    public  void setNoOnclickListener(String res,onNoOnclickListener onNoOnclickListener1){
        if(res!=null){
            this.noStr=res;
        }
        this.noOnclickListener=onNoOnclickListener1;
    }



}
