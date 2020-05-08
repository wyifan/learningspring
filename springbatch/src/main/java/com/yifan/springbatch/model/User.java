package com.yifan.springbatch.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "user", schema = "public")
// when using postgresql, you should add this line above
// or you will get error: org.postgresql.util.PSQLException: ERROR: column user0_.id does not exist - Hibernate
public class User {
    @Id
    private Integer id;
    private String name;
    private String dept;
    private Integer salary;
    private Date time;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public User(Integer id, String name, String dept, Integer salary, Date time) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.time = time;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", dept='").append(dept).append('\'');
        sb.append(", salary=").append(salary);
        sb.append('}');
        return sb.toString();
    }
}
