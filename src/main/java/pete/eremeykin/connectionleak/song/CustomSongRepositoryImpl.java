package pete.eremeykin.connectionleak.song;

import lombok.AllArgsConstructor;
import org.postgresql.copy.CopyManager;
import org.postgresql.copy.CopyOut;
import org.postgresql.copy.PGCopyInputStream;
import org.postgresql.core.BaseConnection;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.stream.Stream;

@Repository
@AllArgsConstructor
class CustomSongRepositoryImpl implements CustomSongRepository {
    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public Stream<SongEntity> getAllStream() {
        return jdbcTemplate.queryForStream("""
                select id as id
                     , name as name
                     , artist as artist
                     , album_id as albumId
                from songs
                """, new DataClassRowMapper<>(SongEntity.class));
    }

    @Override
    public InputStream getAllCopy() {
        try {
            Connection connection = dataSource.getConnection();
            BaseConnection baseConnection = connection.unwrap(BaseConnection.class);
            CopyManager copyManager = new CopyManager(baseConnection);
            CopyOut copyOut = copyManager.copyOut("COPY songs TO STDOUT (HEADER, DELIMITER ',');");
            return new PGCopyInputStream(copyOut);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
