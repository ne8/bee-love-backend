package ro.ccpatrut.beelove.service;

import ro.ccpatrut.beelove.dto.PostDTO;

import java.util.List;

public interface PostService {

    List<PostDTO> findAll();
}
