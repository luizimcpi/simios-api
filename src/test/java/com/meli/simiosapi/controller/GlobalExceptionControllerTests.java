package com.meli.simiosapi.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GlobalExceptionControllerTests {

    private Exception e;

    @InjectMocks
    private GlobalExceptionController globalExceptionController;

    @Before
    public void setUp() {
        e = new Exception();
    }

    @Test
    public void deveEfetuarHandleDeBadRequestComSucesso() {
        Assert.assertNotNull(globalExceptionController.handleBadRequestException(e));
    }


}