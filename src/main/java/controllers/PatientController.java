package controllers;

import dao.DepartmentsService;
import dao.DoctorsService;
import dao.RegistrationService;
import dao.impl.DepartmentsServiceImpl;
import dao.impl.DoctorsServiceImpl;
import dao.impl.RegistrationServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import persistence.Workday;

import javax.inject.Inject;
import java.sql.Date;
import java.util.List;

@Controller
public class PatientController {

    private DoctorsService docService;
    private DepartmentsService depService;
    private RegistrationService regService;

    @Inject
    PatientController(DoctorsService docService,
                      DepartmentsService depService,
                      RegistrationService regService) {
        this.docService = docService;
        this.depService = depService;
        this.regService = regService;
    }


    @RequestMapping("/patient")
    public String selectDocAndDate(Model model) {
        model.addAttribute("docList",docService.getAllDoctors());
        model.addAttribute("depList",depService.getDepartments());
        return "date";
    }


    @RequestMapping(value="/patient", method= RequestMethod.POST)
    public String registration(@RequestParam long docId,
                               @RequestParam String dateStr,
                               Model model) {
        Date date = Date.valueOf(dateStr.trim());
        List list = regService.findWorkday(docId, date);
        model.addAttribute("timeList", list);
        return "time";
    }

    @RequestMapping(value="/patient/time", method=RequestMethod.POST)
    public String selectTime(@RequestParam String name,
                             @RequestParam String message,
                             @RequestParam long time) {
        regService.saveTicket(time,name,message);
        return "/home";
    }

}
