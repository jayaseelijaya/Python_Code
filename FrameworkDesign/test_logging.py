import logging



def test_logging():
   logger =  logging.getLogger(__name__)
   filehanler = logging.FileHandler("logfile.log")
   formatter = logging.Formatter(" %(asctime)s : %(levelname)s : %(name)s : %(message)s ")

   filehanler.setFormatter(formatter)
   logger.addHandler(filehanler)
   logger.setLevel(logging.DEBUG)

   logger.debug("debug")
   logger.info("Information of the testcase")
   logger.error("Error")
   logger.critical("critical message")
