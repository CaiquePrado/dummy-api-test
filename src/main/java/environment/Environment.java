package environment;

import static constants.ApplicationConstants.ENV;
import static constants.ApplicationConstants.UAT;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access =  AccessLevel.PRIVATE)
public class Environment {
  
  public static String getEnvironment(){
    String environment = System.getenv(ENV);
    if(environment != null){
      System.getProperty(ENV,environment);
    }
    return System.getProperty(ENV, UAT);
  }
}

