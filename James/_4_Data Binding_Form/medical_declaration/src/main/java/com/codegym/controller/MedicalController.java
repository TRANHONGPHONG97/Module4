package com.codegym.controller;
import com.codegym.model.Medical;
import com.codegym.services.impl.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
@Controller
public class MedicalController {
    @Autowired
    private MedicalService medicalService;

    @GetMapping(value = "/list")
    public String getAllMailSetting(Model model) {
        List<Medical> medicalFormList = medicalService.getAll();
        model.addAttribute("medicalFormList", medicalFormList);
        return "list";
    }

    @GetMapping(value = "/create")
    public String getFormCreate(Model model) {
        model.addAttribute("listYear", medicalService.getYear());
        model.addAttribute("listGender", medicalService.getGender());
        model.addAttribute("listCountry", medicalService.getCountry());
        model.addAttribute("listVehicle", medicalService.getVehicle());
        model.addAttribute("medicalForm", new Medical());
        return "create";
    }

    @PostMapping(value = "/create")
    public String createMailSetting(@ModelAttribute("medicalForm") Medical medicalForm, RedirectAttributes redirectAttributes) {
        Medical medicalForm1 = new Medical(
                medicalForm.getName(),
                medicalForm.getBirthYear(),
                medicalForm.getGender(),
                medicalForm.getCountry(),
                medicalForm.getIdCardNumber(),
                medicalForm.getVerhice(),
                medicalForm.getVerhiceNumber(),
                medicalForm.getVerhiceNumberSlot(),
                medicalForm.getDayStart(),
                medicalForm.getDayEnd(),
                medicalForm.getCity()
        );
        medicalService.save(medicalForm1);
        redirectAttributes.addFlashAttribute("msg", "Create Success");
        return "redirect:/list";
    }
}
