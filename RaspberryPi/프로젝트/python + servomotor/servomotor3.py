import RPi.GPIO as GPIO
import time
pin = 18
GPIO.setmode(GPIO.BCM)
GPIO.setup(pin, GPIO.OUT)
p = GPIO.PWM(pin,50)
p.start(0.0)
var = 1

def change(k):
	p.ChangeDutyCycle(k)
	time.sleep(1)
    
    
try:
	while True:
		k = float(raw_input("enter angle: "))
		k = (1+(float(k)/180))/20
		change(k)
except KeyboardInterrput:
	p.stop()
	GPIO.cleanup()
	exit