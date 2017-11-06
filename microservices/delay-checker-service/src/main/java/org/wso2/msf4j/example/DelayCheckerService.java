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

@Api(value = "delay-checker")
@SwaggerDefinition(
        info = @Info(
                title = "TrainsDelayChecker", version = "1.0",
                description = "Checks whether trains would delay",
                license = @License(name = "Apache 2.0", url = "http://www.apache.org/licenses/LICENSE-2.0"),
                contact = @Contact(
                        name = "Chathura Kulasinghe",
                        email = "chathurak@wso2.com",
                        url = "http://wso2.com"
                ))
)
@Path("/delay-checker")
public class DelayCheckerService {

    @GET
    @Path("/sensor-event")
    @Produces({"application/json", "text/xml"})
    @ApiOperation(
            value = "Checks whether the train is delayed",
            notes = "Returns the scheduled time and the delay")

    public DelayResponse getDelayAnalysed(@ApiParam(value = "Train ID", required = true) @QueryParam("trainID") String trainID,
            @ApiParam(value = "Departure time", required = true) @QueryParam("departureTime") String departureTime,
            @ApiParam(value = "Sensor post", required = true) @QueryParam("sensorPost") String sensorPost) {
        System.out.println("GET invoked");
        int departureTimeValue = Integer.parseInt(departureTime);
        int validatorValue = departureTimeValue%10;
        if(validatorValue!=0){
            int properTime = departureTimeValue-validatorValue;
            int delay = departureTimeValue - properTime;
            String properTimeStr = Integer.toString(properTime);
            if(properTimeStr.length()<4){
                properTimeStr = "0"+properTimeStr;
            }
            return new DelayResponse(properTimeStr,true, delay);
        }else{
            String departureTimeValueStr = Integer.toString(departureTimeValue);
            if(departureTimeValueStr.length()<4){
                departureTimeValueStr = "0"+departureTimeValueStr;
            }
            return new DelayResponse(departureTimeValueStr, false, 0);
        }
    }
}
