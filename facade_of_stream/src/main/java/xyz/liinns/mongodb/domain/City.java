package xyz.liinns.mongodb.domain;

import org.springframework.data.annotation.Id;

/**
 * Description:
 * Created by LiinNs on 2017-7-28 0028.
 */
public class City {

    @Id
    private String id;

    private String name;

    private String zipCode;

    public City() {

    }

    public City(String name, String zipCode) {
        this.name = name;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
