import RPi.GPIO as GPIO
import time
pin = 18
GPIO.setmode(GPIO.BCM)
GPIO.setup(pin, GPIO.OUT)
p = GPIO.PWM(pin,50) #channel(pin), frequency
p.start(0)
var = 1
try:
	while True:
		var = raw_input("input value")
		print float(var)
		p.ChangeDutyCycle(float(var))
		#p.ChangeFrequency(freq)   # where freq is the new frequency in Hz
		#p.ChangeDutyCycle(dc)  # where 0.0 <= dc <= 100.0
		time.sleep(1)
except KeyboardInterrput:
	p.stop()
	GPIO.cleanup()