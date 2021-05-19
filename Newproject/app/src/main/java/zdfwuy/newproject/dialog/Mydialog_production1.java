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

public class Mydialog_production1 extends Dialog {
       private Button yes;//确定按钮
    private Button no;//取消按钮
    private TextView titleTV;//消息标题文本
    private TextView message;//消息提示文本
    private String titleStr;//从外界设置的title文本
    private String messageStr;//从外界设置的消息文本
    //确定文本和取消文本的显示的内容
    private String yesStr, noStr;
    private onNoOnclickListener noOnclickListener;//取消按钮被点击了的监听器
    private onYesOnclickListener yesOnclickListener;



    EditText engineerName,startDate,numOfItem,workUnit,endDate,planEndperiod,engineerMainMessage,thisWeekCompleteProcess,
            engineerTotalProcess,restProcess,nextWeekPlan,signPerformence,HREquipment,fillingDate;

    public void setYesstr(String yes){
        this.yesStr=yes;
    }
    public void setNostr(String no){
        this.noStr=no;
    }
    public void setEngineerNamestr(String engineerNamestr) {
        this.engineerNamestr = engineerNamestr;
    }

    public void setStartDatestr(String startDatestr) {
        this.startDatestr = startDatestr;
    }

    public void setNumOfItemstr(String numOfItemstr) {
        this.numOfItemstr = numOfItemstr;
    }

//    public void setWorkUnitstr(String workUnitstr) {
//        this.workUnitstr = workUnitstr;
//    }

    public void setEndDatestr(String endDatestr) {
        this.endDatestr = endDatestr;
    }

    public void setPlanEndperiodstr(String planEndperiodstr) {
        this.planEndperiodstr = planEndperiodstr;
    }

    public void setEngineerMainMessagestr(String engineerMainMessagestr) {
        this.engineerMainMessagestr = engineerMainMessagestr;
    }

    public void setThisWeekCompleteProcessstr(String thisWeekCompleteProcessstr) {
        this.thisWeekCompleteProcessstr = thisWeekCompleteProcessstr;
    }

    public void setEngineerTotalProcessstr(String engineerTotalProcessstr) {
        this.engineerTotalProcessstr = engineerTotalProcessstr;
    }

    public void setRestProcessstr(String restProcessstr) {
        this.restProcessstr = restProcessstr;
    }

    public void setNextWeekPlanstr(String nextWeekPlanstr) {
        this.nextWeekPlanstr = nextWeekPlanstr;
    }

//    public void setSignPerformencestr(String signPerformencestr) {
//        this.signPerformencestr = signPerformencestr;
//    }

//    public void setHREquipmentstr(String HREquipmentstr) {
//        this.HREquipmentstr = HREquipmentstr;
//    }

//    public void setFillingDatestr(String fillingDatestr) {
//        this.fillingDatestr = fillingDatestr;
//    }


    /*
    * engineerName= (EditText) findViewById(R.id.EditText_engineerprogram_production);
        startDate= (EditText) findViewById(R.id.Edit_production_starday);
        endDate= (EditText) findViewById(R.id.Edit_production_endday);
        numOfItem= (EditText) findViewById(R.id.Edit_orginal_pijianhao);
//        workUnit= (EditText) findViewById(R.id.Spinner_workCompany_dialog);
        planEndperiod= (EditText) findViewById(R.id.Edit_production_peroidplan);
        engineerMainMessage= (EditText) findViewById(R.id.Edit_production_engineerMainMessage);
        thisWeekCompleteProcess= (EditText) findViewById(R.id.Edit_production_thisWeekCompleteProcess);
        engineerTotalProcess= (EditText) findViewById(R.id.Edit_production_engineerTotalProcess);
        restProcess= (EditText) findViewById(R.id.Edit_production_restProcess);
        nextWeekPlan= (EditText) findViewById(R.id.Edit_production_nextWeekPlan);
        signPerformence= (EditText) findViewById(R.id.Edit_production_signPerformence);
        HREquipment= (EditText) findViewById(R.id.Edit_production_hrequipment);
        fillingDate= (EditText) findViewById(R.id.Edit_production_fillingDate);
    * */
    public String getEngineerNamestr() {

        return engineerNamestr;
    }

    public String getStartDatestr() {
        return startDatestr;
    }

