package com.yz.sophia.stargaze.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Huang Zhaoping
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "user_root")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
    private Long id;
    private String name;
    @XmlElementWrapper
    @XmlElement(name = "job")
    private List<Job> jobs;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Job {

        private String company;
        private String number;

        public static void main(String[] args) {

        }


    }
}
