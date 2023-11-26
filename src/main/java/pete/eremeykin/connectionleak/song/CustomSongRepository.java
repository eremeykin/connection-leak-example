package pete.eremeykin.connectionleak.song;

import java.io.InputStream;
import java.util.stream.Stream;

interface CustomSongRepository {

    Stream<SongEntity> getAllStream();

    InputStream getAllCopy();

}
