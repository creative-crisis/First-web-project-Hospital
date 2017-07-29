package controllers;


import dao.DoctorsService;
import dao.impl.DoctorsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AddController {

    private DoctorsService docService;

    AddController(DoctorsService docService) {
        this.docService = docService;
    }

    @RequestMapping({"/add"})
    public String showAdd() {
        return "add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String work(@RequestParam String firstName,
                       @RequestParam String lastName,
                       @RequestParam long specialization) {
        docService.addDoctor(firstName, lastName, specialization);
        return "/home";
    }

}