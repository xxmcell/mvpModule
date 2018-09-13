package com.example.administrator.mvpwithretrofit.beans;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2018/9/13/013.
 */
@Entity
public class TestGreenDaoBean {

    @Id(autoincrement = true)
    private Long id;
    @Unique
    private String Name;
    @Property(nameInDb = "price")
    private Long Price;

    private String Image_Url;

    private String type;

    @Generated(hash = 1570154702)
    public TestGreenDaoBean(Long id, String Name, Long Price, String Image_Url,
            String type) {
        this.id = id;
        this.Name = Name;
        this.Price = Price;
        this.Image_Url = Image_Url;
        this.type = type;
    }

    @Generated(hash = 2074694533)
    public TestGreenDaoBean() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Long getPrice() {
        return this.Price;
    }

    public void setPrice(Long Price) {
        this.Price = Price;
    }

    public String getImage_Url() {
        return this.Image_Url;
    }

    public void setImage_Url(String Image_Url) {
        this.Image_Url = Image_Url;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
