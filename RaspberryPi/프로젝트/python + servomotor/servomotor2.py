import RPi.GPIO as GPIO
import time
pin = 18
GPIO.setmode(GPIO.BCM)
GPIO.setup(pin, GPIO.OUT)
p = GPIO.PWM(pin,50)
p.start(12.5)
time.sleep(0.5)
p.stop()
p.start(7.5)
time.sleep(0.5)
p.stop
p.start(10.0)
time.sleep(0.5)
p.stop()
var = 1
try:
	while True:
		var = raw_input("Enter L / R / C: ")
		if var == 'R':
			print 'R'
			p.start(2.5)
			time.sleep(1)
			p.stop()
		elif var == 'L':
			print 'L'
			p.start(12.5)
			time.sleep(1)
			p.stop()
		elif var == 'C':
			print 'C'
			p.start(7.5)
			time.sleep(1)
			p.stop()
except KeyboardInterrput:
	GPIO.cleanup()