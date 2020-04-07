package com.rent.carrentwebapi;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * create by lyndon
 *
 * if the test need to start springboot,need extend this class
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class AbstractTest extends BaseTest {

}
