package com.darren.controller;

import com.darren.domain.Contact;
import com.darren.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/contact")
public class ContactController {
    private final ContactService contactService;

    public ContactController(@Qualifier("ContactServiceImpl") ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/create")
    @ResponseBody
    public Contact create(@RequestBody Contact contact) {
        return contactService.create(contact);
    }

    @PutMapping("/update")
    @ResponseBody
    public Contact update(@RequestBody Contact contact) {
        return contactService.update(contact);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Contact read(@PathVariable String id) {
        return contactService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        contactService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public Set<Contact> getAll() {
        return contactService.getAll();
    }

    @RunWith(SpringRunner.class)
    @SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
    public static class TrainAppSecurityTest {

        @Autowired
        private TestRestTemplate restTemplate;

        private String baseURL="http://localhost:8080/TrainApp";

        @Autowired

        @Before
        public void addDummyData(){

        }

        @Test
        public void whenCorrectCredentialsWillBe200() throws Exception {

            /*ResponseEntity<String> response = restTemplate.withBasicAuth("admin", "admin").getForEntity(baseURL + "/getall", String.class);

            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());

            assertEquals(HttpStatus.OK, response.getStatusCode());*/

        }

        @Test
        public void whenIncorrectCredentialsWillBe401() throws Exception {

           /* ResponseEntity<String> response = restTemplate.withBasicAuth("admin", "admins").getForEntity(baseURL + "/getall", String.class);

            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());

            assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());*/

        }

    }
}