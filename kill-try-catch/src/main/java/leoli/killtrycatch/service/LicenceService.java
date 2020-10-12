package leoli.killtrycatch.service;

import leoli.killtrycatch.constant._enum.ResponseEnum;
import leoli.killtrycatch.bean.Licence;

/**
 * 业务service层
 *
 * @author leoli
 * @date 2020/10/12
 */
public class LicenceService {

    /**
     * 校验{@link Licence}存在
     *
     * @param licence
     */
    protected void checkNotNull(Licence licence) {
        ResponseEnum.LICENCE_NOT_FOUND.assertNotNull(licence);
    }

}