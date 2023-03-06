package com.josh.explore.photo.clone.repository;

import com.josh.explore.photo.clone.model.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotoRepository extends CrudRepository<Photo, Integer> {

}
