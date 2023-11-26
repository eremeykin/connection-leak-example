
package pete.eremeykin.connectionleak.album.api;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(value = "album.client.url", matchIfMissing = false)
@EnableFeignClients(basePackageClasses = AlbumClient.class)
class AlbumClientConfiguration {
}
