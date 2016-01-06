import time 
from RPIO import PWM
servo = PWM.Servo()
# Set servo on GPIO17 to 900.s (0.9ms)
servo.set_servo(4, 900)
# Set servo on GPIO17 to 2000.s (2.0ms)
#servo.set_servo(17, 2000)
try:
	while True:
		servo.set_servo(4, 750)
		print "Left"
		time.sleep(5)
		servo.set_servo(4, 1500)
		print "Center"
		time.sleep(5)
		print "Right"
		servo.set_servo(4, 2500)
		time.sleep(5)
except KeyboardInterrupt:
	# Clear servo on GPIO17
	servo.stop_servo(4)