package hello;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/person")
public class PersonService {
	
	@Autowired PersonRepository personRepository;
	
	@GET
	@Produces("application/json")
	public List<Person> getPersons() {
		return makeCollection(personRepository.findAll());
	}
	
	@GET
	@Produces("application/json")
	@Path("/{name}")
	public Person getPerson(@PathParam("name") String name) {
		return personRepository.findByName(name);
	}
	
	public static List<Person> makeCollection(Iterable<Person> iter) {
	    List<Person> list = new ArrayList<Person>();
	    for (Person item : iter) {
	        list.add(item);
	    }
	    return list;
	}

}
