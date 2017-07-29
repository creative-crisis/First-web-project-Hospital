package controllers;


import dao.DoctorsService;
import dao.impl.DoctorsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import persistence.Doctor;



@Controller
public class EditController {

    private DoctorsService docService;

    EditController(DoctorsService docService) {
        this.docService = docService;
    }

    @RequestMapping(value = "/edit")
    public String show() {
        return "edit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showAdd(@RequestParam long id, Model model) {
        Doctor doc = docService.getDoctorById(id);
        model.addAttribute("doctor", doc);
        return "edit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String work(@RequestParam long id,
                       @RequestParam String firstName,
                       @RequestParam String lastName,
                       @RequestParam long specialization) {
        docService.updateDoctor(id, firstName, lastName, specialization);
        return "/home";
    }

}