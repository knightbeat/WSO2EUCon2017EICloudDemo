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
@XmlRootElement(name = "DelayResponse")
public class DelayResponse {
    private String scheduledTime;
    private boolean delayed;
    private int delayedBy;

    @XmlElement(name = "ScheduledTime")
    public String getScheduledTime() {
        return scheduledTime;
    }

    @XmlElement(name = "IsDelayed")
    public boolean isDelayed() {
        return delayed;
    }

    @XmlElement(name = "DelayedBy")
    public int getDelayedBy() {
        return delayedBy;
    }

    public void setScheduledTime(String scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public void setDelayed(boolean delayed) {
        this.delayed = delayed;
    }


    public void setDelayedBy(int delayedBy) {
        this.delayedBy = delayedBy;
    }

    public DelayResponse() {
    }

    public DelayResponse(String scheduledTime, boolean delayed, int delayedBy) {
        this.scheduledTime = scheduledTime;
        this.delayed = delayed;
        this.delayedBy = delayedBy;
    }


    
    
}
