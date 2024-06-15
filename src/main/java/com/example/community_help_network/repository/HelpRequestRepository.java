package com.example.community_help_network.repository;
//yeh package name sahi nhi tha

import com.example.community_help_network.model.HelpRequest;
import org.springframework.data.jpa.repository.JpaRepository;



public interface HelpRequestRepository extends JpaRepository<HelpRequest, Long> {
//yeh method jo identify nhi ho rahi thi usse pass kara dobara
}

