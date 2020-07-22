package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.domain.RestaurantRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)    //spring을 이용해서 Test를 실행할 수 있게 함
@WebMvcTest(RestaurantController.class)   //특정 Controller(지금은 RestaurantController)를 Test할 거라는 것을 명시
public class RestaurantControllerTest {
    @Autowired    //직접 만들지 않아도 Spirng에서 알아서 만들어 줄 수 있도록 처리
    private MockMvc mvc;    //field생성

    //TEST를 하기 위해 Controller에 직접 의존성을 주입해야한다
    @SpyBean    //Controller에 원하는 객체 주입가능   /없을 때는 EatgoApplication은 에러없이 실행됐지만 TEST는 에러발생했음
    private RestaurantRepository restaurantRepository;  //이렇게 의존성 주입을 해주면 사용할 객체를 다양하게 변경할 수 있다는 것이 도움이 된다

    @Test
    public void list() throws Exception {
        mvc.perform(get("/restaurants"))  //get("/restaurant") : 누구에게 요청할건지 처리 > @RunWith
                .andExpect(status().isOk()) //요청을 하면 성공적인 결과가 나와야함
                .andExpect(content().string(
                        containsString("\"id\":1004")
                ))
                .andExpect(content().string(
                        containsString("\"name\":\"Bob zip\"")
                ));
        //
    }

    @Test
    public void detail() throws Exception {
        mvc.perform(get("/restaurants/1004"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"id\":1004")
                ))
                .andExpect(content().string(
                        containsString("\"name\":\"Bob zip\"")
                ));
        mvc.perform(get("/restaurants/2020"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"id\":2020")
                ))
                .andExpect(content().string(
                        containsString("\"name\":\"Cyber Food\"")
                ));
    }
}