import 'dart:io';

void main() {
  int A = 0, B = 0;
  var game = stdin.readLineSync()!;
  for (var i = 0; i < game.length; i += 2) {
    var result = gameResult(game[i], game[i + 1]);
    if (result == 1)
      A++;
    else if (result == -1) B++;
  }
  if (A > B) {
    print("A ชนะ $A - $B");
  } else if (A < B) {
    print("B ชนะ $B - $A");
  } else {
    print("เสมอ $A");
  }
}

int gameResult(String A, String B) {
  //RSP
  if (A == 'R' && B == 'R' || A == 'S' && B == 'S' || A == 'P' && B == 'P') {
    return 0;
  } else if (A == 'R' && B == 'S' ||
      A == 'S' && B == 'P' ||
      A == 'P' && B == 'R') {
    return 1;
  }
  return -1;
}
