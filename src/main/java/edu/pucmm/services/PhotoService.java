package edu.pucmm.services;

import edu.pucmm.data.Photo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PhotoService {
    public List<Photo> listAllPhotos();
    public Photo getPhotoById(Long id);

    public Photo createPhoto(Photo photo);
    public Photo updatePhoto(Photo photo);
    public void deletePhoto(Long id);
}
