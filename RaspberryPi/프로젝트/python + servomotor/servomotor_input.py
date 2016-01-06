import RPi.GPIO as GPIO
import time
pin = 4
GPIO.setmode(GPIO.BCM)
GPIO.setup(pin, GPIO.OUT)
p = GPIO.PWM(pin,100)
p.start(5)
var = 1

def change(k):
	p.ChangeDutyCycle(k)
	time.sleep(1)

try:
	while True:
		k = float(raw_input("enter angle: "))
		#k = (1+(float(k)/180))/20
		k = float(k) / 10.0 + 2.5
		print k;
		#change(k)
except KeyboardInterrput:
	p.stop()
	GPIO.cleanup()
	exit