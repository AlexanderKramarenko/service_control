package ru.alexander_kramarenko.service_control_system.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alexander_kramarenko.service_control_system.model.Brand;
import ru.alexander_kramarenko.service_control_system.model.Status;
import ru.alexander_kramarenko.service_control_system.repositories.StatusRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatusService {

    private final StatusRepository statusRepository;

    public List<Status> findAll() {
        return statusRepository.findAll();
    }


}
