/*
  Web client
 
 This sketch connects to a website (http://www.google.com)
 using an Arduino Wiznet Ethernet shield. 
 
 Circuit:
 * Ethernet shield attached to pins 10, 11, 12, 13
 
 created 18 Dec 2009
 by David A. Mellis
 modified 9 Apr 2012
 by Tom Igoe, based on work by Adrian McEwen
 
 */

// #include <SPI.h>
// #include <Ethernet.h>

//Button related var
int val = 0;          // val will be used to store the state of the input pin
int oldval = 0;

//button
const int BT = 9;

const int ledPin0 = 5;
const int ledPin1 = 6;
const int ledPin2 = 7;
const int ledPin3 = 8; //Sets pins for leds
int money = 10; //money owns by arduino

void setup() {
 Serial.begin(115200);
  
 pinMode(ledPin0, OUTPUT);
 pinMode(ledPin1, OUTPUT);
 pinMode(ledPin2, OUTPUT);
 pinMode(ledPin3, OUTPUT); // Sets the leds output
 
 pinMode(BT, INPUT); //pin for button
 
 
}

void loop(){
  
  oldval = val;
  val = digitalRead(BT); // read input value and store it
  
  
  if(money == 0){
    money = 10;      
  }
  
  if((val == HIGH) && (oldval == LOW)) {
    money -= 1;
    ledOutput();
  } else if((val == LOW) && (oldval == HIGH)) {
    money -= 1;
    ledOutput();
  }
  
}

void ledOutput(){

  if (money == 10){
    digitalWrite(ledPin0, LOW);
    digitalWrite(ledPin1, HIGH);
    digitalWrite(ledPin2, LOW);
    digitalWrite(ledPin3, HIGH);
  }
  
  if (money == 9){
    digitalWrite(ledPin0, HIGH);
    digitalWrite(ledPin1, LOW);
  }
  
  if (money == 8){
    digitalWrite(ledPin0, LOW);
  }
  
  if (money == 7){
    digitalWrite(ledPin0, HIGH);
    digitalWrite(ledPin1, HIGH);
    digitalWrite(ledPin2, HIGH);
    digitalWrite(ledPin3, LOW);
  }
  
  if (money == 6){
    digitalWrite(ledPin0, LOW);
  }
  
  if (money == 5){
    digitalWrite(ledPin0, HIGH);
    digitalWrite(ledPin1, LOW);
  }
  
  if (money == 4){
    digitalWrite(ledPin0, LOW);
  }
  
  if (money == 3){
    digitalWrite(ledPin0, HIGH);
    digitalWrite(ledPin1, HIGH);
    digitalWrite(ledPin2, LOW);
  }
  
  if (money == 2){
    digitalWrite(ledPin0, LOW);
  }
  
  if (money == 1){
    digitalWrite(ledPin0, HIGH);
    digitalWrite(ledPin1, LOW);
  }
  
  if (money == 0){
    digitalWrite(ledPin0, LOW);
  }  
  
}
