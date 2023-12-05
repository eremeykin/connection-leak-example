package pete.eremeykin.connectionleak.song;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pete.eremeykin.connectionleak.album.api.AlbumClient;
import pete.eremeykin.connectionleak.album.api.AlbumDto;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
class SongService {
    private final AlbumClient albumClient;
    private final SongRepository repository;
    private final SongMapper mapper;


    public List<SongDto> getAllOk() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public List<SongDto> getAllStream() {
        return repository.getAllStream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public InputStream getAllRawConnection() {
        return repository.getAllCopy();
    }

    @Transactional
    public List<SongWithAlbumDto> getAllExternalInvocation() {
        return repository.findAll()
                .stream()
                .map(songEntity -> {
                    AlbumDto album = albumClient.getById(songEntity.getAlbumId());
                    return mapper.toDtoWithAlbum(songEntity, album);
                })
                .toList();
    }

}
