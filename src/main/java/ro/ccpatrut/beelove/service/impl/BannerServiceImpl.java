package ro.ccpatrut.beelove.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ccpatrut.beelove.dto.BannerDTO;
import ro.ccpatrut.beelove.entities.BannerEntity;
import ro.ccpatrut.beelove.repository.BannerRepository;
import ro.ccpatrut.beelove.service.BannerService;

import javax.transaction.Transactional;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerRepository bannerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BannerDTO findFirstEntry() {
        return this.modelMapper.map(
                this.bannerRepository.findById(1L).
                        orElse(new BannerEntity()), BannerDTO.class);
    }
}
