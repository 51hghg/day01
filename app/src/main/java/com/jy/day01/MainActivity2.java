package com.jy.day01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    private CheckBox plain_cb;
    private CheckBox bold_cb;
    private CheckBox serif_cb;
    private CheckBox italic_cb;
    private Button get_view_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        plain_cb = (CheckBox) findViewById(R.id.plain_cb);
        bold_cb = (CheckBox) findViewById(R.id.bold_cb);
        serif_cb = (CheckBox) findViewById(R.id.serif_cb);
        italic_cb = (CheckBox) findViewById(R.id.italic_cb);
        get_view_button = (Button) findViewById(R.id.get_view_button);

        get_view_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.get_view_button:
                String r = "";
                if (plain_cb.isChecked()) {
                    r = r + "," + plain_cb.getText();
                }
                if (serif_cb.isChecked()) {
                    r = r + "," + serif_cb.getText();
                }
                if (bold_cb.isChecked()) {
                    r = r + "," + bold_cb.getText();
                }
                if (italic_cb.isChecked()) {
                    r = r + "," + italic_cb.getText();
                }
                setTitle("Checked: " + r);
                Toast.makeText(this, "Checked:" + r, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}