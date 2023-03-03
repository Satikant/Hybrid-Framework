package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

    int retryCount;
    int maxRetryCount;

    public boolean retry(ITestResult result) {
        if(retryCount < maxRetryCount){
            retryCount++;
            return true;
        }
        return false;
    }
}
