package pete.eremeykin.connectionleak.album.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class AlbumDto {
    private UUID id;
    private String name;
    private Integer year;
}
