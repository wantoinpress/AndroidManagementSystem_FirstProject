package zdfwuy.newproject.Data_Collection_Total;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.alibaba.fastjson.JSONArray;

import java.util.HashMap;
import java.util.Map;

import zdfwuy.newproject.R;
import zdfwuy.newproject.data_collection.SerialMap1;
import zdfwuy.newproject.data_collection.NewCloectionInfo;
import zdfwuy.newproject.data_safeguard.SerializableMap;

public class Data_collection_from_onclick extends Activity {
    Button btn_cancel;
    NewCloectionInfo newCloectionInfo = new NewCloectionInfo();
    EditText et_contract_engineerName,et_contract_numOfItem,et_contract_constructionUnit,et_contract_workUnit,et_contract_investMoney,
            et_contract_isFin,et_contract_contractNum,et_contract_contractMoney,et_contract_comsume_signDate,et_contract_contractStartDate,
            et_contract_contractEndDate,et_contract_budgetMoney,et_contract_laborCost,et_contract_consumptionCost,et_contract_mechanicsCost,
            et_contract_takeCost,et_contract_workStartDate,et_contract_workEndDate,et_contract_planEndperiod,et_contract_engineerMainMessage,
    et_contract_thisWeekCompleteProcess,et_contract_engineerTotalProcess,et_contract_restProcess,et_contract_nextWeekPlan,et_contract_monthProduceVal,
            et_contract_monthAMaterial,et_contract_monthAdBeforeIncome,et_contract_yearAMaterial,et_contract_yearAdBeforeIncome;

