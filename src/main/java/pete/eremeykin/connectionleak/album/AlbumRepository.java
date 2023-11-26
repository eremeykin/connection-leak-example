package pete.eremeykin.connectionleak.album;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface AlbumRepository extends JpaRepository<AlbumEntity, UUID> {
}
