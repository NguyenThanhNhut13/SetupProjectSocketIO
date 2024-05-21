/*
 * @ (#) AppUtils.java       1.0     21/05/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package util;
/*
 * @description:
 * @author: Nguyen Thanh Nhut
 * @date: 21/05/2024
 * @version:    1.0
 */

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class AppUtils {
    public static final String PERSISTENCE_UNIT_NAME = "MSSQL";
    public static final int PORT = 40001;

    public static EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
    }
}
