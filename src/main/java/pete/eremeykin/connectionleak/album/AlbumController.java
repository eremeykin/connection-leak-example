package pete.eremeykin.connectionleak.album;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pete.eremeykin.connectionleak.album.api.AlbumDto;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("album")
class AlbumController {
    private final SlowAlbumService slowService;

    @GetMapping("/{albumId}")
    AlbumDto getById(@PathVariable UUID albumId) {
        return slowService.getSlowlyById(albumId);
    }

}
