int joystickSelState = 0;
int joystickXState, joystickYState ;
const int joystickY =  26;
void setup() {
pinMode(40,OUTPUT);
pinMode(5, INPUT_PULLUP);
analogReadResolution(12);
}

void loop() {
  // put your main code here, to run repeatedly: 
  joystickSelState = digitalRead(5);
  if (joystickSelState == LOW) { 
    joystickYState = analogRead(joystickY);
    tone(40, joystickYState, 100);
  }
  delay(100);
}
