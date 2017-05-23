package com.example.pierre_antoine.diabete;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int MYSECONDACTIVITY_REQUESTCODE = 1;

    private EditText edGlycemie;
    private RadioButton rdop1;
    private RadioButton rdop2;
    private Button btnAfficher;
    private TextView txtInsuline;
    private EditText edNom;
    private EditText edPrenom;
    private Button btnAjouter;
    private Button btnMalade;
    private RelativeLayout lVisible;
    MaladesBDD mbdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edGlycemie=(EditText)findViewById(R.id.edGlycemie);
        edNom=(EditText)findViewById(R.id.edNom);
        edPrenom=(EditText)findViewById(R.id.edPrenom);
        btnAfficher=(Button) findViewById(R.id.btnAfficher);
        btnAjouter=(Button) findViewById(R.id.btnAjouter);
        btnMalade=(Button) findViewById(R.id.btnMalade);
        txtInsuline=(TextView) findViewById(R.id.txtInsuline);
        rdop1=(RadioButton) findViewById(R.id.rdop1);
        rdop2=(RadioButton) findViewById(R.id.rdop2);
        lVisible=(RelativeLayout)findViewById(R.id.lVisible);

        btnAfficher.setOnClickListener(clickListenerbtnAfficher);
        btnAjouter.setOnClickListener(clickListenerbtnAjouter);
        btnMalade.setOnClickListener(clickListenerbtnMalade);


        mbdd=new MaladesBDD(this);
        mbdd.open();

    }

    private View.OnClickListener clickListenerbtnAfficher=new View.OnClickListener(){
        public void onClick (View arg0){
            MapProtocoles m=new MapProtocoles();

            // Protocole p=new Protocole()
            if (edGlycemie.getText().toString().isEmpty()){
                Toast.makeText(MainActivity.this,"Vous n'avez pas saisie votre Glycémie!", Toast.LENGTH_LONG).show();
            }
            else {

                if (rdop1.isChecked()){
                    m.initialiser();
                    Protocole p=m.getProtocole(1);
                    double gly= Double.parseDouble(edGlycemie.getText().toString());
                    int rep=p.insuline(gly);
                    txtInsuline.setText(String.valueOf(rep));
                }
                else if (rdop2.isChecked())
                {
                    m.initialiser();
                    Protocole p=m.getProtocole(2);
                    double gly= Double.parseDouble(edGlycemie.getText().toString());
                    int rep=p.insuline(gly);
                    txtInsuline.setText(String.valueOf(rep));
                }
                else
                    Toast.makeText(MainActivity.this,"Vous n'avez pas saisie votre protocole!", Toast.LENGTH_LONG).show();

                if (Double.parseDouble(edGlycemie.getText().toString())>=2 && (rdop1.isChecked()|| rdop2.isChecked())){
                    lVisible.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"Le malade doit être ajouté aux malades à signaler", Toast.LENGTH_LONG).show();
                }
                else
                    lVisible.setVisibility(View.INVISIBLE);

            }
        }
    };

    private View.OnClickListener clickListenerbtnAjouter=new View.OnClickListener(){
        public void onClick (View arg0){
            if (edNom.getText().toString().isEmpty()){
                Toast.makeText(MainActivity.this,"Nom manquant",Toast.LENGTH_LONG).show();
            }
            else if (edPrenom.getText().toString().isEmpty()){
                Toast.makeText(MainActivity.this,"Prenom manquant",Toast.LENGTH_LONG).show();
            }
            else  {
                Malade m =new Malade(edNom.getText().toString(),edPrenom.getText().toString(),Double.parseDouble(edGlycemie.getText().toString()));
                mbdd.ajoutMalade(m);
                Toast.makeText(MainActivity.this,"ajout effectué",Toast.LENGTH_LONG).show();
            }
        }

    };

    protected void onDestroy(){
        super.onDestroy();
        mbdd.close();
    }

    private View.OnClickListener clickListenerbtnMalade=new View.OnClickListener() {
        public void onClick(View arg0) {
            ArrayList<Malade> lstMalade;
            lstMalade = mbdd.getTousLesMalades();
            Intent it = new Intent(MainActivity.this, Main2Activity.class);
            it.putExtra("message", lstMalade);
            startActivity(it);
        }
    };
}
