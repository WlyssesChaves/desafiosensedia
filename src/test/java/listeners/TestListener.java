package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        // Código executado antes de cada teste.
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Código executado após um teste passar.
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Código executado após um teste falhar.
    }
}

