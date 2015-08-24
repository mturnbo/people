package people.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String updateFamily(@RequestParam("person") Long personId, @RequestParam("family") Long familyId) {
        Person person = personRepository.findOne(personId);
        Family family = familyRepository.findOne(familyId);
        person.setFamily(family);
        return "success";
    }
}
