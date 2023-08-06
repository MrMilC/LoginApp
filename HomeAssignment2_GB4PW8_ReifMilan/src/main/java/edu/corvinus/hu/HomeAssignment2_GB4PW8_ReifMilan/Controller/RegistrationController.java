package edu.corvinus.hu.HomeAssignment2_GB4PW8_ReifMilan.Controller;

import edu.corvinus.hu.HomeAssignment2_GB4PW8_ReifMilan.Model.Account;
import edu.corvinus.hu.HomeAssignment2_GB4PW8_ReifMilan.Model.LoginForm;
import edu.corvinus.hu.HomeAssignment2_GB4PW8_ReifMilan.Repository.AccountRepository;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class RegistrationController {
    private final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    private final AccountRepository repository;

    @Autowired
    public RegistrationController(AccountRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String showLoginForm(LoginForm registrationForm) {

        return "login";
    }

    @PostMapping("/")
    public String register(@Valid LoginForm loginForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.info("Validation errors occurred!");
            return "login";
        }

        logger.info("Registering user with email: {}", loginForm.getEmail());
        final boolean userIsRegistered = repository.findByEmail(loginForm.getEmail()).isPresent();
        if (!userIsRegistered) {
            repository.save(new Account(loginForm.getEmail(), loginForm.getName()));
        }

        return "redirect:/homepage?email=" + loginForm.getEmail();
    }

    @GetMapping("/homepage")
    public String showHomePage(@RequestParam(value = "name", required = false) String name, String email, Model model) {

        final Optional<Account> foundAccount = repository.findByEmail(email);
        if (foundAccount.isEmpty()) {
            return "redirect:/";
        }

        final Account account = foundAccount.get();
        final String accname=account.getName();
        model.addAttribute("accname", accname);

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        String formattedDate = currentDate.format(formatter);
        model.addAttribute("currentDate", formattedDate);

        //DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
        //String imageUrl = "/resources/" + dayOfWeek.toString().toLowerCase() + ".png";
        //model.addAttribute("imageUrl", imageUrl);

        String dayImage = ImageSelector.getCurrentDayImageName();
        model.addAttribute("dayImage", dayImage);

        return "homepage";
    }
}