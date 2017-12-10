package com.practica.upc.pc2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alberto.paico on 6/12/2017.
 */

public class ListJobActivity extends AppCompatActivity {
    private List<JobModal> listJob = new ArrayList<JobModal>();
    TextView txtDateValue;
    private RecyclerView recyclerView;
    private JobAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_job_activity);

        txtDateValue = (TextView)findViewById(R.id.txtDateValue);

        Intent intent = getIntent();
        String date = intent.getStringExtra("date");
        //Toast.makeText(this,date,Toast.LENGTH_LONG).show();
        txtDateValue.setText(date);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        prepareDataJob();

        mAdapter = new JobAdapter(listJob);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
    }

    private void prepareDataJob() {
        PC2BDHelper db = new PC2BDHelper(ListJobActivity.this);
        //--Select
        Log.d("ListJobActivity","Antes del select");
        //List<JobModal> listJobTemp = new ArrayList<JobModal>();
        listJob = db.getAllJobByDate(txtDateValue.getText().toString());
        Log.d("ListJobActivity","Despues del select"+"** Cantidad de registros : "+listJob.size());
        if(listJob.size()==0){
            //Toast.makeText(ListJobActivity.this,"Entreeeee",Toast.LENGTH_SHORT).show();
            Log.d("ListJobActivity","Entre al IF");
            JobModal beanJob = new JobModal("Tarea 1", "Correspondiente al dia " + txtDateValue.getText().toString(), 6,0, "Horas Trabajadas : 0", "Pending", txtDateValue.getText().toString());
            listJob.add(beanJob);
            beanJob = new JobModal("Tarea 2", "Correspondiente al dia " + txtDateValue.getText().toString(), 6,0, "Horas Trabajadas : 0", "Pending", txtDateValue.getText().toString());
            listJob.add(beanJob);
            beanJob = new JobModal("Tarea 3", "Correspondiente al dia " + txtDateValue.getText().toString(), 6,0, "Horas Trabajadas : 0", "Pending", txtDateValue.getText().toString());
            listJob.add(beanJob);
            beanJob = new JobModal("Tarea 4", "Correspondiente al dia " + txtDateValue.getText().toString(), 6,0, "Horas Trabajadas : 0", "Pending", txtDateValue.getText().toString());
            listJob.add(beanJob);
            beanJob = new JobModal("Tarea 5", "Correspondiente al dia " + txtDateValue.getText().toString(), 6,0, "Horas Trabajadas : 0", "Pending", txtDateValue.getText().toString());
            listJob.add(beanJob);

            Log.d("ListJobActivity","Antes de insertar");
            db.doInsertData(listJob);
            Log.d("ListJobActivity","Despues de insertar");
            listJob = db.getAllJobByDate(txtDateValue.getText().toString());
            Log.d("ListJobActivity","Despues del select"+"** Cantidad de registros : "+listJob.size());
        }

        //mAdapter.notifyDataSetChanged();
    }
}
