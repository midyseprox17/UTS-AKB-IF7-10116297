/*Dibuat pada : 22 Mei 2019
BIM : 10116297
Nama : Muhammad Ilham Siddiqqulhakim*/

package com.siddiqqulhakim.uts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DetailTemanActivity extends AppCompatActivity {
    Model data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_teman);

        Model data = (Model)getIntent().getSerializableExtra("data");
        TextView txtNim = (TextView)findViewById(R.id.txtNim);
        TextView txtNama = (TextView)findViewById(R.id.txtNama);
        TextView txtKelas = (TextView)findViewById(R.id.txtKelas);
        TextView txtTlp = (TextView)findViewById(R.id.txtTlp);
        TextView txtEmail = (TextView)findViewById(R.id.txtEmail);
        TextView txtIg = (TextView)findViewById(R.id.txtIg);

        txtNim.setText(data.getNim());
        txtNama.setText(data.getNama());
        txtKelas.setText(data.getKelas());
        txtTlp.setText(data.getTlp());
        txtEmail.setText(data.getEmail());
        txtIg.setText(data.getSosmed());

    }

    public void hapus(View view){
        TextView txtNim = (TextView)findViewById(R.id.txtNim);
        String nim = txtNim.getText().toString();

//        Toast.makeText(DetailTemanActivity.this, nim, Toast.LENGTH_SHORT).show();
        FriendsActivity friendsActivity = new FriendsActivity();

        ArrayList<Model> listTeman = friendsActivity.getListTeman();

        int i = 0;
        for(Model data : listTeman){
            if(data.getNim() != null && data.getNim().contains(nim)){
                listTeman.remove(i);
            }
            i++;
        }
//
        friendsActivity.setListTeman(listTeman);

        Intent intent = new Intent(this, FriendsActivity.class);
        startActivity(intent);
    }

}
