package work.web.bean;

import java.util.Objects;

/**
 * @Author: Itachi
 * @Date: 2022/6/4 12:37
 * @Version: jdk1.8
 * @Description: 部员类
 */
public class Emp {
    private String empno;
    private String ename;
    private String sal;
    private String job;

    public Emp(String empno, String ename) {
        this.empno = empno;
        this.ename = ename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return Objects.equals(empno, emp.empno) && Objects.equals(ename, emp.ename) && Objects.equals(sal, emp.sal) && Objects.equals(job, emp.job);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empno, ename, sal, job);
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empno='" + empno + '\'' +
                ", ename='" + ename + '\'' +
                ", sal='" + sal + '\'' +
                ", job='" + job + '\'' +
                '}';
    }

    public String getEmpno() {
        return empno;
    }

    public void setEmpno(String empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Emp(String empno, String ename, String sal, String job) {
        this.empno = empno;
        this.ename = ename;
        this.sal = sal;
        this.job = job;
    }

    public Emp() {
    }
}


