package people.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
import people.People;
import people.model.Family;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpMethod.GET;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = People.class)
@WebAppConfiguration
@IntegrationTest(value = "server.port=9000")
public class FamilyRepositoryRestTest {

    private RestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void getFamily() {
        String url = "http://localhost:9000/family/1";

        ParameterizedTypeReference<Resource<Family>> responseType =
                new ParameterizedTypeReference<Resource<Family>>() {};
        ResponseEntity<Resource<Family>> responseEntity = restTemplate.exchange(url, GET, null, responseType);
        Family family = responseEntity.getBody().getContent();

        assertEquals("Jones", family.getName());
    }
}
