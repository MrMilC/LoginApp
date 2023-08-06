package edu.corvinus.hu.HomeAssignment2_GB4PW8_ReifMilan.Repository;

import edu.corvinus.hu.HomeAssignment2_GB4PW8_ReifMilan.Model.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Long> {
    List<Account> findAll();
    Optional<Account> findByEmail(String email);
}
