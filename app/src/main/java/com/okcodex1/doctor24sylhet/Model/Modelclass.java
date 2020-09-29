package com.okcodex1.doctor24sylhet.Model;

import java.io.Serializable;

public class Modelclass  implements Serializable {
    String name, qualification, worksat, chamber, visitingtime, offday, mobilenumber;
    int image;

    public Modelclass() {
    }

    public Modelclass(String name, String qualification, String worksat, String chamber, String visitingtime, String offday, String mobilenumber, int image) {
        this.name = name;
        this.qualification = qualification;
        this.worksat = worksat;
        this.chamber = chamber;
        this.visitingtime = visitingtime;
        this.offday = offday;
        this.mobilenumber = mobilenumber;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getQualification() {
        return qualification;
    }

    public String getWorksat() {
        return worksat;
    }

    public String getChamber() {
        return chamber;
    }

    public String getVisitingtime() {
        return visitingtime;
    }

    public String getOffday() {
        return offday;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public int getImage() {
        return image;
    }
}
