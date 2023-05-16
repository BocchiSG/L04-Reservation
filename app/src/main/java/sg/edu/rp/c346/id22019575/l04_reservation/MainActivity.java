package sg.edu.rp.c346.id22019575.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnConfirm, btnReset;
    TextView tvName, tvMobile, tvSize, tvTime, tvDate, tvSmoke;
    EditText etName, etMobile, etSize;
    RadioGroup rgSmoke;
    DatePicker dp, setDate;
    TimePicker tp, setTime;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConfirm = findViewById(R.id.confirm);
        etName = findViewById(R.id.name);
        etMobile = findViewById(R.id.mobileNumber);
        etSize = findViewById(R.id.size);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        rgSmoke = findViewById(R.id.smoke);
        btnReset = findViewById(R.id.reset);
        tvName = findViewById(R.id.Name);
        tvMobile = findViewById(R.id.Mobile);
        tvSize = findViewById(R.id.Size);
        tvDate = findViewById(R.id.Date);
        tvTime = findViewById(R.id.Time);
        tvSmoke = findViewById(R.id.Smoke);

        btnConfirm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                String Name = etName.getText().toString();
                int Mobile = Integer.parseInt(etMobile.getText().toString());
                int Size = Integer.parseInt(etSize.getText().toString());
                int Hour = tp.getCurrentHour();
                int Minute = tp.getCurrentMinute();
                int Day = dp.getDayOfMonth();
                int Month = dp.getMonth()+1;
                int Year = dp.getYear();
                int checkedRadioId = rgSmoke.getCheckedRadioButtonId();

                String Smoke;
                if (checkedRadioId == R.id.radioButton){
                    Smoke = "Non-Smoking Area";
                }else  {
                    Smoke = "Smoking Area";
                }

                tvName.setText("Name: "+Name);
                tvMobile.setText("Mobile Number: "+Mobile);
                tvSize.setText("Size of Group: "+Size);
                tvTime.setText("Time: "+Hour+":"+Minute);
                tvDate.setText("Date: "+Day+"/"+Month+"/"+Year);
                tvSmoke.setText("Smoke: "+Smoke);

                Toast.makeText(MainActivity.this, "Name:"+Name+", Mobile Number: "+Mobile+", Size of Group: "+Size+", Time: "+Hour+":"+Minute+", Date: "+Day+"/"+Month+"/"+Year+", Smoke: "+Smoke, Toast.LENGTH_SHORT).show();



            }
        });
        btnReset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                etName.setText("");
                etSize.setText("");
                etMobile.setText("");
                rgSmoke.clearCheck();
                int hour = 19;
                setTime.setCurrentHour(hour);
                int minute = 30;
                setTime.setCurrentMinute(minute);
                int month = 6;
                int day = 1;
                int year = 2020;
                setDate.updateDate(year, month, day);
                tvName.setText("Name: ");
                tvMobile.setText("Mobile Number: ");
                tvSize.setText("Size of Group: ");
                tvTime.setText("Time: ");
                tvDate.setText("Date: ");
                tvSmoke.setText("Smoke: ");





            }
        });
    }
}