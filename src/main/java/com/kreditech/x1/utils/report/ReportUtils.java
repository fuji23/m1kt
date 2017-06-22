package com.kreditech.x1.utils.report;

import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.File;
import java.io.IOException;

import static com.kreditech.x1.utils.report.GlobalLogger.getLogger;

public class ReportUtils {

    private ReportUtils() {
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public static synchronized byte[] takeScreenshot() {
        File file = Screenshots.takeScreenShotAsFile();
        byte[] bytes = new byte[0];
        try {
            bytes = Files.toByteArray(file);
        } catch (Exception e) {
            getLogger().warning("Screenshot can't be created.");
            getLogger().warning(e.fillInStackTrace().toString());
        }
        return bytes;
    }

    @Attachment(value = "Log file", type = "text/plain")
    public static synchronized byte[] attachLogFile(String path) {
        byte[] bytes = new byte[0];
        try {
            bytes = Files.toByteArray(new File(path));
        } catch (IOException e) {
            getLogger().warning("Log file can't be created.");
            getLogger().warning(e.fillInStackTrace().toString());
        }
        return bytes;
    }

    @Attachment(value = "Error detailed message", type = "text/plain")
    public static synchronized byte[] logError(String message) {
        getLogger().warning(message);
        return message.getBytes();
    }

    public static void log(String message) {
        getLogger().info(message);
    }

    public static void step(int number, String message) {
        getLogger().info(String.format("[STEP %s]. %s.", String.valueOf(number), message));
    }
}