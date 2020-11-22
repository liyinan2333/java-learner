package leoli.killtrycatch.service;

import leoli.killtrycatch.constant._enum.ResponseEnum;
import leoli.killtrycatch.bean.Licence;
import leoli.killtrycatch.repository.LicenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 业务service层
 *
 * @author leoli
 * @date 2020/10/12
 */
@Service
public class LicenceService {

    @Autowired
    LicenceRepository repository;

    /**
     * 校验{@link Licence}存在
     *
     * @param licence
     */
    protected void checkNotNull(Licence licence) {
        ResponseEnum.LICENCE_NOT_FOUND.assertNotNull(licence);
    }

    public Licence get(String id) {
        Optional<Licence> optional = repository.findById(id);
        ResponseEnum.LICENCE_NOT_FOUND.assertNotNull(optional.orElse(null));
        return optional.orElse(null);
    }

}