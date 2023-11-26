package pete.eremeykin.connectionleak.album;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pete.eremeykin.connectionleak.album.api.AlbumDto;

import java.time.Duration;
import java.util.UUID;

@Transactional
@Service
class SlowAlbumService {
    private final Duration delay;
    private final AlbumRepository repository;
    private final AlbumMapper mapper;

    public SlowAlbumService(AlbumRepository repository,
                            AlbumMapper mapper,
                            @Value("${album.service.delay}")
                            Duration delay) {
        this.delay = delay;
        this.repository = repository;
        this.mapper = mapper;
    }

    @SneakyThrows
    AlbumDto getSlowlyById(UUID albumId) {
        Thread.sleep(delay.toMillis());
        return repository.findById(albumId)
                .map(mapper::toDto).orElseThrow();
    }

}
