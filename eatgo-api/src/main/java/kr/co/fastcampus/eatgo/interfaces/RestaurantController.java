package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.domain.MenuItem;
import kr.co.fastcampus.eatgo.domain.MenuItemRepository;
import kr.co.fastcampus.eatgo.domain.Restaurant;
import kr.co.fastcampus.eatgo.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    @GetMapping("/restaurants")
    public List<Restaurant> list(){
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id){
        //Restaurant restaurant = restaurantService.getRestaurantById(id);  //기본정보 + 메뉴정보 두 정보를 한꺼번에 보여주는 새로운 기능이 필요 => 이때 쓰이는 것이 restaurantService

        Restaurant restaurant = restaurantRepository.findById(id);  //기존의 repository는 일종의 컬랙션과 같은 역할을 했다
                                                                    //repository의 복잡한 처리가 한꺼번에 일어 나는 새로운 객체, restaurantService
                                                                    //이런 객체가 applicationLayer로 중간에 들어 가는 것

        List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
        restaurant.setMenuItems(menuItems);
        return restaurant;
    }
}
