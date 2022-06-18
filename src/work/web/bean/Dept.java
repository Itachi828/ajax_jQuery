package work.web.bean;

/**
 * @Author: Itachi
 * @Date: 2022/6/6 12:57
 * @Version: jdk1.8
 * @Description: 部门表
 */
public class Dept {
    private String deptno;
    private String dname;
    private String loc;

    public Dept(String deptno, String dname) {
        this.deptno = deptno;
        this.dname = dname;
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Dept(String deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }

    public Dept() {
    }
}
