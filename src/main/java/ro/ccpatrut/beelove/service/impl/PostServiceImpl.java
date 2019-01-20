package ro.ccpatrut.beelove.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ccpatrut.beelove.dto.PostDTO;
import ro.ccpatrut.beelove.repository.PostRepository;
import ro.ccpatrut.beelove.service.PostService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PostDTO> findAll() {
        final List<PostDTO> postDTOS = new ArrayList<>();

        this.postRepository.findAll()
                .forEach(postEntity -> postDTOS.add(this.modelMapper.map(postEntity, PostDTO.class)));

        return postDTOS;
    }
}
