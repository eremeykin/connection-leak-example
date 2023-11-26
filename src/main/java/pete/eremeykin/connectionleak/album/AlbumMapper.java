package pete.eremeykin.connectionleak.album;

import org.springframework.stereotype.Component;
import pete.eremeykin.connectionleak.album.api.AlbumDto;

@Component
class AlbumMapper {

    AlbumDto toDto(AlbumEntity entity) {
        return new AlbumDto(
                entity.getId(),
                entity.getName(),
                entity.getYear()
        );
    }
}
