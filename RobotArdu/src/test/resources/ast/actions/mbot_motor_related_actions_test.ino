// This file is automatically generated by the Open Roberta Lab.

#define ANALOG2PERCENT 0.0978

#include <MeMCore.h>
#include <MeDrive.h>
#include <NEPODefs.h>

MeDrive _meDrive(M1, M2);
MeDCMotor _meDCmotor1(M1);
MeDCMotor _meDCmotor2(M2);

void setup()
{
    Serial.begin(9600); 
}

void loop()
{
    _meDrive.drive(60, 1, 500);
    _meDrive.drive(60, 0, 500);
    _meDrive.drive(60, 1);
    _meDrive.drive(60, 0);
    _meDrive.turn(60, 0, 500);
    _meDrive.turn(60, 1, 500);
    _meDrive.turn(60, 0);
    _meDrive.turn(60, 1);
    _meDrive.steer(50, 80, 1, 500);
    _meDrive.steer(50, 80, 0, 500);
    _meDrive.steer(50, 80, 1);
    _meDrive.steer(50, 80, 0);
    _meDCmotor1.run(-1*(60)*255/100);
    delay(500);
    _meDCmotor1.stop();
    _meDCmotor2.run((60)*255/100);
    delay(500);
    _meDCmotor2.stop();
    _meDCmotor1.run(-1*(60)*255/100);
    _meDCmotor2.run((60)*255/100);
    _meDCmotor1.stop();
    _meDCmotor2.stop();
    _meDrive.stop();
}