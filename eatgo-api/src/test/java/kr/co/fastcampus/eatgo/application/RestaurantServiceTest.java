package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.Restaurant;
import kr.co.fastcampus.eatgo.domain.RestaurantRepository;
import kr.co.fastcampus.eatgo.domain.RestaurantRepositoryImpl;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RestaurantServiceTest {

    private RestaurantService restaurantService;
    RestaurantRepository restaurantRepository;

    @Before //@Test 만 하면 Spring의 의존성주입이 안되므로 강제로 주입 / @Before는 모든 @Test가 실행되기 전에 반드시 실행
    public void setUp(){
        restaurantRepository = new RestaurantRepositoryImpl();
        restaurantService = new RestaurantService(restaurantRepository);
    }

    @Test
    public void getRestaurant(){
        Restaurant restaurant = restaurantService.getRestaurant(1004L);

        assertThat(restaurant.getId(), is(1004L));
    }

}