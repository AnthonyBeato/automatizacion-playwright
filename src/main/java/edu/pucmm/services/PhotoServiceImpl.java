package edu.pucmm.services;

import edu.pucmm.data.Photo;
import edu.pucmm.data.PhotoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PhotoServiceImpl implements PhotoService {

    private final PhotoRepository photoRepository;
    private static final Logger logger = Logger.getLogger(PhotoServiceImpl.class.getName());

    @Autowired
    public PhotoServiceImpl(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public List<Photo> listAllPhotos() {
        List<Photo> photos = photoRepository.findAll();
        logger.info("Number of photos fetched from database: " + photos.size());
        return photos;
    }

    @PostConstruct
    public void verifyDatabaseContents() {
        long count = photoRepository.count();
        logger.info("Total number of photos in the database: " + count);
        List<Photo> photos = photoRepository.findAll();
        for (Photo photo : photos) {
            logger.info(photo.toString());
        }
    }


    @Override
    public Photo getPhotoById(Long id) {
        return photoRepository.findById(id).orElse(null);
    }

    @Override
    public Photo createPhoto(Photo photo) {
        return photoRepository.save(photo);
    }

    @Override
    public Photo updatePhoto(Photo photo) {
        Photo photoDB = getPhotoById(photo.getId());
        if (photoDB == null) {
            return null;
        }
        photoDB.setTitle(photo.getTitle());
        photoDB.setDescription(photo.getDescription());
        photoDB.setUrl(photo.getUrl());
        return photoRepository.save(photoDB);
    }

    @Override
    public void deletePhoto(Long id) {
        Photo photoDB = getPhotoById(id);
        if (photoDB != null) {
            photoRepository.delete(photoDB);
        }
    }
}
