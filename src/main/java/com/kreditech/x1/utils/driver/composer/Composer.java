package com.kreditech.x1.utils.driver.composer;

import com.kreditech.x1.utils.report.ReportUtils;
import io.vavr.control.Try;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

import static com.kreditech.x1.utils.report.ReportUtils.log;
import static com.kreditech.x1.utils.report.ReportUtils.logError;
import static com.kreditech.x1.utils.report.ReportUtils.takeScreenshot;

public class Composer {

    public static void of(Runnable runnable, String message) {
        Try.run(() -> {
            takeScreenshot();
            log(message);
        })
                .andThen(runnable).andFinally(ReportUtils::takeScreenshot)
                .onFailure(throwable -> logError(throwable.getMessage()));
    }

    public static <T> T of(Supplier<T> supplier, String message) {
        return Try.ofSupplier(() -> {
            takeScreenshot();
            log(message);
            return supplier.get();
        })
                .andFinally(ReportUtils::takeScreenshot)
                .onFailure(throwable -> logError(throwable.getMessage()))
                .get();
    }

    public static <T> T ofActions(Callable<T> callable) {
        return Try.ofCallable(callable).get();
    }

    public static void ofActions(Runnable runnable) {
        Try.runRunnable(runnable);
    }
}