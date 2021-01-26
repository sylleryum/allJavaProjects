package com.springbootwebdemo.Controller;

import com.springbootwebdemo.Entity.Pojo;
import com.springbootwebdemo.DAO.PojoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class NewController {

    @RequestMapping("/")
    public String home(Model model){


        //model.addAttribute("thePojo",new Pojo());
        return "home";
    }

    @RequestMapping("/addPojo")
    public String addPojo(Pojo pojofilled){

        pojoDao.save(pojofilled);
        System.out.println(pojofilled);


        return "home";
    }

    @RequestMapping("/getPojo")
    public String showPojo(Model model){

        List<Pojo> listPojos = (List<Pojo>) pojoDao.findAll();
        model.addAttribute("pojos", listPojos);
        return "showpojo";
    }

    @RequestMapping("/getPojos/{Id}")
    @ResponseBody
    public String showPojos(@PathVariable("Id")int id){


        return pojoDao.findById(id).toString();
    }

    @Autowired
    private PojoRepo pojoDao;
}
