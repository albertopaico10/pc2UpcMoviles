package com.practica.upc.pc2;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by alberto.paico on 10/12/2017.
 */

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.ViewHolder> {
    private List<JobModal> jobList;

    public JobAdapter(List<JobModal> jobList) {
        this.jobList = jobList;
    }

    @Override
    public JobAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.job_list_row,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(JobAdapter.ViewHolder holder, int position) {
        final JobModal jobModal = jobList.get(position);
        holder.title.setText(jobModal.getTitleJob());
        holder.description.setText(jobModal.getDescriptionJob());
        holder.workedHour.setText(jobModal.getPendingHour());
        holder.sourceConstraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listHour = new Intent(view.getContext(), InsertHourActivity.class);
                listHour.putExtra("txtTitle",jobModal.getTitleJob());
                listHour.putExtra("txtDescription",jobModal.getDescriptionJob());
                listHour.putExtra("date",jobModal.getDate());
                listHour.putExtra("idJob",String.valueOf(jobModal.getIdJob()));
                listHour.putExtra("totalHours",String.valueOf(jobModal.getPendingHour()));
                view.getContext().startActivity(listHour);
            }
        });
    }

    @Override
    public int getItemCount() {
        return jobList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,description,workedHour;
        ConstraintLayout sourceConstraintLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            sourceConstraintLayout = (ConstraintLayout)itemView.findViewById(R.id.sourceConstraintLayout);
            title = (TextView) itemView.findViewById(R.id.id_title);
            description = (TextView) itemView.findViewById(R.id.id_description);
            workedHour = (TextView) itemView.findViewById(R.id.id_worked_hour);
        }
    }
}
