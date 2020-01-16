package com.arajit.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class MessageSupplierTest {

  private static final Logger log = LogManager.getLogger(MessageSupplierTest.class);

  @Test
  public void testSupplier() {
    log.info(() -> new LogMessage("AOP", "AOP test message"));
  }
}
