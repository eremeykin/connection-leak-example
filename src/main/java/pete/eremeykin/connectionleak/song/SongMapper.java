package pete.eremeykin.connectionleak.song;

import org.springframework.stereotype.Component;
import pete.eremeykin.connectionleak.album.api.AlbumDto;

@Component
class SongMapper {

    SongDto toDto(SongEntity entity) {
        return new SongDto(
                entity.getId(),
                entity.getName(),
                entity.getArtist(),
                entity.getAlbumId()
        );
    }

    public SongWithAlbumDto toDtoWithAlbum(SongEntity entity, AlbumDto albumDto) {
        return new SongWithAlbumDto(
                entity.getId(),
                entity.getName(),
                entity.getArtist(),
                albumDto
        );
    }
}
