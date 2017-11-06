/*
 * Copyright (c) 2016, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.msf4j.example;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Api(value = "risk-events")
@SwaggerDefinition(
        info = @Info(
                title = "RiskEventsAlertService", version = "1.0",
                description = "Checks and reports possible risks",
                license = @License(name = "Apache 2.0", url = "http://www.apache.org/licenses/LICENSE-2.0"),
                contact = @Contact(
                        name = "Chathura Kulasinghe",
                        email = "chathurak@wso2.com",
                        url = "http://wso2.com"
                ))
)
@Path("/risk-events")
public class RiskCheckerService {

    @GET
    @Path("/velocity")
    @Produces({"application/json", "text/xml"})
    @ApiOperation(
            value = "Checks whether the train is delayed",
            notes = "Returns the scheduled time and the delay")

    public RiskEvent getDelayAnalysed(@ApiParam(value = "Current velocity", required = true) @QueryParam("velocity") float velocity,
            @ApiParam(value = "Outer rail elevation", required = true) @QueryParam("outerElevation") int outerElevation,
            @ApiParam(value = "Railway curvature", required = true) @QueryParam("curvature") int curvature) {

        double minimumVelocity = Math.sqrt((outerElevation+3)/0.0007*curvature);
        double maximumVelocity = 200.00;
        
        if(velocity<minimumVelocity || velocity>200){
            System.out.println("RISKY SPEED! MAINTAIN BETWEEN "+minimumVelocity+" AND "+maximumVelocity);
            return new RiskEvent(true, minimumVelocity,maximumVelocity);
        }else{
            System.out.println("NORMAL SPEED! REQUIRED BETWEEN "+minimumVelocity+" AND "+maximumVelocity);
            return new RiskEvent(false, minimumVelocity,maximumVelocity);
        }
    }
}
