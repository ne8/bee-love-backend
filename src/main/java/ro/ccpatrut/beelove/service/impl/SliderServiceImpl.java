package ro.ccpatrut.beelove.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ccpatrut.beelove.dto.SliderDTO;
import ro.ccpatrut.beelove.repository.SliderRepository;
import ro.ccpatrut.beelove.service.SliderService;

import java.util.ArrayList;
import java.util.List;

@Service
public class SliderServiceImpl implements SliderService {

    @Autowired
    private SliderRepository sliderRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<SliderDTO> findAll() {
        final List<SliderDTO> sliderDTOS = new ArrayList<>();
        this.sliderRepository.findAll().forEach(
                sliderEntity -> sliderDTOS.add(this.modelMapper.map(sliderEntity, SliderDTO.class))
        );
        return sliderDTOS;
    }
}