    String et_contract_engineerName_s,et_contract_numOfItem_s,et_contract_constructionUnit_s,et_contract_workUnit_s,et_contract_investMoney_s,
            et_contract_isFin_s,et_contract_contractNum_s,et_contract_contractMoney_s,et_contract_comsume_signDate_s,et_contract_contractStartDate_s,
            et_contract_contractEndDate_s,et_contract_budgetMoney_s,et_contract_laborCost_s,et_contract_consumptionCost_s,et_contract_mechanicsCost_s,
            et_contract_takeCost_s,et_contract_workStartDate_s,et_contract_workEndDate_s,et_contract_planEndperiod_s,et_contract_engineerMainMessage_s,
            et_contract_thisWeekCompleteProcess_s,et_contract_engineerTotalProcess_s,et_contract_restProcess_s,et_contract_nextWeekPlan_s,et_contract_monthProduceVal_s,
            et_contract_monthAMaterial_s,et_contract_monthAdBeforeIncome_s,et_contract_yearAMaterial_s,et_contract_yearAdBeforeIncome_s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_collection_from_onclick);
        btn_cancel = (Button) findViewById(R.id.btn_cancel);
        Bundle bundle = getIntent().getExtras();
        SerialMap1 serializableMap = (SerialMap1) bundle.get("map");
        String key = (String) bundle.get("pid");
        Map<String, NewCloectionInfo> map = serializableMap.getMap();
        newCloectionInfo = map.get(key);
        InitEditText();
    }

    private void InitEditText() {
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        /*et_contract_engineerName,et_contract_numOfItem,et_contract_constructionUnit,et_contract_workUnit,et_contract_investMoney,
            et_contract_isFin,et_contract_contractNum,et_contract_contractMoney,et_contract_comsume_signDate,

            et_contract_contractStartDate,
            et_contract_contractEndDate,et_contract_budgetMoney,et_contract_laborCost,et_contract_consumptionCost,et_contract_mechanicsCost,
            et_contract_takeCost,et_contract_workStartDate,et_contract_workEndDate,

              et_contract_planEndperiod,et_contract_engineerMainMessage,
    et_contract_thisWeekCompleteProcess,et_contract_engineerTotalProcess,et_contract_restProcess,et_contract_nextWeekPlan,et_contract_monthProduceVal,
            et_contract_monthAMaterial,et_contract_monthAdBeforeIncome,et_contract_yearAMaterial,et_contract_yearAdBeforeIncome;*/
        et_contract_engineerName = (EditText) findViewById(R.id.et_contract_engineerName);

        et_contract_numOfItem = (EditText) findViewById(R.id.et_contract_numOfItem);

        et_contract_constructionUnit = (EditText) findViewById(R.id.et_contract_constructionUnit);
        et_contract_workUnit = (EditText) findViewById(R.id.et_contract_workUnit);
        et_contract_investMoney = (EditText) findViewById(R.id.et_contract_investMoney);
        et_contract_isFin = (EditText) findViewById(R.id.et_contract_isFin);
        et_contract_contractNum = (EditText) findViewById(R.id.et_contract_contractNum);
        et_contract_contractMoney = (EditText) findViewById(R.id.et_contract_contractMoney);
        et_contract_comsume_signDate = (EditText) findViewById(R.id.et_contract_comsume_signDate);

        et_contract_contractStartDate = (EditText) findViewById(R.id.et_contract_contractStartDate);
        et_contract_contractEndDate = (EditText) findViewById(R.id.et_contract_contractEndDate);
        et_contract_budgetMoney = (EditText) findViewById(R.id.et_contract_budgetMoney);
        et_contract_laborCost = (EditText) findViewById(R.id.et_contract_laborCost);
        et_contract_consumptionCost = (EditText) findViewById(R.id.et_contract_consumptionCost);
        et_contract_mechanicsCost = (EditText) findViewById(R.id.et_contract_mechanicsCost);
        et_contract_takeCost = (EditText) findViewById(R.id.et_contract_takeCost);
        et_contract_workStartDate = (EditText) findViewById(R.id.et_contract_workStartDate);
        et_contract_workEndDate = (EditText) findViewById(R.id.et_contract_workEndDate);

        et_contract_planEndperiod = (EditText) findViewById(R.id.et_contract_planEndperiod);
        et_contract_engineerMainMessage = (EditText) findViewById(R.id.et_contract_engineerMainMessage);
        et_contract_thisWeekCompleteProcess = (EditText) findViewById(R.id.et_contract_thisWeekCompleteProcess);
        et_contract_engineerTotalProcess = (EditText) findViewById(R.id.et_contract_engineerTotalProcess);
        et_contract_restProcess = (EditText) findViewById(R.id.et_contract_restProcess);

        et_contract_nextWeekPlan = (EditText) findViewById(R.id.et_contract_nextWeekPlan);
        et_contract_monthProduceVal = (EditText) findViewById(R.id.et_contract_monthProduceVal);
        et_contract_monthAMaterial = (EditText) findViewById(R.id.et_contract_monthAMaterial);
        et_contract_monthAdBeforeIncome = (EditText) findViewById(R.id.et_contract_monthAdBeforeIncome);
        et_contract_yearAMaterial = (EditText) findViewById(R.id.et_contract_yearAMaterial);

        et_contract_yearAdBeforeIncome = (EditText) findViewById(R.id.et_contract_yearAdBeforeIncome);
        /*et_contract_engineerName_s,et_contract_numOfItem_s,et_contract_constructionUnit_s,et_contract_workUnit_s,et_contract_investMoney_s,
            et_contract_isFin_s,et_contract_contractNum_s,et_contract_contractMoney_s,et_contract_comsume_signDate_s,et_contract_contractStartDate_s,
            et_contract_contractEndDate_s,et_contract_budgetMoney_s,et_contract_laborCost_s,et_contract_consumptionCost_s,et_contract_mechanicsCost_s,
            et_contract_takeCost_s,et_contract_workStartDate_s,et_contract_workEndDate_s,et_contract_planEndperiod_s,et_contract_engineerMainMessage_s,
            et_contract_thisWeekCompleteProcess_s,et_contract_engineerTotalProcess_s,et_contract_restProcess_s,et_contract_nextWeekPlan_s,et_contract_monthProduceVal_s,
            et_contract_monthAMaterial_s,et_contract_monthAdBeforeIncome_s,et_contract_yearAMaterial_s,et_contract_yearAdBeforeIncome_s;
*/
        et_contract_engineerName_s = newCloectionInfo.getEngineerName();
        et_contract_numOfItem_s = newCloectionInfo.getNumOfItem();
        et_contract_constructionUnit_s = newCloectionInfo.getConstructionUnit();
        et_contract_workUnit_s = newCloectionInfo.getWorkUnit();
        et_contract_investMoney_s = newCloectionInfo.getInvestMoney().toString();
        et_contract_isFin_s = newCloectionInfo.getIsFin();
        et_contract_contractNum_s = newCloectionInfo.getContractNum();
        et_contract_contractMoney_s = newCloectionInfo.getContractMoney().toString();


        //
        et_contract_contractStartDate_s = newCloectionInfo.getStartDate();
        et_contract_contractEndDate_s = newCloectionInfo.getEndDate();
        et_contract_budgetMoney_s = newCloectionInfo.getBudgetMoney().equals("") ? "" : newCloectionInfo.getBudgetMoney().toString();
        et_contract_laborCost_s = newCloectionInfo.getLaborCost().equals("") ? "" : newCloectionInfo.getLaborCost().toString();
        et_contract_consumptionCost_s = newCloectionInfo.getConsumptionCost().equals("") ? "" : newCloectionInfo.getConsumptionCost().toString();
        et_contract_mechanicsCost_s = newCloectionInfo.getMechanicsCost().equals("") ? "" : newCloectionInfo.getMechanicsCost().toString();
        et_contract_takeCost_s = newCloectionInfo.getTakeCost().equals("") ? "" : newCloectionInfo.getTakeCost().toString();
        et_contract_workStartDate_s = newCloectionInfo.getWorkStartDate();
        et_contract_workEndDate_s = newCloectionInfo.getWorkEndDate();



        et_contract_planEndperiod_s = newCloectionInfo.getPlanEndperiod();
        et_contract_engineerMainMessage_s = newCloectionInfo.getEngineerMainMessage();
        et_contract_thisWeekCompleteProcess_s = newCloectionInfo.getThisWeekCompleteProcess();
        et_contract_engineerTotalProcess_s = newCloectionInfo.getEngineerTotalProcess();
        et_contract_restProcess_s = newCloectionInfo.getRestProcess();
        et_contract_nextWeekPlan_s = newCloectionInfo.getNextWeekPlan();
        et_contract_monthProduceVal_s = newCloectionInfo.getMonthProduceVal().toString();
        et_contract_monthAMaterial_s = newCloectionInfo.getMonthAMaterial().toString();
        et_contract_monthAdBeforeIncome_s = newCloectionInfo.getMonthAdBeforeIncome().toString();
        et_contract_yearAMaterial_s = newCloectionInfo.getYearAMaterial().toString();
        et_contract_yearAdBeforeIncome_s = newCloectionInfo.getYearAdBeforeIncome().toString();

        et_contract_planEndperiod.setText(et_contract_planEndperiod_s);
        et_contract_engineerMainMessage.setText(et_contract_engineerMainMessage_s);
        et_contract_thisWeekCompleteProcess.setText(et_contract_thisWeekCompleteProcess_s);
        et_contract_engineerTotalProcess.setText(et_contract_engineerTotalProcess_s);
        et_contract_restProcess.setText(et_contract_restProcess_s);
        et_contract_nextWeekPlan.setText(et_contract_nextWeekPlan_s);
        et_contract_monthProduceVal.setText(et_contract_monthProduceVal_s);
        et_contract_monthAMaterial.setText(et_contract_monthAMaterial_s);
        et_contract_monthAdBeforeIncome.setText(et_contract_monthAdBeforeIncome_s);
        et_contract_yearAMaterial.setText(et_contract_yearAMaterial_s);
        et_contract_yearAdBeforeIncome.setText(et_contract_yearAdBeforeIncome_s);


        et_contract_engineerName.setText(et_contract_engineerName_s);
        et_contract_numOfItem.setText(et_contract_numOfItem_s);
        et_contract_constructionUnit.setText(et_contract_constructionUnit_s);
        et_contract_workUnit.setText(et_contract_workUnit_s);
        et_contract_investMoney.setText(et_contract_investMoney_s);
        et_contract_isFin.setText(et_contract_isFin_s);
        et_contract_contractNum.setText(et_contract_contractNum_s);
        et_contract_contractMoney.setText(et_contract_contractMoney_s);


        et_contract_contractStartDate.setText(et_contract_contractStartDate_s);
        et_contract_contractEndDate.setText(et_contract_contractEndDate_s);
        et_contract_budgetMoney.setText(et_contract_budgetMoney_s);
        et_contract_laborCost.setText(et_contract_laborCost_s);
        et_contract_consumptionCost.setText(et_contract_consumptionCost_s);
        et_contract_mechanicsCost.setText(et_contract_mechanicsCost_s);
        et_contract_takeCost.setText(et_contract_takeCost_s);
        et_contract_workStartDate.setText(et_contract_workStartDate_s);
        et_contract_workEndDate.setText(et_contract_workEndDate_s);



        //
        et_contract_planEndperiod.setEnabled(false);
        et_contract_engineerMainMessage.setEnabled(false);
        et_contract_thisWeekCompleteProcess.setEnabled(false);
        et_contract_engineerTotalProcess.setEnabled(false);
        et_contract_restProcess.setEnabled(false);
        et_contract_nextWeekPlan.setEnabled(false);
        et_contract_monthProduceVal.setEnabled(false);
        et_contract_monthAMaterial.setEnabled(false);
        et_contract_monthAdBeforeIncome.setEnabled(false);
        et_contract_yearAMaterial.setEnabled(false);
        et_contract_yearAdBeforeIncome.setEnabled(false);


        et_contract_engineerName.setEnabled(false);
        et_contract_numOfItem.setEnabled(false);
        et_contract_constructionUnit.setEnabled(false);
        et_contract_workUnit.setEnabled(false);
        et_contract_investMoney.setEnabled(false);
        et_contract_isFin.setEnabled(false);
        et_contract_contractNum.setEnabled(false);
        et_contract_contractMoney.setEnabled(false);


        et_contract_contractStartDate.setEnabled(false);
        et_contract_contractEndDate.setEnabled(false);
        et_contract_budgetMoney.setEnabled(false);
        et_contract_laborCost.setEnabled(false);
        et_contract_consumptionCost.setEnabled(false);
        et_contract_mechanicsCost.setEnabled(false);
        et_contract_takeCost.setEnabled(false);
        et_contract_workStartDate.setEnabled(false);
        et_contract_workEndDate.setEnabled(false);
        et_contract_comsume_signDate.setEnabled(false);
    }

}
