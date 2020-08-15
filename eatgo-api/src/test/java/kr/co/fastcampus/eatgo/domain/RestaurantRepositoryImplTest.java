package kr.co.fastcampus.eatgo.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RestaurantRepositoryImplTest {
    //Spring Data JPI를 쓰면 없앨 예정
    @Test
    public void save() {
        RestaurantRepository repository = new RestaurantRepositoryImpl();

        int oldCount = repository.findAll().size();

        Restaurant restaurant = new Restaurant("Seol", "Hanam");
        repository.save(restaurant);

        assertThat(restaurant.getId(), is(1234L));

        int newCount = repository.findAll().size();

        assertThat(newCount - oldCount, is(1));
    }
}