package com.bhargrah.roomservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller to showcase use of {@code DiscoveryClient}
 * , which can be used to fetch registered instances from
 * Eureka server. Information returned can be used to
 * inspect information and other registration stats.
 */

@RestController
@RequestMapping("/")
public class InstanceController {

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("instances")
    public List<ServiceInstance> getInstances(){
     List<ServiceInstance> instanceList = discoveryClient.getInstances("RoomService");
       return instanceList;
    }

}
