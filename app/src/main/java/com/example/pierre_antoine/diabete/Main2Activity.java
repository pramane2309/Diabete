package com.example.pierre_antoine.diabete;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static android.R.id.message;

public class Main2Activity extends AppCompatActivity {

    private ListView listView;
    private Button btnRetour;
    MaladesBDD mbdd;

    private EditText txtNumero;
    private Button btnEnvoiMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView= (ListView) findViewById(R.id.listView);
        btnRetour = (Button) findViewById(R.id.btnRetour);

        ArrayList<Malade> lstMalade = (ArrayList<Malade>) getIntent().getSerializableExtra("message");
        ArrayAdapter<Malade> adapter = new ArrayAdapter<Malade>(Main2Activity.this,android.R.layout.simple_list_item_1,lstMalade);
        listView.setAdapter(adapter);

        //ouverture de la base
        mbdd=new MaladesBDD(this);
        mbdd.open();

        txtNumero=(EditText)findViewById(R.id.txtNumero);
        btnEnvoiMessage=(Button)findViewById(R.id.btnEnvoieMessage);


        btnRetour.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                Main2Activity.this.finish();
            }
        });

        btnEnvoiMessage.setOnClickListener(clickListenerBtnEnvoiMessage);
    }

    protected void onDestroy(){
        super.onDestroy();
        mbdd.close();
    }

    private View.OnClickListener clickListenerBtnEnvoiMessage = new View.OnClickListener(){
        public void onClick (View v){
            String message = "nom -- prenom -- insuline" ;
            for (Malade a: mbdd.getTousLesMalades())
            {
                 message += a.toString();
            }
            Intent i = new Intent(Intent.ACTION_SEND);
             i.putExtra(Intent.EXTRA_TEXT, message);
            i.setType("text/plain");
            startActivity(Intent.createChooser(i,"Envoyer un message"));

        }
    };
}