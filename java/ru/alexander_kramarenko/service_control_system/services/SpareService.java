package ru.alexander_kramarenko.service_control_system.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alexander_kramarenko.service_control_system.repositories.SpareRepository;

@Service
@RequiredArgsConstructor
public class SpareService {

    private final SpareRepository spareRepository;


}
