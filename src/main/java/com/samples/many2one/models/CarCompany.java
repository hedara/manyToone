package com.samples.many2one.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by edara on 9/8/16.
 */
@Entity
@Table(name = "CarCompany")
public class CarCompany {
    @Id
    @Column(name = "company_name")
    private String companyName;
    @Column(name="founder_name")
    private String founderName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getFounderName() {
        return founderName;
    }

    public void setFounderName(String founderName) {
        this.founderName = founderName;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof CarCompany) {
            CarCompany comp = (CarCompany) obj;
            if(comp.companyName.equalsIgnoreCase(this.companyName))
                return true;
        }
        return false;
    }
}
