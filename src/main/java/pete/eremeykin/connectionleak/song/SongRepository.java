package pete.eremeykin.connectionleak.song;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface SongRepository extends CustomSongRepository, JpaRepository<SongEntity, UUID> {
}
