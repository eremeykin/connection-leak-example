package pete.eremeykin.connectionleak.song;

import lombok.AllArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("song")
class ConnectionLeakExampleController {
    private final SongService service;

    @GetMapping(value = "list", params = "trouble=stream")
    List<SongDto> getAllStream() {
        return service.getAllStream();
    }


    @GetMapping(value = "list", params = "trouble=rawConnection")
    ResponseEntity<InputStreamResource> getAllRawConnection() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=songs.csv");
        headers.setContentType(MediaType.parseMediaType("text/csv"));
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(service.getAllRawConnection()));
    }


    @GetMapping(value = "list", params = "trouble=externalInvocation")
    List<SongWithAlbumDto> getAllExternalInvocation() {
        return service.getAllExternalInvocation();
    }
}
