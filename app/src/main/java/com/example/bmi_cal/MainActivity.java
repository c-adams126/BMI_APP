package com.example.bmi_cal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void outputweight(View v){
        // TextView var
        TextView weight = findViewById(R.id.weight);
        TextView height = findViewById(R.id.feet);
        TextView inches = findViewById(R.id.inches);
        TextView output = findViewById(R.id.output);
        TextView sug = findViewById(R.id.suggest);

        // String conversion
        String error = "Please input right number";
        String Sw = weight.getText().toString();
        String Sh = height.getText().toString();
        String Si = inches.getText().toString();
        TextView e = findViewById(R.id.error);
        if (Sw.equals("") || Sh.equals("") || Si.equals("")){
            e.setText(error);
        }else{
            try {
                double dw = Double.parseDouble(Sw);
                int f = Integer.parseInt(Sh);
                int i = Integer.parseInt(Si);
                double total = bmiCal(f, i, dw);
                String Stotal = String.format("%.1f", total);
                output.setText(String.valueOf(Stotal));
                if (total < 18.5){
                    sug.setText("your bmi is less then the suggested weight");
                }else if (total >= 18.5 && total <= 24.9){
                    sug.setText("your bmi is suggested as normal");
                }else if(total > 24.9 ){
                    sug.setText("your bmi is above average");
                }
                Button cl = findViewById(R.id.reset);
                cl.setEnabled(true);


            }catch (Exception ee){
                    e.setText("you got to the catch");
            }
        }


    }
    public void clearwords(View v){
        TextView weight = findViewById(R.id.weight);
        TextView feet = findViewById(R.id.feet);
        TextView inches = findViewById(R.id.inches);
        TextView output = findViewById(R.id.output);
        TextView sug = findViewById(R.id.suggest);
        TextView error = findViewById(R.id.error);

        weight.setText("");
        feet.setText("");
        inches.setText("");
        output.setText("");
        sug.setText("");
        error.setText("");
        v.setEnabled(false);
    }

    public double bmiCal(int feet, int inches, double pounds){
        int feetToInches = (feet*12)+inches;
        int timeItsSelf = feetToInches*feetToInches;
        double weight = pounds*703;
        double total = weight/timeItsSelf;
        return total;
    }
}