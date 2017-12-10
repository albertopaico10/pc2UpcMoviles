package com.practica.upc.pc2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by alberto.paico on 10/12/2017.
 */

public class InsertHourActivity extends AppCompatActivity {

    Button btnSave;
    TextView txtTitle;
    TextView txtDescription;
    TextView txtDate;
    EditText etNumberHours;

    int id,totalHours,newHours;
    String pendingHours;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_hour_worked_activity);
        btnSave = (Button) findViewById(R.id.btn_save);

        txtTitle = (TextView)findViewById(R.id.id_title_worked);
        txtDescription = (TextView)findViewById(R.id.id_description_worked);
        txtDate = (TextView)findViewById(R.id.id_date_worked);
        etNumberHours = (EditText) findViewById(R.id.id_hours);

        Intent intent = getIntent();
        txtTitle.setText(intent.getStringExtra("txtTitle"));
        txtDescription.setText(intent.getStringExtra("txtDescription"));
        txtDate.setText(intent.getStringExtra("date"));
        Log.d("InsertHourActivity","Valor que viene : "+intent.getStringExtra("totalHours"));
        pendingHours = intent.getStringExtra("totalHours").replace("Horas Trabajadas : ","");
        Log.d("InsertHourActivity","Total de Horas para este dia : "+pendingHours);
        totalHours = Integer.parseInt(pendingHours.trim());
        Log.d("InsertHourActivity","Valor del ID : "+intent.getStringExtra("idJob"));
        id = Integer.parseInt(intent.getStringExtra("idJob"));
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newHours = totalHours+Integer.parseInt(etNumberHours.getText().toString());
                if(newHours<24){
                    Intent insertHour = new Intent(InsertHourActivity.this, MainActivity.class);
                    PC2BDHelper db= new PC2BDHelper(InsertHourActivity.this);
                    Log.d("InsertHourActivity","Antes del metodo de actualizar");
                    db.doUpdateJob(id,String.valueOf(newHours));
                    Log.d("InsertHourActivity","Despues del metodo de actualizar");
                    startActivity(insertHour);
                }
                else{
                    Toast.makeText(InsertHourActivity.this,"Ud. ya tiene "+totalHours+" horas ingresadas. No se puede sobrepasar las 24 Horas en una tarea",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
