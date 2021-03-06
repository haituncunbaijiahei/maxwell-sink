package com.cimc.maxwell.sink.row;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * Created by 00013708 on 2017/8/11.
 */
public class ExportRowMap {

	private String database;

	private String table;

	private String type;

	private String pk;

	private Date time;

	private Map<String, Object> data;

	private Map<String, Object> old;

	public ExportRowMap() {
	}

	public ExportRowMap(RowMapPK rowMapPK, RowMap rowMap) {
		this.database = rowMap.getDatabase();
		this.table = rowMap.getTable();
		this.type = rowMap.getType();
		this.pk = rowMapPK == null ? null : rowMapPK.getPkVal();
		this.time = new Date();

		Map<String, Object> dataMap = rowMap.getData();
		this.data = new HashMap<>(dataMap);
		this.old = new HashMap<>(dataMap);
		if (type.equalsIgnoreCase("update")) {
			this.old.putAll(rowMap.getOld());
		}
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public Map<String, Object> getOld() {
		return old;
	}

	public void setOld(Map<String, Object> old) {
		this.old = old;
	}

	@Override
	public String toString() {
		return JSONObject.toJSONString(this, SerializerFeature.WriteMapNullValue);
	}
}