    public String getNumOfItemstr() {
        return numOfItemstr;
    }

//    public String getWorkUnitstr() {
//        return workUnitstr;
//    }

    public String getEndDatestr() {
        return endDatestr;
    }

    public String getPlanEndperiodstr() {
        return planEndperiodstr;
    }

    public String getEngineerMainMessagestr() {
        return engineerMainMessagestr;
    }

    public String getThisWeekCompleteProcessstr() {
        return thisWeekCompleteProcessstr;
    }

    public String getEngineerTotalProcessstr() {
        return engineerTotalProcessstr;
    }

    public String getRestProcessstr() {
        return restProcessstr;
    }

    public String getNextWeekPlanstr() {
        return nextWeekPlanstr;
    }
//
//    public String getSignPerformencestr() {
//        return signPerformencestr;
//    }

//    public String getHREquipmentstr() {
//        return HREquipmentstr;
//    }

//    public String getFillingDatestr() {
//        return fillingDatestr;
//    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    private String pid,engineerNamestr,startDatestr,numOfItemstr,workUnitstr,endDatestr,planEndperiodstr,engineerMainMessagestr,thisWeekCompleteProcessstr,
            engineerTotalProcessstr,restProcessstr,nextWeekPlanstr,signPerformencestr,HREquipmentstr,fillingDatestr;



 /*  BigDecimal investMoney;
    BigDecimal contractMoney;
    BigDecimal imageProcess;
   */


    public void SetEditTextnotENeditable(){
        engineerName.setEnabled(false);
        startDate.setEnabled(false);
        numOfItem.setEnabled(false);

        endDate.setEnabled(false);
        planEndperiod.setEnabled(false);
        engineerMainMessage.setEnabled(false);
        thisWeekCompleteProcess.setEnabled(false);
        engineerTotalProcess.setEnabled(false);
        restProcess.setEnabled(false);
        nextWeekPlan.setEnabled(false);
//        signPerformence.setEnabled(false);
//        HREquipment.setEnabled(false);
//        fillingDate.setEnabled(false);

    }
    public void SetEditTextENeditable(){

        engineerName= (EditText) findViewById(R.id.EditText_engineerprogram_production);
        startDate= (EditText) findViewById(R.id.Edit_production_starday);
        endDate= (EditText) findViewById(R.id.Edit_production_endday);
        numOfItem= (EditText) findViewById(R.id.Edit_orginal_pijianhao);
//        workUnit= (EditText) findViewById(R.id.Spinner_workCompany_dialog);
        planEndperiod= (EditText) findViewById(R.id.Edit_production_peroidplan);
        engineerMainMessage= (EditText) findViewById(R.id.Edit_production_engineerMainMessage);
        thisWeekCompleteProcess= (EditText) findViewById(R.id.Edit_production_thisWeekCompleteProcess);
        engineerTotalProcess= (EditText) findViewById(R.id.Edit_production_engineerTotalProcess);
        restProcess= (EditText) findViewById(R.id.Edit_production_restProcess);
        nextWeekPlan= (EditText) findViewById(R.id.Edit_production_nextWeekPlan);
//        signPerformence= (EditText) findViewById(R.id.Edit_production_signPerformence);
//        HREquipment= (EditText) findViewById(R.id.Edit_production_hrequipment);
//        fillingDate= (EditText) findViewById(R.id.Edit_production_fillingDate);

        engineerName.setEnabled(true);
        startDate.setEnabled(true);
        endDate.setEnabled(true);
        numOfItem.setEnabled(true);
        planEndperiod.setEnabled(true);
        engineerMainMessage.setEnabled(true);
        thisWeekCompleteProcess.setEnabled(true);
        engineerTotalProcess.setEnabled(true);
        restProcess.setEnabled(true);
        nextWeekPlan.setEnabled(true);
//        signPerformence.setEnabled(true);
//        HREquipment.setEnabled(true);
//        fillingDate.setEnabled(true);
    }

