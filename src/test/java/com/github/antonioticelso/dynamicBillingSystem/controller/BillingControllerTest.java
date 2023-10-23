package com.github.antonioticelso.dynamicBillingSystem.controller;

import com.github.antonioticelso.dynamicBillingSystem.AbstractContainerBase;
import com.github.antonioticelso.dynamicBillingSystem.models.dto.BillingAccountCreateDTO;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BillingControllerTest extends AbstractContainerBase {

    @LocalServerPort
    private int randomPort;

    @BeforeEach
    public void setUpTest() {
        RestAssured.port = randomPort;
    }

    @Test
    void whenFindAllThenCheckResult() {
        RestAssured.given()
                .when()
                .get("/dynamicBilling")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    void findById() {
    }

    @Test
    void whenCreateThenCheckIsCreated() {
        BillingAccountCreateDTO createDTO = new BillingAccountCreateDTO();
        createDTO.setMSISDNRequest("936151484");
        createDTO.setBucket1(1.25);
        createDTO.setBucket2(5.25);

        RestAssured.given()
                .when()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(createDTO)
                .post("/dynamicBilling")
                .then()
                .statusCode(HttpStatus.CREATED.value());

    }

}
