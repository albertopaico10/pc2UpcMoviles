package com.practica.upc.pc2;

import android.provider.BaseColumns;

/**
 * Created by alberto.paico on 10/12/2017.
 */

public class TablesPC2 {
    public static abstract class JobEntry implements BaseColumns{
        public static final String TABLE_NAME = "Job";

        public static final String TITLE = "title";
        public static final String DESCRIPTION = "description";
        public static final String ID_JOB = "id";
        public static final String PENDING_HOURS = "pendingHour";
        public static final String STATUS = "status";
        public static final String DATE = "date";

    }
}