    public Mydialog_production1(@NonNull Context context,@StyleRes int theme) {
        super(context, theme);
    }

/*engineerName,startDate,numOfItem,workUnit,endDate,planEndperiod,engineerMainMessage,thisWeekCompleteProcess,
            engineerTotalProcess,restProcess,nextWeekPlan,signPerformence,HREquipment,fillingDate*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydialog_production1);
        setCanceledOnTouchOutside(false);


        initview();

        initData();

        initView();
        SetEditTextnotENeditable();
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
        if(engineerNamestr!=null){
            engineerName.setText(engineerNamestr);
        }
        if (startDatestr!=null){
            startDate.setText(startDatestr);
        }
        if(numOfItemstr!=null){
            numOfItem.setText(numOfItemstr);
        }
//        if (workUnitstr!=null){
//            workUnit.setText(workUnitstr);
//        }
        if(endDatestr!=null){
            endDate.setText(endDatestr);
        }
        if(planEndperiodstr!=null){
            planEndperiod.setText(planEndperiodstr);
        }
        if(numOfItemstr!=null){
            numOfItem.setText(numOfItemstr);
        }
        if (engineerMainMessagestr!=null){
            engineerMainMessage.setText(engineerMainMessagestr);
        }
        if(thisWeekCompleteProcessstr!=null){
            thisWeekCompleteProcess.setText(thisWeekCompleteProcessstr);
        }
        if(engineerTotalProcessstr!=null){
            engineerTotalProcess.setText(engineerTotalProcessstr);
        }

        if(restProcessstr!=null){
            restProcess.setText(restProcessstr);
        }
        if(nextWeekPlanstr!=null){
            nextWeekPlan.setText(nextWeekPlanstr);
        }
//        if(signPerformencestr!=null){
//            signPerformence.setText(signPerformencestr);
//        }
//        if (HREquipmentstr!=null){
//            HREquipment.setText(HREquipmentstr);
//        }
//        if(fillingDatestr!=null){
//            fillingDate.setText(fillingDatestr);
//        }
        //如果设置按钮文字
        if (yesStr != null) {
            yes.setText(yesStr);
        }
        if (noStr != null) {
            no.setText(noStr);
        }
    }

    /*创建两个接口*/
    public interface onNoOnclickListener{
        public void onNoclick();
    }
    public interface onYesOnclickListener{
        public void onYesclick();
    }


    public void setYesOnclickListener(String str,onYesOnclickListener yesOnclickListener){
        if(" ".equals(str)){
            this.yesStr=str;
        }
        this.yesOnclickListener=yesOnclickListener;

    }

    public void setNoOnclickListener(String str,onNoOnclickListener noOnclickListener){
        if(" ".equals(str))
        {
            this.noStr=str;
        }
        this.noOnclickListener=noOnclickListener;
    }

    public void  initview(){
        yes= (Button) findViewById(R.id.yes_production);
        no= (Button) findViewById(R.id.no_produtions);
        titleTV= (TextView) findViewById(R.id.title_production);
        message= (TextView) findViewById(R.id.Text_engeenirName_production);
        engineerName= (EditText) findViewById(R.id.EditText_engineerprogram_production);
        startDate= (EditText) findViewById(R.id.Edit_production_starday);
        endDate= (EditText) findViewById(R.id.Edit_production_endday);
        numOfItem= (EditText) findViewById(R.id.Edit_orginal_pijianhao);
//        workUnit= (EditText) findViewById(R.id.Spinner_workCompany_dialog);
        planEndperiod= (EditText) findViewById(R.id.Edit_production_peroidplan);
        engineerMainMessage= (EditText) findViewById(R.id.Edit_production_engineerMainMessage);
        thisWeekCompleteProcess= (EditText) findViewById(R.id.Edit_production_thisWeekCompleteProcess);
        engineerTotalProcess= (EditText) findViewById(R.id.Edit_production_engineerTotalProcess);
        restProcess= (EditText) findViewById(R.id.Edit_production_restProcess);
        nextWeekPlan= (EditText) findViewById(R.id.Edit_production_nextWeekPlan);
//        signPerformence= (EditText) findViewById(R.id.Edit_production_signPerformence);
//        HREquipment= (EditText) findViewById(R.id.Edit_production_hrequipment);
//        fillingDate= (EditText) findViewById(R.id.Edit_production_fillingDate);
    }
    /*设立相应的信息  */
    public void setMessageStr(String messageStr) {
        this.messageStr = messageStr;
    }

    public void setMessage(TextView message) {
        this.message = message;
    }

    /*初始化界面*/
    private void initView(){
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (yesOnclickListener !=null)
                    yesOnclickListener.onYesclick();
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (noOnclickListener != null){
                    noOnclickListener.onNoclick();
                }
            }
        });
    }

}
