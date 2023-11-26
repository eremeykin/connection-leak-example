package pete.eremeykin.connectionleak.song;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pete.eremeykin.connectionleak.album.api.AlbumDto;

import java.util.UUID;

@Getter
@AllArgsConstructor
class SongWithAlbumDto {
    private final UUID id;
    private final String name;
    private final String artist;
    private final AlbumDto albumDto;
}
