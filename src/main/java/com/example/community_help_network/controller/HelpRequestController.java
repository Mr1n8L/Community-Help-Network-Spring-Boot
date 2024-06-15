package com.example.community_help_network.controller;

import com.example.community_help_network.model.HelpRequest;
import com.example.community_help_network.service.HelpRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/help-requests")
public class HelpRequestController {
    @Autowired
    private HelpRequestService helpRequestService;

    @PostMapping
    public ResponseEntity<HelpRequest> createHelpRequest(@RequestParam String title, @RequestParam String description) {
        return ResponseEntity.ok(helpRequestService.createHelpRequest(title, description));
    }

    @GetMapping
    public ResponseEntity<List<HelpRequest>> getAllHelpRequests() {
        return ResponseEntity.ok(helpRequestService.getAllHelpRequests());
    }

    @PostMapping("/{id}/status")
    public ResponseEntity<HelpRequest> updateStatus(@PathVariable Long id, @RequestParam String status) {
        HelpRequest helpRequest = helpRequestService.findHelpRequestById(id);
        if (helpRequest != null) {
            helpRequest.setStatus(status);
            helpRequestService.save(helpRequest);
            return ResponseEntity.ok(helpRequest);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}



/*package com.example.community_help_network.controller;


import com.example.community_help_network.model.HelpRequest;
import com.example.community_help_network.service.HelpRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/help-requests")
public class HelpRequestController {
    @Autowired
    private HelpRequestService helpRequestService;

    @GetMapping("/help-requests")
    public String listHelpRequests(Model model) {
        model.addAttribute("helpRequests", helpRequestService.findAll());
        return "help-requests";
    }

    @GetMapping("/help-requests/new")
    public String showCreateForm(Model model) {
        model.addAttribute("helpRequest", new HelpRequest());
        return "create-help-request";
    }

    @PostMapping("/help-requests")
    public String createHelpRequest(HelpRequest helpRequest) {
        helpRequestService.save(helpRequest);
        return "redirect:/help-requests";
    }

    @PostMapping("/help-requests/{id}/status")
    public String updateStatus(@PathVariable Long id, @RequestParam String status) {
        HelpRequest helpRequest = helpRequestService.findById(id);
        helpRequest.setStatus(status);
        helpRequestService.save(helpRequest);
        return "redirect:/help-requests";
    }
}*/
