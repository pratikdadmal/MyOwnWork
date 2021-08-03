import java.util.logging.Logger;

public class LoggerExample {

	
	static Logger log = Logger.getLogger(LoggerExample.class.getName());
	static Logger log1 = Logger.getLogger(LoggerExample.class.getTypeName());
	public static void main(String[] args)throws Exception {
		
    log.info("This is just Info Message for Login page");
    log.warning("This is warning for code");
    log1.info("Type is name Message");
    log1.warning("Type name warning");
    
    
		
	}
	
}
