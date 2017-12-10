package com.practica.upc.pc2;

import android.content.ContentValues;

/**
 * Created by alberto.paico on 10/12/2017.
 */

public class JobModal {
    private String titleJob;
    private String descriptionJob;
    private int totalHour;
    private int idJob;
    private String pendingHour;
    private String status;
    private String date;

    public JobModal() {}

    public JobModal(String titleJob, String descriptionJob, int totalHour,int idJob, String pendingHour,String status,String date) {
        this.titleJob = titleJob;
        this.descriptionJob = descriptionJob;
        this.totalHour = totalHour;
        this.pendingHour = pendingHour;
        this.idJob = idJob;
        this.status = status;
        this.date = date;
    }

    public String getTitleJob() {
        return titleJob;
    }

    public void setTitleJob(String titleJob) {
        this.titleJob = titleJob;
    }

    public String getDescriptionJob() {
        return descriptionJob;
    }

    public void setDescriptionJob(String descriptionJob) {
        this.descriptionJob = descriptionJob;
    }

    public int getTotalHour() {
        return totalHour;
    }

    public void setTotalHour(int totalHour) {
        this.totalHour = totalHour;
    }

    public String getPendingHour() {
        return pendingHour;
    }

    public void setPendingHour(String pendingHour) {
        this.pendingHour = pendingHour;
    }

    public int getIdJob() {
        return idJob;
    }

    public void setIdJob(int idJob) {
        this.idJob = idJob;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ContentValues toContentValues(){
        ContentValues values = new ContentValues();
        //values.put(TablesPC2.JobEntry.ID_JOB,this.getIdJob());
        values.put(TablesPC2.JobEntry.TITLE,this.getTitleJob());
        values.put(TablesPC2.JobEntry.DESCRIPTION,this.getDescriptionJob());
        values.put(TablesPC2.JobEntry.DATE,this.getDate());
        values.put(TablesPC2.JobEntry.STATUS,this.getStatus());
        values.put(TablesPC2.JobEntry.PENDING_HOURS,this.getPendingHour());
        return values;
    }
}
