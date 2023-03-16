import processing.sound.*;

AudioIn mic;
float circleRadius;
Amplitude amp;
float volume;
int textX;
int textY;

void setup() {
  size(400, 400);
  background(#FFA07A);
  smooth();
  circleRadius = 0;
  mic = new AudioIn(this, 0);
  mic.start();
  textSize(36);
  textAlign(CENTER, CENTER);
  textX = width / 2;
  textY = height / 2 - 50;
  amp = new Amplitude(this);
  amp.input(mic);
}

void draw() {
  background(#FFA07A);
  fill(#FFA500);
  ellipse(width / 2, height / 2, circleRadius * 2, circleRadius * 2);
  circleRadius = map(amp.analyze(), 0, 1, 0, min(width, height) / 2);
  fill(0);
  if (circleRadius > 0) {
    text("Volume: " + round(amp.analyze() * 100), textX, textY);
  }
  
}
