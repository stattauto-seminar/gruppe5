package de.stattauto.fuhrpark.restcontroller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.stattauto.fuhrpark.repository.FuhrparkRepository;
import de.stattauto.fuhrpark.entity.Auto;
import lombok.AllArgsConstructor;


//@AllArgsConstructor
@RefreshScope
@RestController
public class FuhrparkRestController {
	@Value("${welcome.message}")
	private String hallo;
	
	@Autowired
	private FuhrparkRepository repo;
	
	@GetMapping("/alleAutos")
	public Collection<Auto> getAllAutos() {
		return repo.findAll();
	}
	
	@RequestMapping("/ip")
	public String ipadress() throws UnknownHostException  {
		return InetAddress.getLocalHost().getHostAddress();
	}
	
	@GetMapping("/auto/id/{id}")
	public Auto getAutoById(@PathVariable Auto id) {
		return id;
	}
	
	@GetMapping("/hello/{name}")
  public String hello(@PathVariable String name) {
	  return hallo + name;
  }

	@GetMapping("/hello2/")  //http://localhost:8085/hello2/?vorname=abc&nachname=def
	public String hello(@RequestParam String vorname, @RequestParam String nachname) {
	return "hello " + vorname + " " + nachname;
	}
	
	@PostMapping("/addAuto")
	public void addAuto(@RequestBody Auto auto) {
		repo.save(auto);
	}
}
