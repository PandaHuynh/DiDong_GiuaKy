package com.example.thuanhuynh.ktgiuaky;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by thuanhuynh on 4/3/18.
 */

public class ThemMoiActivity extends AppCompatActivity{
    EditText edtNoiDung,edtSoTien;
    RadioButton radioThu,radioChi;
    Button btnThem,btnNhapLai,btnHienThi;
    HocVienDataSource hocVienDataSource;
    int mahinh = 0;
    String dk="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_moi);
        hocVienDataSource = new HocVienDataSource(ThemMoiActivity.this);

        edtNoiDung = (EditText) findViewById(R.id.edtNoiDung);
        edtSoTien = (EditText) findViewById(R.id.edtSoTien);
        radioChi = (RadioButton) findViewById(R.id.radioChi);
        radioThu = (RadioButton) findViewById(R.id.radioThu);

        btnHienThi = (Button) findViewById(R.id.btnHienThi);
        btnThem = (Button) findViewById(R.id.btnThem);
        btnNhapLai = (Button) findViewById(R.id.btnNhapLai);
        btnNhapLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtNoiDung.setText("");
                edtSoTien.setText("");
                edtNoiDung.requestFocus();
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(radioThu.isChecked()==true&&radioChi.isChecked()==false){
                    mahinh = 1;
                }else if (radioThu.isChecked()==false&&radioChi.isChecked()==true){
                    mahinh = 0;
                }


                hocVienDataSource.ThemHocVien(new HocVien(edtNoiDung.getText().toString(),edtSoTien.getText().toString(),mahinh));
                Toast.makeText(ThemMoiActivity.this,"Đã thêm thành công",Toast.LENGTH_LONG).show();
            }
        });

        btnHienThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThemMoiActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
