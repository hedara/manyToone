package com.samples.many2one.models;

import javax.persistence.*;

/**
 * Created by edara on 9/8/16.
 */
@Entity
@Table(name = "CarModel")
public class CarModel {
    @Id
    @Column(name = "model_name")
    private String modelName;
    @Column(name="price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "car_company")
    private CarCompany company;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof CarModel){
            CarModel model = (CarModel) obj;
            if(model.modelName.equalsIgnoreCase(this.modelName)){
                return true;
            }
        }
        return false;
    }

    public CarCompany getCompany() {
        return company;
    }

    public void setCompany(CarCompany company) {
        this.company = company;
    }
}
