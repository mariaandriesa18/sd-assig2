package ro.sd.a2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ro.sd.a2.dto.ShowUsersDTO;
import ro.sd.a2.entity.Companies;
import ro.sd.a2.entity.User;
import ro.sd.a2.mail.EmailServiceImpl;
import ro.sd.a2.mail.MailObject;
import ro.sd.a2.service.CompaniesService;
import ro.sd.a2.service.InvoiceService;
import ro.sd.a2.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminPageController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private CompaniesService companiesService;
    @Autowired
    public EmailServiceImpl emailService;
    @Autowired
    public InvoiceService invoiceService;

    @GetMapping("/admin_dashboard")
    public ModelAndView listOfUsers(){
        ModelAndView mv = new ModelAndView();
        List<ShowUsersDTO> userList = userService.getAllUsers();
        mv.addObject("userList", userList);

        Companies company = new Companies();
        mv.addObject("company", company);
        List<Companies> companies = companiesService.getAllCompanies();
        mv.addObject("companies", companies);

        mv.addObject("addedCompany", new Companies());
        mv.addObject("userObj", new User());
        mv.setViewName("admin_dashboard");
        return mv;
    }


    @GetMapping("/selectCompany")
    public void selectCompany(@ModelAttribute("companyList") Companies company, ModelAndView mv){
        String companyName  = company.getCompany_name();
    }

    @PostMapping("/admin_dashboard")
    public ModelAndView addNewCompany(@RequestParam("action") String action,
                                     @RequestParam("sendEmail")String sendEmail,
                                      @ModelAttribute("addedCompany")@Valid Companies companies,
                                      ModelAndView mv,
                                      final HttpServletRequest req){
        if(action.equals("add_company")){
            log.info(companies.getCompany_name() + "  added");
            companiesService.addNewCompany(companies.getCompany_name(),companies.getCurrency());
        }
        if(action.equals("send_email")){
            MailObject mail = new MailObject();
            mail.setTo(sendEmail);
            emailService.sendSimpleMessage(mail.getTo(),"Negative Balance", " The balanace in your account has become negative.");
        }

        mv = listOfUsers();
        return mv;
    }

    @PostMapping("/generate")
    public ModelAndView generateInvoices(@RequestParam("action") String action, @RequestParam("nbBills") Integer nbBills,  ModelAndView mv){
        if(action.equals("generate_bills")){
            invoiceService.generateXRandomInvoices(nbBills);
        }
        mv = listOfUsers();
        mv.setViewName("/generate");

        return mv;


    }




}
