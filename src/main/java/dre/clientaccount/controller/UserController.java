package dre.clientaccount.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.net.server.Client;
import dre.clientaccount.ClientRepository;

@RestController
@RequestMapping(value = "/clients")
public class UserController {

@Autowired
private ClientRepository repository;

@GetMapping
public List<Client> findAll(){
    List<Client> result=repository.findAll();
    return result;
}
@GetMapping(value="/{id}")
public Client findById(@PathVariable Long id){
    Client result=repository.findById(id).get();
    return result;

}

@PostMapping
public Client insert(@RequestBody Client client){
    Client result=repository.save(client);
    return result;
}

@DeleteMapping(value = "delete")
@ResponseStatus(HttpStatus.NO_CONTENT)
public void delete(@PathVariable Long id){
    repository.deleteById(id);
}
@PutMapping("/{id}")
public Client upDate(@PathVariable Long id,@RequestBody Client client){
Client current=repository.findById(id).get();
BeanUtils.copyProperties(client, current,"id");
return repository.save(current);

}


    
}
