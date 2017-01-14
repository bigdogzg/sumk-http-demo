package com.test.pojo;

import java.util.Date;

import org.yx.db.annotation.Column;
import org.yx.db.annotation.ColumnType;
import org.yx.db.annotation.SoftDelete;
import org.yx.db.annotation.Table;
import org.yx.util.DateUtils;

@Table
@SoftDelete(value = "enable", columnType = Byte.class)
public class DemoUser {

	@Column(columnType = ColumnType.ID_DB)
	private Long id;
	private String name;
	private Integer age;
	private Date lastUpdate;

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "DemoUser [id=" + id + ", name=" + name + ", age=" + age + ", lastUpdate="
				+ DateUtils.toDateTimeString(lastUpdate) + "]";
	}

}
