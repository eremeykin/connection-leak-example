package pete.eremeykin.connectionleak.song;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
class SongDto {
    private final UUID id;
    private final String name;
    private final String artist;
    private final UUID albumId;
}
