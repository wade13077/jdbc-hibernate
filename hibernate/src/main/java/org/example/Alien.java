package org.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Alien {

    @Id
    private int aid;
    private String aname;
    private String tech;

    // OneToOne
    // @OneToOne
    // private Laptop laptop;
    //
    // public Laptop getLaptop() {
    //     return laptop;
    // }
    //
    // public void setLaptop(Laptop laptop) {
    //     this.laptop = laptop;
    // }
    // ------------------------------------

    // OneToMany and ManyToOne   &&  Manytomany Mapping
    // @OneToMany // 會多建一個【 alien_laptop 】的表
    // @OneToMany(mappedBy = "alien")  //不會多建
    @ManyToMany
    private List<Laptop> laptops;

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptop) {
        this.laptops = laptop;
    }

    // ------------------------------------


    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }


    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", tech='" + tech + '\'' +

                '}';
    }
}
