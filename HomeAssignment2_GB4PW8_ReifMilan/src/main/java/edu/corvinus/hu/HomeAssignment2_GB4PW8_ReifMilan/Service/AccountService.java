package edu.corvinus.hu.HomeAssignment2_GB4PW8_ReifMilan.Service;

import edu.corvinus.hu.HomeAssignment2_GB4PW8_ReifMilan.Model.Account;
import edu.corvinus.hu.HomeAssignment2_GB4PW8_ReifMilan.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private AccountRepository accountRepo;

    @Autowired
    public void setStoryRepo(AccountRepository accountRepo) {this.accountRepo = accountRepo;}

    public List<Account> getAccounts() {
        return (List<Account>) accountRepo.findAll();
    }
}
