package kr.co.fastcampus.eatgo.domain;

import org.springframework.http.HttpHeaders;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private final String name;  //field name
    private final String address;
    private final Long id;
    private List<MenuItem> menuItems =new ArrayList<MenuItem>();

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

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        for(MenuItem menuItem : menuItems) {
            addMenuItem(menuItem);
        }
    }
}
