package testsuite;

import org.junit.runner.RunWith;  
import org.junit.runners.Suite;  
import org.junit.runners.Suite.SuiteClasses;  

import com.tyyd.waptest.*;
 
/**
 * TS for login, search and rank function 
 * @author jianghao1105
 *
 */
@RunWith(Suite.class)  
@SuiteClasses({
	tyyd_wap_display_1001.class,
	tyyd_wap_display_1002.class,
	tyyd_wap_display_1003.class,
	tyyd_wap_display_1004.class,
	tyyd_wap_login_2003.class,
	tyyd_wap_search_1001.class,
	tyyd_wap_search_1002.class,
	tyyd_wap_rank_2001.class,
	tyyd_wap_rank_2002.class,
	tyyd_wap_rank_2003.class,
	tyyd_wap_rank_2004.class,
	tyyd_wap_rank_2005.class,
	tyyd_wap_rank_2006.class,
	tyyd_wap_rank_2007.class,
	tyyd_wap_rank_2008.class,
	tyyd_wap_rank_2009.class
	})  
public class WapTestSuite1 {

}
