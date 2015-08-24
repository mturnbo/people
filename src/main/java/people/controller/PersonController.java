package people.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import people.model.Family;
import people.model.Person;
import people.repository.PersonRepositoryCrud;
import people.repository.FamilyRepositoryCrud;

@RestController
public class PersonController {

    @Autowired
    private PersonRepositoryCrud personRepository;

    @Autowired
    private FamilyRepositoryCrud familyRepository;

    @RequestMapping(value = "/updateFamily", method = RequestMethod.POST)
    @ResponseBody
    public Person updateFamily(@RequestParam("person") Long personId, @RequestParam("family") Long familyId,
                               HttpServletResponse response) {
        Person person = personRepository.findOne(personId);
        Family family = familyRepository.findOne(familyId);
        if (person != null && family != null) {
            person.setFamily(family);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        return person;
    }
}
