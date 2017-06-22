package com.kreditech.x1.utils.listeners;

import com.kreditech.x1.utils.report.GlobalLogger;
import com.kreditech.x1.utils.report.ReportUtils;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogFileListener implements IInvokedMethodListener {

    private final String REPORTS_DIR = "target/";
    private FileHandler handler;

    private Logger getLogger() {
        return GlobalLogger.getLogger();
    }

    private void killLogger() {
        GlobalLogger.removeLogger();
    }

    private void createLogFile() {
        File file = new File(REPORTS_DIR + Thread.currentThread().getId());
        try {
            if (file.createNewFile()) {
                getLogger().info("Log file was created. With name >>>>>>>> " + Thread.currentThread().getId());
            } else {
                getLogger().warning("Log file can't be created.");
            }
        } catch (IOException e) {
            getLogger().warning("Log file can't be created.");
            getLogger().warning(e.fillInStackTrace().toString());
        }
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        createLogFile();
        try {
            handler = new FileHandler(REPORTS_DIR + Thread.currentThread().getId());
            handler.setFormatter(new SimpleFormatter());
            getLogger().addHandler(handler);
        } catch (IOException e) {
            getLogger().warning("Log file can't be created.");
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        ReportUtils.attachLogFile(REPORTS_DIR + Thread.currentThread().getId());
        killLogger();
    }
}