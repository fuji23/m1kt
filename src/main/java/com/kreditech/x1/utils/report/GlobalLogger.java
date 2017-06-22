package com.kreditech.x1.utils.report;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class GlobalLogger {

    private GlobalLogger() {
    }

    private static ThreadLocal<Map<Long, Logger>> instance = ThreadLocal.withInitial(HashMap::new);

    public static synchronized Logger getLogger() {
        long id = Thread.currentThread().getId();
        if (!instance.get().containsKey(id)) {
            instance.get().put(id, Logger.getLogger(String.valueOf(id)));
        }
        return instance.get().get(id);
    }

    public static synchronized void removeLogger() {
        instance.get().remove(Thread.currentThread().getId());
    }
}