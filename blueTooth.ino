#include <NewPing.h>
#include <Servo.h>
#include <SoftwareSerial.h>

#define TRIG_PIN 2
#define ECHO_PIN 3
#define MAX_DISTANCE 200

#define TRIG_PIN_LEFT 30
#define ECHO_PIN_LEFT 31

#define TRIG_PIN_RIGHT 10
#define ECHO_PIN_RIGHT 11

#define TRIG_PIN_UP 12
#define ECHO_PIN_UP 13

int movementType = 0; // 记录运动类型（0：停止，1：左转，2：右转，3：后转）
unsigned long startTime = 0;// 开始运动的时间
unsigned long movementStartTime = 0; // 记录运动开始时间

SoftwareSerial bluetooth(19, 18); // 配置蓝牙模块的TX和RX引脚
NewPing sonar(TRIG_PIN, ECHO_PIN, MAX_DISTANCE);
NewPing sonarLeft(TRIG_PIN_LEFT, ECHO_PIN_LEFT, MAX_DISTANCE);
NewPing sonarRight(TRIG_PIN_RIGHT, ECHO_PIN_RIGHT);
NewPing sonarUp(TRIG_PIN_UP, ECHO_PIN_UP, MAX_DISTANCE);

int distance = 100;
int distanceUp=100;
void setup() {
  // Set up motors
  pinMode(7, OUTPUT);  // Left motors forward
  pinMode(6, OUTPUT);  // Left motors reverse
  pinMode(5, OUTPUT);  // Right motors forward
  pinMode(4, OUTPUT);  // Right motors reverse
  
  // Initialize Serial communication
  Serial.begin(9600);
  bluetooth.begin(9600); 
  
  delay(60);
}

void loop() {
  int distanceR = 0;
  int distanceL = 0;
  distance = readPing();
  distanceUp = readPingUp();

if(distanceUp-distance<=12){ //未找到宝藏
  if (distance <= 20) {  // 防止前方碰撞
    moveStop();
    delay(100);
    moveBackward();
    delay(40);
    moveStop();
    delay(100);
    distanceL = readPingLeft();
    delay(50);
    distanceR = readPingRight();
    delay(50);

    if (distanceR >= distanceL) {
      if (distanceR <= 15 && distanceL <= 15) {  // 若两边都没有路
        moveStop();
        delay(10000);//前左右都有障碍物时停顿，拍照
        for (int i = 0; i < 2; i++) {            // Turn around
          turnLeft();
          moveStop();
          delay(100);
        }
        startTime = millis();
         movementStartTime = startTime;
         movementType = 3; // 设置运动类型为3,即后转
         bluetooth.begin(9600);
         bluetooth.println("3");
        bluetooth.println(movementStartTime);
        bluetooth.end();
        Serial.begin(9600);
        Serial.println("3");
         Serial.println(movementStartTime);
      } else {
        
        turnLeft();
        startTime = millis();
         movementStartTime = startTime;
         movementType = 2; // 设置运动类型为2,即右转
         bluetooth.begin(9600);
         bluetooth.println("2");
        bluetooth.println(movementStartTime);
        bluetooth.end();
        Serial.begin(9600);
        Serial.println("2");
         Serial.println(movementStartTime);
         Serial.end();
        moveStop();
        delay(100);
      }
    } else if (distanceR < distanceL) {
      if (distanceR < 15 && distanceL <= 15) {  // 若两边都没有路
        moveStop();
        delay(10000);//前左右都有障碍物时停顿，拍照       
        for (int i = 0; i < 2; i++) {           // Turn around
          turnRight();
          moveStop();
          delay(100);
        }
        startTime = millis();
         movementStartTime = startTime;
         movementType = 3; // 设置运动类型为3,即后转
         bluetooth.begin(9600);
         bluetooth.println("3");
        bluetooth.println(movementStartTime);
        bluetooth.end();
        Serial.begin(9600);
        Serial.println("3");
         Serial.println(movementStartTime);
          Serial.end();
      } else {
        turnRight();
        startTime = millis();
         movementStartTime = startTime;
         movementType = 1; // 设置运动类型为1,即左转
         bluetooth.begin(9600);
         bluetooth.println("1");
        bluetooth.println(movementStartTime);
        bluetooth.end();
        Serial.begin(9600);
        Serial.println("1");
         Serial.println(movementStartTime);
          Serial.end();
        moveStop();
        delay(100);
      }
    }
  } else {  //  直走
    moveForward();
    Serial.begin(9600);
    Serial.end();
  }
  }

if(distanceUp-distance>1000&&distance<=45){ //找到宝藏
  moveStop();
  delay(10000);
  turnLeft();
  turnLeft();
  bluetooth.begin(9600);// 设置运动类型为3,即后转
  bluetooth.println("3");
  bluetooth.println(movementStartTime);
  bluetooth.end();
  Serial.begin(9600);
  Serial.println("3");
   Serial.println(movementStartTime);

    Serial.end();
  delay(100);
}

  /*Serial.print("Front Distance: ");
  Serial.print(distance);
  Serial.print(" cm\t");
  Serial.print("Left Distance: ");
  Serial.print(distanceL);
  Serial.print(" cm\t");
  Serial.print("Right Distance: ");
  Serial.print(distanceR);
  Serial.println(" cm\t");
  Serial.print("Upper Distance: ");
  Serial.print(distanceUp);
  Serial.println(" cm\t");*/
}

int readPing() {
  int cm = sonar.ping_cm();
  if (cm == 0) {
    cm = MAX_DISTANCE;
  }
  return cm;
}

int readPingUp() {
  int cm = sonarUp.ping_cm();
  if (cm == 0) {
    cm = MAX_DISTANCE;
  }
  return cm;
}

int readPingLeft() {
  int cm = sonarLeft.ping_cm();
  if (cm == 0) {
    cm = MAX_DISTANCE;
  }
  return cm;
}

int readPingRight() {
  int cm = sonarRight.ping_cm();
  if (cm == 0) {
    cm = MAX_DISTANCE;
  }
  return cm;
}

void moveStop() {
  digitalWrite(7, LOW);
  digitalWrite(6, LOW);
  digitalWrite(5, LOW);
  digitalWrite(4, LOW);
}

void moveForward() {
  digitalWrite(7, HIGH);
  digitalWrite(5, HIGH);
}

void moveBackward() {
  digitalWrite(6, HIGH);
  digitalWrite(4, HIGH);
}

void turnRight() {
  digitalWrite(7, LOW);
  digitalWrite(6, HIGH);
  digitalWrite(5, HIGH);
  digitalWrite(4, LOW);
  delay(380);
  moveStop();
 
}

void turnLeft() {
  digitalWrite(7, HIGH);
  digitalWrite(6, LOW);
  digitalWrite(5, LOW);
  digitalWrite(4, HIGH);
  delay(410);
  moveStop();
}