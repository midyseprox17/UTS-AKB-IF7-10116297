/*Dibuat pada : 22 Mei 2019
BIM : 10116297
Nama : Muhammad Ilham Siddiqqulhakim*/

package com.siddiqqulhakim.uts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FriendsActivity extends AppCompatActivity {
    private ArrayList<Model> listTeman;
    Model data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        listTeman = new ArrayList<>();
        inisiasiTeman();

        final ArrayList<String> listNamaTeman = new ArrayList<>();

        for(int i = 0; i < listTeman.size(); i++){
            listNamaTeman.add(listTeman.get(i).getNama());
        }

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, listNamaTeman);

        ListView listView = (ListView)findViewById(R.id.listViewTeman);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nama = listNamaTeman.get(position);
                for(Model data : listTeman){
                    if(data.getNama() != null && data.getNama().contains(nama)){
//                        Toast.makeText(MainActivity.this, data.getNim(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(FriendsActivity.this, DetailTemanActivity.class);
                        intent.putExtra("data", data);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    public void inisiasiTeman(){
        data = new Model();
        data.setNim("10116112");
        data.setNama("Test 2");
        data.setKelas("IF7");
        data.setTlp("002tlp");
        data.setEmail("002@gmail.com");
        data.setSosmed("002sosmed");
        listTeman.add(data);

        data = new Model();
        data.setNim("10116111");
        data.setNama("Test 1");
        data.setKelas("IF7");
        data.setTlp("001tlp");
        data.setEmail("001@gmail.com");
        data.setSosmed("001sosmed");
        listTeman.add(data);
    }

    public ArrayList<Model> getListTeman() {
        return listTeman;
    }

    public void setListTeman(ArrayList<Model> listTeman) {
        this.listTeman = listTeman;
    }
}
