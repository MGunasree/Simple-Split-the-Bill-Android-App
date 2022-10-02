package com.example.splitthebillapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Screen2 extends AppCompatActivity {
    //Declare variables;
    double tip;
    double billTotal,finalBill;
    int noOfPeople;
    String groupChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        final EditText bill=(EditText) findViewById(R.id.txtBill);
        final EditText group=(EditText) findViewById(R.id.txtGroup);
        final EditText tipamt=(EditText) findViewById(R.id.tip);
        final Spinner spinner=(Spinner) findViewById(R.id.spinGroup);

        Button split=(Button) findViewById(R.id.btn2);
        split.setOnClickListener(new View.OnClickListener() {
            final TextView result=(TextView) findViewById(R.id.txtResult);
            @Override
            public void onClick(View v) {

                noOfPeople=Integer.parseInt(group.getText().toString());
                billTotal=Double.parseDouble(bill.getText().toString());
                tip=Double.parseDouble(tipamt.getText().toString());
                finalBill=(billTotal+tip)/noOfPeople;
                DecimalFormat currency=new DecimalFormat("Rs###,###.00");
                groupChoice=spinner.getSelectedItem().toString();
                result.setText("Bill total: "+currency.format(billTotal)+"\nTip amount: "+currency.format(tip)+"\nIndividual share: "+currency.format(finalBill));
            }
        });



    }//end oncreate
}//end screen2