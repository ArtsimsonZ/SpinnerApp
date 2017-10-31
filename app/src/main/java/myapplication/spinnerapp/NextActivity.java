package myapplication.spinnerapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.spinner.R;

public class NextActivity extends ActionBarActivity {
    Button show;
    TextView optiondisp;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        optiondisp=(TextView)findViewById(R.id.spindisplay);
        setTitle("Intent 2");
        show=(Button)findViewById(R.id.show);
        pref=getApplication().getSharedPreferences("Options", MODE_PRIVATE);
        show.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String gen=pref.getString("gender", "");
                String and=pref.getString("android", "");
                optiondisp.setText("Gender:"+gen+"\nAndroid:"+and);
            }
        });
    }
}
