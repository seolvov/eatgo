package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.domain.Restaurant;
import kr.co.fastcampus.eatgo.domain.RestaurantRepository;
import org.apache.catalina.util.ErrorPageSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurantController {

    private RestaurantRepository repository = new RestaurantRepository();

    @GetMapping("/restaurants")
    public List<Restaurant> list(){
        List<Restaurant> restaurants = repository.findAll();
        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id){
/*//첫번째 방법
        Restaurant restaurant = null;
        if(id == 1004L) {
            restaurant = new Restaurant(1004L, "Bob zip", "Seoul");
        }
        if(id == 2020L) {
            restaurant = new Restaurant(2020L, "Cyber Food", "Seoul");
        }
        return restaurant;
*/
/*//두번째 방법
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1004L, "Bob zip", "Seoul"));
        restaurants.add(new Restaurant(2020L, "Cyber Food", "Seoul"));
*/
/*
//세번째 방법
        List<Restaurant> restaurants = repository.findAll();
*/

//네번째 방법
        Restaurant restaurant = repository.findById(id);

/*//원래 이런 기능을 Controller에서 하는 것이 아님
        Restaurant restaurant = restaurants.stream()
                .filter( r -> r.getId().equals(id))
                .findFirst()
                //.get();
                .orElse(null);  //찾을 수 없는 경우 null로 해결
*/

        return restaurant;
    }
}
