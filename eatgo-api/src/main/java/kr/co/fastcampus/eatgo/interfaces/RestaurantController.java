package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.domain.Restaurant;
import kr.co.fastcampus.eatgo.domain.RestaurantRepository;
import org.apache.catalina.util.ErrorPageSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController     //사실 이것도 Conponent의 일종  RestaurantController의 인스턴스를 만들어 준 적이 없지만 Spring이 관리했기 떄문에 정상적으로 작동함
public class RestaurantController {
/*
    //의존성주입 하기 전
    private RestaurantRepository repository = new RestaurantRepository();
*/
    @Autowired      //의존성주입 Contoller를 만들어 줄 때 Spring이 알아서 RestaurantRepository를 만들어 넣어줌
    private RestaurantRepository repository;

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
