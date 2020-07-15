package kr.co.fastcampus.eatgo.domain;

//import org.hamcrest.Matcher;
//import org.hamcrest.MatcherAssert;
//import org.junit.jupiter.api.Test;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;
//import static org.junit.jupiter.api.Assertions.*;

public class RestaurantTests {
    @Test
    public void creation() {
        Restaurant restaurant = new Restaurant(1004L,"Bob zip", "Seoul");
        System.out.println(restaurant.getId());
        assertThat(restaurant.getId(), is(1004L));
        assertThat(restaurant.getName(), is("Bob zipㄴㄴㅇ"));
        assertThat(restaurant.getAddress(), is("Seoul"));
    }

    @Test
    public void information(){
        Restaurant restaurant = new Restaurant(1004L, "Bob zip", "Seoul");
        assertThat(restaurant.getInformation(), is("Bob zip in Seoul"));
    }
}