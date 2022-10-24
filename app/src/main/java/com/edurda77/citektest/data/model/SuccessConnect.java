package com.edurda77.citektest.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity(tableName = "table_connect")
public class SuccessConnect implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(defaultValue = "count")
    private Integer countConnect;

    public Integer getCountConnect() {
        return countConnect;
    }
}
