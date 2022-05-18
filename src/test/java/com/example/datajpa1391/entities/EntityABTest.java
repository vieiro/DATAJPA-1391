package com.example.datajpa1391.entities;

import com.example.datajpa1391.repositories.EntityABRepository;
import com.example.datajpa1391.repositories.EntityARepository;
import com.example.datajpa1391.repositories.EntityBRepository;
import java.util.Optional;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest(showSql = true)
public class EntityABTest {

    @Autowired
    private EntityARepository entityARepository;

    @Autowired
    private EntityBRepository entityBRepository;

    @Autowired
    private EntityABRepository entityABRepository;

    @Autowired
    private EntityManager entityManager;

    public EntityABTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testShouldJPASaveCorrectly() {
        System.out.println("testShouldJPASaveCorrectly");
        EntityA a = new EntityA();
        a.setName("A");
        a = entityARepository.save(a);

        EntityB b = new EntityB();
        b.setName("B");
        b.setName("B");
        b = entityBRepository.save(b);

        EntityAB ab = new EntityAB();
        ab.setA(a);
        ab.setB(b);

        // This fails using JPA
        try {
            ab = entityABRepository.save(ab);
        } catch (Throwable e) {
            Assertions.fail(String.format("EntityManagerAB.save() failed: %s", e.getMessage()));
            // e.printStackTrace(System.err);
        }

    }

    @Test
    public void testShouldEntityManagerPersistCorrectly() {
        System.out.println("testShouldEntityManagerPersistCorrectly");
        EntityA a = new EntityA();
        a.setName("A");
        a = entityARepository.save(a);

        EntityB b = new EntityB();
        b.setName("B");
        b = entityBRepository.save(b);

        EntityAB ab = new EntityAB();
        ab.setA(a);
        ab.setB(b);
        // EntityManager persist does not fail
        entityManager.persist(ab);

        EntityABPK pk = new EntityABPK(a, b);
        Optional<EntityAB> abAgain = entityABRepository.findById(pk);

        Assertions.assertTrue(abAgain.isPresent());
        Assertions.assertEquals("A", abAgain.get().getA().getName());
        Assertions.assertEquals("B", abAgain.get().getB().getName());

    }

}
