
package com.francesco.ChiamataRest.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/studente", method = RequestMethod.GET)
public class StudenteDAO {

    @Autowired //serve per ottenere il bean studenteRepository
    private StudenteRepository studenteRepository;

   @RequestMapping(value = "/add",method = RequestMethod.GET)

    public @ResponseBody String addNewStudente (@RequestParam String matricola, @RequestParam String nome, @RequestParam String cognome, @RequestParam String data)
    {
        StudenteEntity stud = new StudenteEntity();
            stud.setNome(nome);
            stud.setCognome(cognome);
            stud.setMatricola(matricola);
            stud.setData(data);
            studenteRepository.save(stud);
        return "salvato con successo";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<StudenteEntity> getAllUsers() {

        return studenteRepository.findAll();
    }
}
