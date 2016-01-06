import RPi.GPIO as GPIO
import time
GPIO.setmode(GPIO.BCM)
GPIO.setup(4,GPIO.OUT)
p=GPIO.PWM(4,50)
p.start(7.5)
try:
	while True:
		p.ChangeDutyCycle(7.5)
		print "Left"
		time.sleep(5)
		p.ChangeDutyCycle(12.5)
		print "Center"
		time.sleep(5)
		p.ChangeDutyCycle(2.5)
		print "Right"
		time.sleep(5)
except KeyboardInterrupt:
	p.stop()
	GPIO.cleanup()