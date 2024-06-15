package com.example.community_help_network.service;



import com.example.community_help_network.model.HelpRequest;
import com.example.community_help_network.repository.HelpRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HelpRequestService {

    @Autowired
    private HelpRequestRepository helpRequestRepository;
//Autowire was not able to identify the method

    public HelpRequest createHelpRequest(String title, String description) {


        HelpRequest helpRequest = new HelpRequest();
        helpRequest.setTitle(title);
        helpRequest.setDescription(description);
        helpRequest.setStatus("Open");
        helpRequest.setPostedAt(LocalDateTime.now().toString());
        return helpRequestRepository.save(helpRequest);
    }

    public List<HelpRequest> getAllHelpRequests() {
        return helpRequestRepository.findAll();
    }

    public HelpRequest findHelpRequestById(Long id) {
        return helpRequestRepository.findById(id).orElse(null);
    }

    public void save(HelpRequest helpRequest) {
        //it should save helprequests

        helpRequestRepository.save(helpRequest);
    }
}