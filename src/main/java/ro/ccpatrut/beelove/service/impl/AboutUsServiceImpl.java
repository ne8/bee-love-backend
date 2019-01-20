package ro.ccpatrut.beelove.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ccpatrut.beelove.dto.AboutUsDTO;
import ro.ccpatrut.beelove.repository.AboutUsRepository;
import ro.ccpatrut.beelove.service.AboutUsService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AboutUsServiceImpl implements AboutUsService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AboutUsRepository aboutUsRepository;

    @Override
    public List<AboutUsDTO> findAll() {
        final List<AboutUsDTO> aboutUsDTOS = new ArrayList<>();
        this.aboutUsRepository.findAll().forEach(aboutUsEntity ->
                aboutUsDTOS.add(this.modelMapper.map(aboutUsEntity, AboutUsDTO.class)));
        return aboutUsDTOS;
    }
}
