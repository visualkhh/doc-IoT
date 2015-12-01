import RPi.GPIO as GPIO
import time
pinList = [7,11,13,15]
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
pList = []
for pin in pinList:
	GPIO.setup(pin, GPIO.OUT)
	pList.append(GPIO.PWM(pin,frequencyHertz))

print len(pList)

for i in range(3):
	for position in positionList:
		dutyCyclePercentage = position * 100 / msPerCycle
		print "position:"+str(position)
		print "duty cycle:"+str(dutyCyclePercentage)
		print ""
		for p in pList:
			print p
			p.start(dutyCyclePercentage)
		time.sleep(5)
		
		