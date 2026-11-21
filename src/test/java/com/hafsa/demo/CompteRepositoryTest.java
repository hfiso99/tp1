
package com.hafsa.demo;

import com.hafsa.demo.entities.Compte;
import com.hafsa.demo.entities.TypeCompte;
import com.hafsa.demo.repositories.CompteRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CompteRepositoryTest {

    @Autowired
    private CompteRepository compteRepository;

    @Test
    void testSaveCompte() {

        Compte compte = Compte.builder()
                .solde(5000)
                .dateCreation(new Date())
                .type(TypeCompte.COURANT)
                .build();

        Compte savedCompte = compteRepository.save(compte);

        assertNotNull(savedCompte.getId());
        assertEquals(5000, savedCompte.getSolde());

        System.out.println("Compte enregistré : " + savedCompte);
    }

    @Test
    void testFindAll() {

        assertNotNull(compteRepository.findAll());
    }
}
