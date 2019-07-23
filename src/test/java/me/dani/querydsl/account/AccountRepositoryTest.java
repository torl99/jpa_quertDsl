package me.dani.querydsl.account;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import com.querydsl.core.types.Predicate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void crud() {
        QAccount qAccount = QAccount.account;
        Predicate predicate = qAccount
                .firstName.containsIgnoreCase("dani")
                        .and(QAccount.account.lastName.startsWith("dani"));

        Optional<Account> one = accountRepository.findOne(predicate);
        assertThat(one).isEmpty();
        
    }

}
