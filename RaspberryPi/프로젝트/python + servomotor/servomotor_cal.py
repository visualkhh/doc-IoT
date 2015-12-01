import RPi.GPIO as GPIO
import time
pin = 7
frequencyHertz = 50
msPerCycle = 1000 / frequencyHertz;

# position
leftPosition = 0.75
rightPosition = 2.5
middlePosition = (leftPosition - rightPosition) / 2 + rightPosition

# list
positionList = [leftPosition, middlePosition, rightPosition, middlePosition]

# GPIO setting
GPIO.setmode(GPIO.BOARD)
GPIO.setup(pin, GPIO.OUT)
p = GPIO.PWM(pin,frequencyHertz)

for i in range(3):
	for position in positionList:
		dutyCyclePercentage = position * 100 / msPerCycle
		print "position:"+str(position)
		print "duty cycle:"+str(dutyCyclePercentage)
		print ""
		p.start(dutyCyclePercentage)
		time.sleep(5)
		
		