package com.example.inscriptionms.proxy;

import com.fasterxml.jackson.annotation.JsonProperty;
import feign.Headers;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

@FeignClient(name = "USERS-SERVICE")
public interface EnseignantProxy {
    @GetMapping("/api/enseignants/{id}")
    public Enseignant findEnseignantById(@PathVariable(name = "id") Long id);

}

