////package com.kang.FloApiServer.web;
////
////import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
////import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
////import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
////
////import java.nio.charset.StandardCharsets;
////import java.util.ArrayList;
////import java.util.List;
////
////import javax.persistence.EntityManager;
////
////import org.junit.jupiter.api.BeforeEach;
////import org.junit.jupiter.api.Test;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
////import org.springframework.boot.test.context.SpringBootTest;
////import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
////import org.springframework.http.MediaType;
////import org.springframework.test.web.servlet.MockMvc;
////import org.springframework.test.web.servlet.ResultActions;
////import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
////import org.springframework.test.web.servlet.setup.MockMvcBuilders;
////import org.springframework.transaction.annotation.Transactional;
////import org.springframework.web.context.WebApplicationContext;
////import org.springframework.web.filter.CharacterEncodingFilter;
////
////import com.fasterxml.jackson.databind.ObjectMapper;
////import com.kang.FloApiServer.domain.playsong.PlaySong;
////import com.kang.FloApiServer.domain.playsong.PlaySongRepository;
////import com.kang.FloApiServer.domain.song.CategoryType;
////import com.kang.FloApiServer.domain.song.Song;
////import com.kang.FloApiServer.domain.song.SongRepository;
////import com.kang.FloApiServer.web.dto.playsong.PlaySongSaveReqDto;
////
////import lombok.extern.slf4j.Slf4j;
////
////@Slf4j
////@Transactional
////@AutoConfigureMockMvc
////@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
////public class FLOApiControllerIntegreTest {
////	
////	@Autowired
////	private MockMvc mockMvc;
////	
////	@Autowired
////	private SongRepository songRepository;
////	
////	@Autowired
////	private PlaySongRepository playSongRepository;
////	
////
////	@Autowired
////	private EntityManager entityManager;
////
////	
////	@BeforeEach // 각각의 단위 테스트 전에 초기화할 함수를 적어준다.
////	private void setup() {
////		//entityManager.createNativeQuery("ALTER TABLE song ALTER COLUMN id RESTART WITH 1 ").executeUpdate();
////		
//////		new Song(1, "있잖아 (ROCK VER.)", "IU (아이유)", CategoryType.DANCE, "lyrics", "2009.04", "IU (아이유) - 있잖아.jpg", "IU (아이유) - 있잖아 (ROCK VER.).mp3");
//////		new Song(2, "마지막처럼", "BLACKPINK", CategoryType.DANCE, "", "2017.06", "BLACKPINK - 마지막처럼.jpg", "BLACKPINK - 마지막처럼.mp3");
//////		new Song(3, "Into the I-LAND", "IU (아이유)", CategoryType.DANCE, "", "2020.06", "IU (아이유) - Into the I-LAND.jpg", "IU (아이유) - Into the I-LAND.mp3");
////
////	}
////
////	
////	@Test
////	public void save_테스트() throws Exception {
////		// given(테스트를 하기 위한 준비)
////		Song song = new Song(1, "있잖아 (ROCK VER.)", "IU (아이유)", CategoryType.DANCE, "lyrics", "2009.04", "IU (아이유) - 있잖아.jpg", "IU (아이유) - 있잖아 (ROCK VER.).mp3");						
////		PlaySongSaveReqDto playSongSaveReqDto = new PlaySongSaveReqDto();
////		playSongSaveReqDto.setSong(song);
////		
////		String content = new ObjectMapper().writeValueAsString(playSongSaveReqDto);
////			
////		//when(테스트 실행)
////		ResultActions resultAction = mockMvc.perform(post("/playSong")
////				.contentType(MediaType.APPLICATION_JSON_UTF8)
////				.content(content)
////				.accept(MediaType.APPLICATION_JSON_UTF8));
////		
////		//then(검증)
////		resultAction
////		.andExpect(jsonPath("$.statusCode").value(1))
////		.andDo(MockMvcResultHandlers.print());
////	}
////	
////	
////	@Test
////	public void findAllTest() throws Exception {
////		
////		List<PlaySong> playSongs = new ArrayList<>();
////		
////		playSongs.add(new PlaySong(1, , null))
////		
////		new Song(1, "있잖아 (ROCK VER.)", "IU (아이유)", CategoryType.DANCE, "lyrics", "2009.04", "IU (아이유) - 있잖아.jpg", "IU (아이유) - 있잖아 (ROCK VER.).mp3");
////		new Song(2, "마지막처럼", "BLACKPINK", CategoryType.DANCE, "", "2017.06", "BLACKPINK - 마지막처럼.jpg", "BLACKPINK - 마지막처럼.mp3");
////		new Song(3, "Into the I-LAND", "IU (아이유)", CategoryType.DANCE, "", "2020.06", "IU (아이유) - Into the I-LAND.jpg", "IU (아이유) - Into the I-LAND.mp3");
////		
////		
////		//List<> books = new ArrayList<>();
//////		books.add(new Book(null, "제목1", 3.1, 4.3));
//////		books.add(new Book(null, "제목2", 3.1, 4.3));
//////		books.add(new Book(null, "제목3", 3.1, 4.3));
//////		bookRepository.saveAll(books);
//////		
//////		ResultActions resultActions = mockMvc.perform(get("/book")
//////				.accept(MediaType.APPLICATION_JSON_UTF8));
//////		
//////		resultActions.andExpect(jsonPath("$.[0].title").value("제목1"))
//////		.andExpect(jsonPath("$", Matchers.hasSize(3)))//뭐지? junit5이 내장돼 있음에도 불구하고 내가 라이브러리를 또 추가시켜줬기 때문! build패스에서 제거
//////		.andDo(MockMvcResultHandlers.print());
////		
////	}
//	
//	
//	
//	
//	
//	
//
//}
