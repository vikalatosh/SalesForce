package tests.base;

import lombok.extern.log4j.Log4j2;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

@Log4j2
public class Retry implements IRetryAnalyzer {

    private static final int MAX_RETRY = 3;
    private int attempt = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (attempt < MAX_RETRY) {
                attempt++;
                iTestResult.setStatus(ITestResult.FAILURE);
                System.out.println("Retrying once again");
                return true;
            } else {
                log.debug("Test Failed");
                iTestResult.setStatus(ITestResult.FAILURE);
            }
        } else {
            log.debug("Test Passed");
            iTestResult.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }
}

