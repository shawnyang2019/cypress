package org.interesting.cypress.common.component;

import org.apache.commons.dbcp.BasicDataSource;
import org.interesting.cypress.common.utils.EncryptUtils;

public class EncryptDataSource extends BasicDataSource {

    @Override
    public void setPassword(String password) {
        // 解密后重置
        String newPassword = EncryptUtils.decodeBase64String(password);
        super.setPassword(newPassword);
    }
}
