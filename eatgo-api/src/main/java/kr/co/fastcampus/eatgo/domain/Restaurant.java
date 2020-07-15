package kr.co.fastcampus.eatgo.domain;

public class Restaurant {

    private final String name;  //field name
    private final String address;
    private final Long id;

    public Restaurant(Long id, String name, String address) {
        this.id = id;
        this.name = name;   //맴버변수
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getInformation() {
        return name + " in " + address;
    }

    public String getAddress() {
        return address;
    }
}
