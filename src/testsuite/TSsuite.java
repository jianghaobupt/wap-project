package testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)  
@SuiteClasses({
	LinkTS.class,
	PageTS.class,
	WapTestSuite1.class
	})  
public class TSsuite {

}
