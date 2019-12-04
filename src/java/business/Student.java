package business;


import java.io.Serializable;
import java.util.Arrays;

/**
 * @author Tom Valli
 */
public class Student implements Serializable {
    private String sno, lname, fname, lgrade;
    private double q1,q2,q3,q4,q5,qm,mt,pr,fe;
    private double qavg, cavg;
    
    public Student() {
        this.sno = "";
        this.lname = "";
        this.fname = "";
        this.lgrade = "";
        this.q1 = 0;
        this.q2 = 0;
        this.q3 = 0;
        this.q4 = 0;
        this.q5 = 0;
        this.qm = 0;
        this.mt = 0;
        this.pr = 0;
        this.fe = 0;
        this.qavg = 0;
        this.cavg = 0;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLgrade() {
        return lgrade;
    }

    public double getQ1() {
        return q1;
    }

    public void setQ1(double q1) {
        this.q1 = q1;
    }

    public double getQ2() {
        return q2;
    }

    public void setQ2(double q2) {
        this.q2 = q2;
    }

    public double getQ3() {
        return q3;
    }

    public void setQ3(double q3) {
        this.q3 = q3;
    }

    public double getQ4() {
        return q4;
    }

    public void setQ4(double q4) {
        this.q4 = q4;
    }

    public double getQ5() {
        return q5;
    }

    public void setQ5(double q5) {
        this.q5 = q5;
    }

    public double getQm() {
        return qm;
    }

    public void setQm(double qm) {
        this.qm = qm;
    }

    public double getMt() {
        return mt;
    }

    public void setMt(double mt) {
        this.mt = mt;
    }

    public double getPr() {
        return pr;
    }

    public void setPr(double pr) {
        this.pr = pr;
    }

    public double getFe() {
        return fe;
    }

    public void setFe(double fe) {
        this.fe = fe;
    }

    public double getQavg() {
        return this.qavg;
    }

    public double getCavg() {
        return cavg;
    }
    
    @Override
    public String toString() {
        calcGrade();
        return this.sno + "," + this.lname + "," + this.fname + "," +
                this.q1 + "," + this.q2 + "," + this.q3 + "," + this.q4 +
                "," + this.q5 + "," + this.qm + "," + this.qavg + "," + this.mt + "," + 
                this.pr + "," + this.fe + "," + this.cavg + "," + this.lgrade;
    }
    
    public void calcGrade () {
        double[] q = { this.q1, this.q2, this.q3, this.q4, this.q5, this.qm };
        
        Arrays.sort(q); //sorts array q low to high
        this.qavg = (q[2] + q[3] + q[4] + q[5]) / 4.0;
        
        if (this.qavg >= 89.5 && this.mt >= 89.5 && this.pr >= 89.5) { //start of if-else statements to get lgrade
            this.cavg = (qavg + this.mt + this.pr ) / 3;
            this.lgrade = "A";
        } else {
            this.cavg = (qavg * .5) + (this.mt * .15) + (this.pr * .1) + (this.fe * .25);
            if (this.cavg >= 89.5) {
                this.lgrade = "A";
            } else if (this.cavg >= 79.5) {
                this.lgrade = "B";
            } else if (this.cavg >= 69.5) {
                this.lgrade = "C";
            } else if (this.cavg >= 59.5) {
                this.lgrade = "D";
            } else {
                this.lgrade = "F";
            }
        }        
    } 
}
