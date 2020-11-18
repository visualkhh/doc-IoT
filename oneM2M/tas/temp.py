import datetime
import Adafruit_DHT as dht
pin = 2
h,t = dht.read_retry(dht.DHT11, pin)



print (t,',',h)
