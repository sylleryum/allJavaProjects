package com.springbootwebdemo.Controller;

import com.springbootwebdemo.Entity.Pojo;
import com.springbootwebdemo.DAO.PojoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class NewController {

    @RequestMapping("/")
    public String home(Model model){


        //model.addAttribute("thePojo",new Pojo());
        return "home";
    }

    @PostMapping("/addPojo")
    public String addPojo(@RequestBody Pojo pojofilled){

        pojoDao.save(pojofilled);
        System.out.println(pojofilled);


        return "Adicionado com sucesso";
    }

    @PutMapping("/updatePojo")
    public String updatePojo(@RequestBody Pojo pojofilled){

        pojoDao.save(pojofilled);

        return "atualizado com sucesso";
    }

    @DeleteMapping("/deletePojo/{idD}")
    public String deletePojo(@PathVariable("idD") int id){

        Pojo pojo = pojoDao.getOne(id);
        pojoDao.delete(pojo);

        return "Deletado com sucesso";
    }

    @RequestMapping("/getPojos")
    public List<Pojo> showPojo(Model model){

        return pojoDao.findAll();
    }

    @RequestMapping("/getPojo/{Id}")
    public Optional<Pojo> showPojos(@PathVariable("Id")int id){


        return pojoDao.findById(id);
    }

    @Autowired
    private PojoRepo pojoDao;
}
