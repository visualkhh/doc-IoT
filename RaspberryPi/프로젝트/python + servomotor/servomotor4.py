import RPi.GPIO as GPIO
import time
pin = 18
GPIO.setmode(GPIO.BCM)
GPIO.setup(pin, GPIO.OUT)
p = GPIO.PWM(pin,50)
p.start(0.0)
var = 1
try:
	while True:
		var = raw_input("input value")
		print float(var)
		p.start(float(var))
		time.sleep(1)
except KeyboardInterrput:
	p.stop()
	GPIO.cleanup()