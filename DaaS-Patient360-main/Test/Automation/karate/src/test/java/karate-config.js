
function init () {
  var env = karate.env; // get system property 'karate.env'
  
  karate.log ('karate.env system property was:', env);
  if (!env) {
    env = 'cicd';
  }
  else {
  	env = 'dev';
  }

  var configFile = 'classpath:' + env + '.json';
  try {
      config = karate.read (configFile);
      karate.configure ('connectTimeout', 900000);
      karate.configure ('readTimeout', 900000);
      if (config.enable_proxy) {
          karate.configure ('proxy', config.proxy);
      }
      
      config.authInfo = {
      "iam_uname" : karate.properties['karate.IAM_USN'],
      "iam_pword" : karate.properties['karate.IAM_PWD'],
      "username" :  karate.properties['karate.OAUTH2_CLIENT_ID'],
      "password" :  karate.properties['karate.OAUTH2_CLIENT_PWD']
  	  };
  		

  } catch (e) {
      karate.log ("Failed to initialize test setup configuration - ", e);
  }
  return config;
}