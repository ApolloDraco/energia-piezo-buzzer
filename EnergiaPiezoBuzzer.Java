/*
* This code is written for an Arduino board, using a joystick to generate a tone
*/

const int JOYSTICK_Y_PIN = 26;
const int BUZZER_PIN = 40;
const int JOYSTICK_BUTTON_PIN = 5;
const int TONE_DURATION = 100;

int joystickButtonState = 0;
int joystickYAxisValue;

void setup() {
  pinMode(BUZZER_PIN, OUTPUT);
  pinMode(JOYSTICK_BUTTON_PIN, INPUT_PULLUP);
  analogReadResolution(12);
}

void loop() {
  // Read the state of the joystick button
  joystickButtonState = digitalRead(JOYSTICK_BUTTON_PIN);

  // If the button is pressed, read the Y axis value and generate a tone
  if (joystickButtonState == LOW) { 
    joystickYAxisValue = analogRead(JOYSTICK_Y_PIN);
    tone(BUZZER_PIN, joystickYAxisValue, TONE_DURATION);
  }

  // Wait for a short period before repeating the loop
  delay(100);
}
