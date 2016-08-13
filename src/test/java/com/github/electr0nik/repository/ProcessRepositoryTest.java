package com.github.electr0nik.repository;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author nik
 * @since 1.0.0-SNAPSHOT
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestExecutionListeners(DbUnitTestExecutionListener.class)
public class ProcessRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

  private static final String DATA_SET = "classpath:dataset/smoke-db.xml";

  @Autowired
  private ProcessRepository repository;

  @Test
  @DatabaseSetup(DATA_SET)
  @DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = DATA_SET)
  public void findByUser() throws Exception {
    assertThat(((Collection) repository.findAll()).size(), is(13));

    assertThat(repository.findByUser("nik").size(), is(6));
    assertThat(repository.findByUser("not nik").size(), is(3));
    assertThat(repository.findByUser("nik not").size(), is(2));
    assertThat(repository.findByUser("java").size(), is(1));
  }

}