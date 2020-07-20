package kr.co.fastcampus.eatgo.domain;

import java.util.ArrayList;
import java.util.List;

public class RestaurantRepository {
//두번째 중복제거 (공통코드 밖으로 빼기)
    private List<Restaurant> restaurants = new ArrayList<>();
//같이 쓰이는 것이 좋기 때문에 생성자로 만든다
    public RestaurantRepository(){
        restaurants.add(new Restaurant(1004L, "Bob zip", "Seoul"));
        restaurants.add(new Restaurant(2020L, "Cyber Food", "Seoul"));
    }

    public List<Restaurant> findAll() {
/*//첫번때 중복제거
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1004L, "Bob zip", "Seoul"));
        restaurants.add(new Restaurant(2020L, "Cyber Food", "Seoul"));
*/
        return restaurants;
    }

    public Restaurant findById(Long id) {
        //필드에 있는 것을 쓰기 때문에 변형
        //Restaurant restaurant = restaurants.stream()
        return restaurants.stream()
                .filter( r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
