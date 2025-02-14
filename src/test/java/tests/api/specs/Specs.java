package tests.api.specs;


import helpers.CustomAllureListener;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;

public class Specs {


    public static final RequestSpecification REQ_SPEC = with()

            .baseUri("https://api.qase.io/v1")
            .filter(CustomAllureListener.withCustomTemplates())
            .log().uri()
            .contentType(JSON)
            .header("Token", System.setProperty("token","e71377a915cc9a91dd913850b09cbbd411d276b9f131cda9afcf2f6d62817396"));

    public static final ResponseSpecification RES_SPEC = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .expectStatusCode(200)
            .build();
}
