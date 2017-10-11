package com.francesco.ChiamataRest.persistence;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins="*")
@RequestMapping(path = "/studente", method = RequestMethod.POST)
public class StudenteDAO {

    @Autowired //serve per ottenere il bean studenteRepository
    private StudenteRepository studenteRepository;

    //metodo richiamato da Postman
    @CrossOrigin(origins="*")
    @PostMapping(value = "/add")
    public @ResponseBody String addNewStudente (@RequestParam (value="matricola")String matricola, @RequestParam (value="nome")String nome, @RequestParam (value="cognome")String cognome, @RequestParam (value="data")String data)
    {
        System.out.println("sono in add e sono stato chiamato dal front end");
        StudenteEntity stud = new StudenteEntity();
        stud.setNome(nome);
        stud.setCognome(cognome);
        stud.setMatricola(matricola);
        stud.setData(data);
        studenteRepository.save(stud);
        return "salvato con successo";
    }


    //metodo richiamato dal front end in angular2
    @CrossOrigin(origins="*")
    @PostMapping(value = "/add2")
    public @ResponseBody Boolean addNewStudente2 (@RequestBody StudenteEntity studenteEntity)
    {
        Boolean flag =false;
        System.out.println("sono in addNewStudente 2 e sono stato chiamato dal front end");
        StudenteEntity stud = new StudenteEntity();
        stud.setNome(studenteEntity.getNome());
        stud.setCognome(studenteEntity.getCognome());
        stud.setMatricola(studenteEntity.getMatricola());
        stud.setData(studenteEntity.getData());
        if( studenteRepository.save(stud)!=null) {
            flag= true;
            System.out.println("salvato con successo");
        }
        return flag;
    }

    //stampa record Db
    @CrossOrigin(origins="*")
    @PostMapping(path="/all")
    public @ResponseBody Iterable<StudenteEntity> getAllUsers() {
        System.out.println("sono in stampa record e stato chiamato dal front end");

        return studenteRepository.findAll();
    }


    //metodo prova
    @CrossOrigin(origins="*")
    @PostMapping(value = "/prova")
    public @ResponseBody ResponseEntity<Boolean> prova() {
        System.out.println( "sono in prova e stato chiamato dal front end");
        boolean flag=true;
        return new ResponseEntity<>(flag, HttpStatus.OK);

    }

}