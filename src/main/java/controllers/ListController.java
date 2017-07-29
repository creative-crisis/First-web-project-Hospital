package controllers;


import dao.DepartmentsService;
import dao.DoctorsService;
import dao.impl.DepartmentsServiceImpl;
import dao.impl.DoctorsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class ListController {

    private DoctorsService docService;
    private DepartmentsService depService;

    ListController(DoctorsService docService, DepartmentsService depService) {
        this.docService = docService;
        this.depService = depService;
    }

    @RequestMapping({"/list"})
    public String allDoctors(Model model) {
        List docList = docService.getAllDoctors();
        model.addAttribute("docList", docList);
        List depList = depService.getDepartments();
        model.addAttribute("depList",depList);
        return "list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public String deleteDoctor(@RequestParam long id, Model model) {
        docService.deleteDoctor(id);
        List docList = docService.getAllDoctors();
        model.addAttribute("docList", docList);
        List depList = depService.getDepartments();
        model.addAttribute("depList",depList);
        return "list";
    }

    @RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
    public String specialList(@RequestParam long id, Model model) {
        List docList = docService.getDoctorsBySpecialization(id);
        model.addAttribute("docList", docList);
        List depList = depService.getDepartments();
        model.addAttribute("depList",depList);
        return "list";
    }

//    @RequestMapping(value = "/list/{spec}", method = RequestMethod.POST)
//    public String specialListDelete(@RequestParam long id, Model model) {
//        docService.deleteDoctor(id);
//        List docList = docService.getDoctorsBySpecialization(id);
//        model.addAttribute("docList", docList);
//        List depList = depService.getDepartments();
//        model.addAttribute("depList",depList);
//        return "list";
//    }

}