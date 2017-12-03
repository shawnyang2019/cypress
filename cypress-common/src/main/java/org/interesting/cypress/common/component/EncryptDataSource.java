package org.interesting.cypress.common.component;

import com.alibaba.druid.pool.DruidDataSource;
import org.interesting.cypress.common.utils.EncryptUtils;

public class EncryptDataSource extends DruidDataSource {

    @Override
    public void setPassword(String password) {
        // 解密后重置
        String newPassword = EncryptUtils.decodeBase64String(password);
        super.setPassword(newPassword);
    }
}
