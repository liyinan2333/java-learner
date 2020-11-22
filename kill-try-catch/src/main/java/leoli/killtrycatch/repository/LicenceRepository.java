package leoli.killtrycatch.repository;

import leoli.killtrycatch.bean.Licence;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Licence持久化类
 *
 * @author leoli
 * @date 2020/10/16
 */
public interface LicenceRepository extends JpaRepository<Licence, String> {

}