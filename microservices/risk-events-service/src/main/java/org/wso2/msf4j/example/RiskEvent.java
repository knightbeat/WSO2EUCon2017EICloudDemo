/*
 * Copyright 2017 WSO2.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.msf4j.example;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author chathura
 */
@XmlRootElement(name = "RiskEvent")
public class RiskEvent {
    private boolean risk;
    private double requiredSpeed;
    private double maximumSpeed;

    @XmlElement(name = "isRisk")
    public boolean isRisk() {
        return risk;
    }

    @XmlElement(name = "RequiredSpeed")
    public double getRequiredSpeed() {
        return requiredSpeed;
    }

    @XmlElement(name = "MaximumSpeed")
    public double getMaximumSpeed() {
        return maximumSpeed;
    }

    
    public void setDelayed(boolean risk) {
        this.risk = risk;
    }


    public void setEequiredSpeed(double requiredSpeed) {
        this.requiredSpeed = requiredSpeed;
    }

    public void setMaximumSpeed(double maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }
    
    

    public RiskEvent() {
    }

    public RiskEvent(boolean risk, double requiredSpeed, double maximumSpeed) {
        this.risk = risk;
        this.requiredSpeed = requiredSpeed;
        this.maximumSpeed = maximumSpeed;
    }

    

}
