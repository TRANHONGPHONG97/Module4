package cg.wbd.grandemonstration.servlet;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import cg.wbd.grandemonstration.service.CustomerServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class CustomerController extends HttpServlet {
    @Autowired
    private CustomerService customerService;

    //    private CustomerService customerService = CustomerServiceFactory.getInstance();
    @GetMapping("/customers")
//    public String showList(HttpServletRequest request) {
//        List<Customer> customers = customerService.findAll();
//        request.setAttribute("customers", customers);
//        return "customers/list.jsp";

//        public String showList(Model model) {
//            List<Customer> customers = customerService.findAll();
//            model.addAttribute("customers", customers);
//            return "customers/list.jsp";

    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("customers/list.jsp");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;

    }

    @PostMapping("/customers")
    public ModelAndView update(HttpServletRequest req){
        ModelAndView modelAndView = new ModelAndView("customers/list.jsp");
        List<Customer> customers = customerService.findAll();

        Customer customer = new Customer();
        customer.setName(req.getParameter("name"));
        customer.setEmail(req.getParameter("email"));
        customer.setAddress(req.getParameter("address"));

        Long id = Long.valueOf(req.getParameter("id"));
        customer.setId(id);
        customerService.save(customer);
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

}
